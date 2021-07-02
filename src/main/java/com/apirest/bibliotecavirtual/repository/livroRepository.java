package com.apirest.bibliotecavirtual.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.bibliotecavirtual.models.LivroModel;

public interface livroRepository extends JpaRepository<LivroModel, Long> {

	Optional<LivroModel> findById(Long id);

	List<LivroModel> findByTitulo(String nomeLivro);

}
