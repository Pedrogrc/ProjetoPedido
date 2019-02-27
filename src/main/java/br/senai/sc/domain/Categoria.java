package br.senai.sc.domain;

public class Categoria {
	
	private Integer id;
	private String nome;
	
	
	//Construtores
	public Categoria(){
		
	}

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	//Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
