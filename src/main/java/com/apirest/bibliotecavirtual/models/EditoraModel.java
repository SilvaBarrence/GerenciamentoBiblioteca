package com.apirest.bibliotecavirtual.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EDITORAS")
public class EditoraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty
	private String nomeEditora;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeEditora == null) ? 0 : nomeEditora.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditoraModel other = (EditoraModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeEditora == null) {
			if (other.nomeEditora != null)
				return false;
		} else if (!nomeEditora.equals(other.nomeEditora))
			return false;
		return true;
	}

	public String getNome() {
		return nomeEditora;
	}

	public void setNome(String nome) {
		this.nomeEditora = nome;
	}

	public Long getId() {
		return id;
	}

}
