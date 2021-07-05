package com.apirest.bibliotecavirtual.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.bibliotecavirtual.models.EditoraModel;

public interface EditoraRepository extends JpaRepository<EditoraModel, Long> {

	Optional<EditoraModel> findById(Long id);

	Optional<EditoraModel> save(String string);

}
