package io.lucasprojects.mcspringboot.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lucasprojects.mcspringboot.domain.Categoria;
import io.lucasprojects.mcspringboot.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new NoSuchElementException("Objeto não encontrado, Id: " + id 
				+ " Tipo: " + Categoria.class.getName()));
		
	}
	
}
