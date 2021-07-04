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

import com.apirest.bibliotecavirtual.controller.Dto.EditoraDto;
import com.apirest.bibliotecavirtual.models.EditoraModel;
import com.apirest.bibliotecavirtual.repository.EditoraRepository;

@RestController
@RequestMapping("/v1/editora")
public class EditoraController {
	
	@Autowired
	private EditoraRepository editoraRepository;

	@GetMapping()
	public List<EditoraModel> obterEditora() {
		return editoraRepository.findAll();
	}
	
	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<EditoraModel> alterarEditora(@PathVariable long id, @RequestBody @Valid EditoraDto atualizaEditora) {
		Optional<EditoraModel> optional = editoraRepository.findById(id);
		if (optional.isPresent()) {
			EditoraModel editoraAtualizado = atualizaEditora.atualizar(id, editoraRepository);
			return ResponseEntity.ok(editoraAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/salvar")
	@Transactional
	public ResponseEntity<EditoraModel> salvarEditora(@RequestBody @Valid EditoraModel nome, UriComponentsBuilder builder) {
		editoraRepository.save(nome);
		URI uri = builder.path("/v1/editora/salvar/{id}").buildAndExpand(nome.getId()).toUri();
		return ResponseEntity.created(uri).body(nome);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarEditoraPorId(@PathVariable Long id) {
		Optional<EditoraModel> optional = editoraRepository.findById(id);
		if (optional.isPresent()) {
			editoraRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
