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

import com.apirest.bibliotecavirtual.models.AutorModel;
import com.apirest.bibliotecavirtual.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping()
	public List<AutorModel> obterAltores() {
		return autorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<AutorModel> autorId(@PathVariable(value = "id") Long id) {
		return autorRepository.findById(id);
	}

	@PutMapping
	public AutorModel alterarAutor(@RequestBody AutorModel autor) {
		return autorRepository.save(autor);
	}

	@PostMapping
	public AutorModel salvaAutor(@RequestBody AutorModel autor) {
		return autorRepository.save(autor);
	}

	@DeleteMapping
	public void deletarAutorPorId(@RequestBody AutorModel autor) {
		autorRepository.delete(autor);
	}

}
