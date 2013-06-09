package br.com.sesc.gym.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PessoaPK id;

	private int idade;

	private String nome;

	private BigDecimal peso;

	private String senha;

	public Pessoa() {
	}

	public PessoaPK getId() {
		return this.id;
	}

	public void setId(PessoaPK id) {
		this.id = id;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}