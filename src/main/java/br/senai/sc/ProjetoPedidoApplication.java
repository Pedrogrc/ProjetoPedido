package br.senai.sc;

import java.text.SimpleDateFormat;
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
import br.senai.sc.domain.ItemPedido;
import br.senai.sc.domain.Pagamento;
import br.senai.sc.domain.PagamentoComBoleto;
import br.senai.sc.domain.PagamentoComCartao;
import br.senai.sc.domain.Pedido;
import br.senai.sc.domain.Produto;
import br.senai.sc.domain.enums.EstadoPagamento;
import br.senai.sc.domain.enums.TipoCliente;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.CidadeRepository;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.repositories.EnderecoRepository;
import br.senai.sc.repositories.EstadoRepository;
import br.senai.sc.repositories.ItemPedidoRepository;
import br.senai.sc.repositories.PagamentoRepository;
import br.senai.sc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itempedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
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
		//Pedido
			Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
			Pedido ped2 = new Pedido(null,sdf.parse("20/10/2017 19:35"),cli1,e2);
		//Item
			ItemPedido item1 = new ItemPedido(ped1,p1,0.0,1,1000.0);
			ItemPedido item2 = new ItemPedido(ped2,p3,0.0,1,1000.0);
		//Pagamento
			Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.PENDENTE,ped1,6);
			
			Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf2.parse("20/10/2017"),null);
		
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
		//Pagamento
			ped1.setPagamento(pagto1);
			ped2.setPagamento(pagto2);
			
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
		//Pedido
			pedidoRepository.save(ped1);
		//ItemPedido
			itempedidoRepository.save(item1);
	}

	// proxy rede10.1.118.254
	// proxy git 10.1.118.254:3128

}
