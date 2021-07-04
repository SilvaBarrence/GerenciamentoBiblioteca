package com.apirest.bibliotecavirtual.controller.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.apirest.bibliotecavirtual.models.AutorModel;
import com.apirest.bibliotecavirtual.repository.AutorRepository;

public class AutorDto {

	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AutorModel atualizar(long id, AutorRepository autorRepository) {
		AutorModel editora = autorRepository.getOne(id);
		editora.setNome(this.nome);

		return editora;
	}
	
}
