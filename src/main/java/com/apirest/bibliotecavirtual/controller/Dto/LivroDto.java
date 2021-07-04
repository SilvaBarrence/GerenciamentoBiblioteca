package com.apirest.bibliotecavirtual.controller.Dto;

import com.apirest.bibliotecavirtual.models.LivroModel;

public class LivroDto {

	private String autor;
	private String editora;
	private String titulo;


	public LivroDto(LivroModel livro) {
		this.autor = livro.getAutor();
		this.editora = livro.getEditora();
		this.titulo = livro.getTitulo();
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
}
