package io.lucasprojects.mcspringboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lucasprojects.mcspringboot.domain.Pedido;
import io.lucasprojects.mcspringboot.services.PedidoService;

@RestController
@RequestMapping(path = "/categorias")
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido pedido = pedidoService.buscar(id);
		 
		return ResponseEntity.ok().body(pedido);
	}
	
}

