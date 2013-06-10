package br.com.sesc.virtualtrainersesc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the treino database table.
 * 
 */
@Entity
@Table(name="treino")
public class Treino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int qtde;

	//bi-directional many-to-one association to Exercicio
	@OneToMany(mappedBy="treino")
	private List<Exercicio> exercicios;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	private Aluno aluno;

	public Treino() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtde() {
		return this.qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public List<Exercicio> getExercicios() {
		return this.exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public Exercicio addExercicio(Exercicio exercicio) {
		getExercicios().add(exercicio);
		exercicio.setTreino(this);

		return exercicio;
	}

	public Exercicio removeExercicio(Exercicio exercicio) {
		getExercicios().remove(exercicio);
		exercicio.setTreino(null);

		return exercicio;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}