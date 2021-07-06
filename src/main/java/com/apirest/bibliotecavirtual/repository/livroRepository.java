package com.apirest.bibliotecavirtual.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.bibliotecavirtual.models.LivroModel;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

	Optional<LivroModel> findById(Long id);

	Optional<LivroModel> findByTitulo(String tituloLivro);

	List<LivroModel> findByAutor(String nomeAutor);

	List<LivroModel> findByEditoraNome(String editora);

	List<LivroModel> deleteByTitulo(String titulo);

	List<LivroModel> findByAutorNome(String autor);

}
