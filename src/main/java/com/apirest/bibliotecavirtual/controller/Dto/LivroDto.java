package com.apirest.bibliotecavirtual.controller.Dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.apirest.bibliotecavirtual.models.EditoraModel;
import com.apirest.bibliotecavirtual.models.LivroModel;
import com.apirest.bibliotecavirtual.repository.LivroRepository;

public class LivroDto {

	@NotNull
	@NotEmpty
	private String autor;

	@NotNull
	@NotEmpty @ManyToOne
	private EditoraModel editora;

	@NotNull
	@NotEmpty
	private String titulo;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public EditoraModel getEditora() {
		return editora;
	}

	public void setEditora( EditoraModel editora) {
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LivroModel atualizar(long id, LivroRepository livroRepository) {
		LivroModel livro = livroRepository.getOne(id);
		livro.setAutor(this.autor);
		livro.setEditora(this.editora);
		livro.setTitulo(this.titulo);

		return livro;
	}

}
