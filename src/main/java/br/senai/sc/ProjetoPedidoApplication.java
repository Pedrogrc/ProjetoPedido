package br.senai.sc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Cidade;
import br.senai.sc.domain.Cliente;
import br.senai.sc.domain.Endereco;
import br.senai.sc.domain.Estado;
import br.senai.sc.domain.Produto;
import br.senai.sc.domain.enums.TipoCliente;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.CidadeRepository;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.repositories.EnderecoRepository;
import br.senai.sc.repositories.EstadoRepository;
import br.senai.sc.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Override
	public void run(String... args) throws Exception {
		//Categoria
			Categoria cat1 = new Categoria(null, "Informática");
			Categoria cat2 = new Categoria(null, "Escritório");
		//Produto
			Produto p1 = new Produto(null, "Computador", 2000.00);
			Produto p2 = new Produto(null, "Impressora", 800.00);
			Produto p3 = new Produto(null, "Mouse", 80.00);
		//Estado
			Estado est1 = new Estado(null,"Minas Gerais");
			Estado est2 = new Estado(null,"São Paulo");
		//Cidade
			Cidade c1 = new Cidade(null,"Uberlândia",est1);
			Cidade c2 = new Cidade(null,"São Paulo",est2);
			Cidade c3 = new Cidade(null,"Campinas",est2);
		//Cliente
			Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com", "36378912377",TipoCliente.PESSOAJURIDICA);
		//Endereço
			Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 203","Jardim","38220834",c1);
			Endereco e2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","38777012",c1);
			
		
		
		//Salvando na tabela de Associativa
		
		//Produto para Categoria
			p1.getCategorias().add(cat1);
		//Categoria para produto
			cat1.getProdutos().add(p1);
		//Atribuindo Estados para as cidades
			est1.getCidades().add(c1);
			est2.getCidades().add(c2);
			est2.getCidades().add(c3);
			
		//Atribuindo endereço ao cliente
			e1.setCliente(cli1);
			e2.setCliente(cli1);
		//Salvando Endereços na lista endereços do Cliente
			cli1.setEnderecos(Arrays.asList(e1,e2));
			
			
		//Telefones
			cli1.getTelefones().add("(48)99999-8888");
			cli1.getTelefones().add("(48)22299-5588");
			
		
			
			
		//Categoria
			categoriaRepository.save(cat1);
			categoriaRepository.save(cat2);
		//Produto
			produtoRepository.save(p1);
			produtoRepository.save(p2);
			produtoRepository.save(p3);
		//Estado
			estadoRepository.save(est1);
			estadoRepository.save(est2);
		//Cidades
			cidadeRepository.save(c1);
			cidadeRepository.save(c2);
			cidadeRepository.save(c3);
		//Cliente
			clienteRepository.save(cli1);
		//Endereços
			enderecoRepository.save(e1);
			enderecoRepository.save(e2);
	}

	// proxy rede10.1.118.254
	// proxy git 10.1.118.254:3128

}
