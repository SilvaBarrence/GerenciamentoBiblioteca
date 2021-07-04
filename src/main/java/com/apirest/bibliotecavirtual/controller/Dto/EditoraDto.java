package com.apirest.bibliotecavirtual.controller.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.apirest.bibliotecavirtual.models.EditoraModel;
import com.apirest.bibliotecavirtual.repository.EditoraRepository;

public class EditoraDto {

	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EditoraModel atualizar(long id, EditoraRepository editoraRepository) {
		EditoraModel editora = editoraRepository.getOne(id);
		editora.setNome(this.nome);

		return editora;
	}
	
	
}
