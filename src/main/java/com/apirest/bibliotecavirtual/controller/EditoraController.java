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

	@GetMapping("/{id}")
	public Optional<EditoraModel> EditoraId(@PathVariable(value = "id") Long id) {
		return editoraRepository.findById(id);
	}

	@PutMapping
	@RequestMapping("/alterar")
	public EditoraModel alterarEditora(@RequestBody EditoraModel nomeEditora) {
		return editoraRepository.save(nomeEditora);
	}

	@PostMapping("/salvar")
	@Transactional
	public ResponseEntity<EditoraModel> salvarEditora(@RequestBody @Valid EditoraModel nomeEditora, UriComponentsBuilder builder) {
		editoraRepository.save(nomeEditora);
		URI uri = builder.path("/v1/editora/salvar/{id}").buildAndExpand(nomeEditora.getId()).toUri();
		return ResponseEntity.created(uri).body(nomeEditora);
	}

	@DeleteMapping
	@RequestMapping("/delete")
	public void deletarEditoraPorId(@RequestBody EditoraModel nomeEditora) {
		editoraRepository.delete(nomeEditora);
	}

}
