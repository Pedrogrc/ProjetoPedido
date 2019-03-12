package br.senai.sc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Produto;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository repro;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Categoria cat2 = new Categoria(null,"Escritório");
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null,"Mouse", 80.00);
		
		repo.save(cat1);
		repro.save(p1);
		repo.save(cat2);
		repro.save(p2);
		repro.save(p3);
	}
	
	//proxy rede10.1.118.254
	//proxy git 10.1.118.254:3128
	
	
	

}
