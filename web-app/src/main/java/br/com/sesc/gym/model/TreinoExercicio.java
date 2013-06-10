package br.com.sesc.gym.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the treino_exercicio database table.
 * 
 */
@Entity
@Table(name="treino_exercicio")
public class TreinoExercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TreinoExercicioPK id;

	private String repeticoes;

/*	//bi-directional many-to-one association to Exercicio
	@ManyToOne(fetch=FetchType.LAZY)
	private Exercicio exercicio;
*/
	//bi-directional many-to-one association to Treino
/*	@ManyToOne(fetch=FetchType.LAZY)
	private Treino treino;*/

	public TreinoExercicio() {
	}

	public TreinoExercicioPK getId() {
		return this.id;
	}

	public void setId(TreinoExercicioPK id) {
		this.id = id;
	}

	public String getRepeticoes() {
		return this.repeticoes;
	}

	public void setRepeticoes(String repeticoes) {
		this.repeticoes = repeticoes;
	}

/*	public Exercicio getExercicio() {
		return this.exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}*/

/*	public Treino getTreino() {
		return this.treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}*/

}