package com.apirest.bibliotecavirtual.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.bibliotecavirtual.models.AutorModel;

public interface AutorRepository extends JpaRepository<AutorModel, Long>{

	Optional<AutorModel> findById(Long id);
	
}
