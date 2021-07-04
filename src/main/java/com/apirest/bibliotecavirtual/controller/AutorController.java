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

import com.apirest.bibliotecavirtual.controller.Dto.AutorDto;
import com.apirest.bibliotecavirtual.models.AutorModel;
import com.apirest.bibliotecavirtual.repository.AutorRepository;

@RestController
@RequestMapping("/v1/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping()
	public List<AutorModel> obterAutores() {
		return autorRepository.findAll();
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<AutorModel> alterarAutor(@PathVariable long id, @RequestBody @Valid AutorDto atualizaAutor) {
		Optional<AutorModel> optional = autorRepository.findById(id);
		if (optional.isPresent()) {
			AutorModel autorAtualizado = atualizaAutor.atualizar(id, autorRepository);
			return ResponseEntity.ok(autorAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/salvar")
	@Transactional
	public ResponseEntity<AutorModel> salvarAutor(@RequestBody @Valid AutorModel nome, UriComponentsBuilder builder) {
		autorRepository.save(nome);
		URI uri = builder.path("/v1/autor/salvar/{id}").buildAndExpand(nome.getId()).toUri();
		return ResponseEntity.created(uri).body(nome);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarAutorPorId(@PathVariable Long id) {
		Optional<AutorModel> optional = autorRepository.findById(id);
		if (optional.isPresent()) {
			autorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
