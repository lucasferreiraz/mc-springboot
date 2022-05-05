package io.lucasprojects.mcspringboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lucasprojects.mcspringboot.domain.Cliente;
import io.lucasprojects.mcspringboot.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente cliente = clienteService.buscar(id);
		
		return ResponseEntity.ok().body(cliente);
	}
	
}
