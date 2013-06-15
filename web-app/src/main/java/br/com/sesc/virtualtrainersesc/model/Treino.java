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
@NamedQueries({
	@NamedQuery(
	name = "Treino.findById",
	query = "FROM Treino tr WHERE tr.id=:id"
	),
	@NamedQuery(
	name = "Treino.findByAlunoMatricula",
	query = "FROM Treino tr WHERE tr.aluno.matricula = :matricula"
	)	
})
public class Treino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int qtde;
	
	private String nome;

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

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Treino [id=" + id + ", qtde=" + qtde + ", exercicios="
				+ exercicios + ", aluno=" + aluno + "]";
	}
}