package io.lucasprojects.mcspringboot.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lucasprojects.mcspringboot.domain.Categoria;
import io.lucasprojects.mcspringboot.services.CategoriaService;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria categoria = categoriaService.buscar(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
}

