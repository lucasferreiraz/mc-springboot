package io.lucasprojects.mcspringboot;

import java.text.SimpleDateFormat;
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
import io.lucasprojects.mcspringboot.domain.Pagamento;
import io.lucasprojects.mcspringboot.domain.PagamentoComBoleto;
import io.lucasprojects.mcspringboot.domain.PagamentoComCartao;
import io.lucasprojects.mcspringboot.domain.Pedido;
import io.lucasprojects.mcspringboot.domain.Produto;
import io.lucasprojects.mcspringboot.domain.enums.EstadoPagamento;
import io.lucasprojects.mcspringboot.domain.enums.TipoCliente;
import io.lucasprojects.mcspringboot.repositories.CategoriaRepository;
import io.lucasprojects.mcspringboot.repositories.CidadeRepository;
import io.lucasprojects.mcspringboot.repositories.ClienteRepository;
import io.lucasprojects.mcspringboot.repositories.EnderecoRepository;
import io.lucasprojects.mcspringboot.repositories.EstadoRepository;
import io.lucasprojects.mcspringboot.repositories.PagamentoRepository;
import io.lucasprojects.mcspringboot.repositories.PedidoRepository;
import io.lucasprojects.mcspringboot.repositories.ProdutoRepository;

@SpringBootApplication
public class McSpringbootApplication implements CommandLineRunner {
	
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
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(McSpringbootApplication.class, args);
	}
	
	
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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}
	
}
