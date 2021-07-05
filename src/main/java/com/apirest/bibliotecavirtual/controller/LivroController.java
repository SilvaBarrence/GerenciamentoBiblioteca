package com.apirest.bibliotecavirtual.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apirest.bibliotecavirtual.controller.Dto.LivroDto;
import com.apirest.bibliotecavirtual.models.LivroModel;
import com.apirest.bibliotecavirtual.repository.EditoraRepository;
import com.apirest.bibliotecavirtual.repository.LivroRepository;

@RestController
@RequestMapping("/v1/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;


	@GetMapping
	public List<LivroModel> obterLivros() {
		return livroRepository.findAll();
	}

	@GetMapping("/busca/autor/{autor}")
	public List<LivroModel> obterLivroPorAutor(@PathVariable String autor) {
		return livroRepository.findByAutor(autor);
	}

	@GetMapping("/busca/editora/{editora}")
	public List<LivroModel> obterLivroPorEditora(@PathVariable String editora) {
		return livroRepository.findByEditoraNome(editora);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroModel> obterLivroId(@PathVariable Long id) {
		Optional<LivroModel> optional = livroRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();	
		}
	}

	@GetMapping("/busca/titulo/{titulo}")
	public ResponseEntity<LivroModel> obterLivroTitulo(@PathVariable String titulo) {
		Optional<LivroModel> optional = livroRepository.findByTitulo(titulo);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<LivroModel> alterarLivro(@PathVariable long id,
			@RequestBody @Valid LivroDto atualizaLivro) {
		Optional<LivroModel> optional = livroRepository.findById(id);
		if (optional.isPresent()) {
			LivroModel livroAtualizado = atualizaLivro.atualizar(id, livroRepository);
			return ResponseEntity.ok(livroAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/salvar")
	@Transactional
	public ResponseEntity<LivroModel> salvarLivro(@RequestBody @Valid LivroModel livro, UriComponentsBuilder builder) {
		livroRepository.save(livro);
		URI uri = builder.path("/v1/livro/salvar/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarLivroPorId(@PathVariable Long id) {
		Optional<LivroModel> optional = livroRepository.findById(id);
		if (optional.isPresent()) {
			livroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/titulo/{titulo}")
	@Transactional
	public ResponseEntity<?> deletarEditoraPorTitulo(@PathVariable String titulo) {
		Optional<LivroModel> optional = livroRepository.findByTitulo(titulo);
		if (optional.isPresent()) {
			livroRepository.deleteByTitulo(titulo);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
