package br.com.sesc.virtualtrainersesc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name="aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int matricula;

	private int idade;

	private String nome;

	private BigDecimal peso;

	private String senha;

	//bi-directional many-to-one association to Treino
	@OneToMany(mappedBy="aluno")
	private List<Treino> treinos;

	public Aluno() {
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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

	public List<Treino> getTreinos() {
		return this.treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public Treino addTreino(Treino treino) {
		getTreinos().add(treino);
		treino.setAluno(this);

		return treino;
	}

	public Treino removeTreino(Treino treino) {
		getTreinos().remove(treino);
		treino.setAluno(null);

		return treino;
	}

}