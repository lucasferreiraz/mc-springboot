package io.lucasprojects.mcspringboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lucasprojects.mcspringboot.domain.Pedido;
import io.lucasprojects.mcspringboot.repositories.PedidoRepository;
import io.lucasprojects.mcspringboot.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, Id: " + id 
				+ " Tipo: " + Pedido.class.getName()));
		
	}
	
}
