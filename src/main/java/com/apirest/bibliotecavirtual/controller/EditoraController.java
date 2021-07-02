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

import com.apirest.bibliotecavirtual.models.EditoraModel;
import com.apirest.bibliotecavirtual.repository.EditoraRepository;

@RestController
@RequestMapping("/editora")
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
	public EditoraModel alterarEditora(@RequestBody EditoraModel editora) {
		return editoraRepository.save(editora);
	}

	@PostMapping
	@RequestMapping("/salvar")
	public EditoraModel salvarEditora(@RequestBody EditoraModel editora) {
		return editoraRepository.save(editora);
	}

	@DeleteMapping
	@RequestMapping("/delete")
	public void deletarEditoraPorId(@RequestBody EditoraModel editora) {
		editoraRepository.delete(editora);
	}

}
