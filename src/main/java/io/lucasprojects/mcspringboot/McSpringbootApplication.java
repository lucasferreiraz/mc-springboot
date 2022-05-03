package io.lucasprojects.mcspringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.lucasprojects.mcspringboot.domain.Categoria;
import io.lucasprojects.mcspringboot.domain.Cidade;
import io.lucasprojects.mcspringboot.domain.Cliente;
import io.lucasprojects.mcspringboot.domain.Endereco;
import io.lucasprojects.mcspringboot.domain.Estado;
import io.lucasprojects.mcspringboot.domain.Produto;
import io.lucasprojects.mcspringboot.domain.enums.TipoCliente;
import io.lucasprojects.mcspringboot.repositories.CategoriaRepository;
import io.lucasprojects.mcspringboot.repositories.CidadeRepository;
import io.lucasprojects.mcspringboot.repositories.ClienteRepository;
import io.lucasprojects.mcspringboot.repositories.EnderecoRepository;
import io.lucasprojects.mcspringboot.repositories.EstadoRepository;
import io.lucasprojects.mcspringboot.repositories.ProdutoRepository;

@SpringBootApplication
public class McSpringbootApplication /*implements CommandLineRunner*/ {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(McSpringbootApplication.class, args);
	}
	
	/*
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.99);
		Produto p2 = new Produto(null, "Impressora", 800.99);
		Produto p3 = new Produto(null, "Mouse", 20.99);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "38163810275", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("40028922","33016753"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "48251339", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 663", "Centro", "42221339", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}*/
	
}
