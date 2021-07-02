package com.apirest.bibliotecavirtual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.bibliotecavirtual.models.LivroModel;
import com.apirest.bibliotecavirtual.repository.livroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private livroRepository livroRepository;

	@GetMapping
	public List<LivroModel> obterLivros() {
		return livroRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<LivroModel> obterLivroId(@PathVariable(value = "id") Long id) {
		return livroRepository.findById(id);
	}
	
	@GetMapping
	@RequestMapping("/busca")
	public List<LivroModel> obterLivroTitulo(String nomeLivro) {
		return livroRepository.findByTitulo(nomeLivro);
	}

	@PutMapping
	@RequestMapping("/alterar")
	public LivroModel alterarLivro(@RequestBody LivroModel livro) {
		return livroRepository.save(livro);
	}

	@PostMapping
	@RequestMapping("/salvar")
	public LivroModel salvarLivro(@RequestBody LivroModel livro) {
		return livroRepository.save(livro);
	}

	@DeleteMapping
	@RequestMapping("/delete")
	public void deletarEditoraPorId(@RequestBody LivroModel livro) {
		livroRepository.delete(livro);
	}
}
