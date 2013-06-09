package br.com.sesc.gym.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the exercicio database table.
 * 
 */
@Entity
@Table(name="exercicio")
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	private Time tempo;

	public Exercicio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getTempo() {
		return this.tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}
}