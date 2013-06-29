package br.org.virtualtrainersesc.model;

public class Treino {
	private int id;
	private String nome;
	private int porcetagemConcluido;
	
	public Treino() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPorcetagemConcluido() {
		return porcetagemConcluido;
	}

	public void setPorcetagemConcluido(int porcetagemConcluido) {
		this.porcetagemConcluido = porcetagemConcluido;
	}
}
