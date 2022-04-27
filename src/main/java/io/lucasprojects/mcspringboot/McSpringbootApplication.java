package io.lucasprojects.mcspringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.lucasprojects.mcspringboot.domain.Categoria;
import io.lucasprojects.mcspringboot.domain.Produto;
import io.lucasprojects.mcspringboot.repositories.CategoriaRepository;
import io.lucasprojects.mcspringboot.repositories.ProdutoRepository;

@SpringBootApplication
public class McSpringbootApplication /*implements CommandLineRunner*/ {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(McSpringbootApplication.class, args);
	}
	
	/*
	 * 
	 * Alimentei e fiz as relações de forma provisória no banco 
	 * 
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
		
		
	}
	*/

}
