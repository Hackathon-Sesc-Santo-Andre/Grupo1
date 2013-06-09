package br.com.sesc.gym.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the treino_exercicio database table.
 * 
 */
@Embeddable
public class TreinoExercicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="treino_id")
	private int treinoId;

	@Column(name="exercicio_id")
	private int exercicioId;

	public TreinoExercicioPK() {
	}
	public int getTreinoId() {
		return this.treinoId;
	}
	public void setTreinoId(int treinoId) {
		this.treinoId = treinoId;
	}
	public int getExercicioId() {
		return this.exercicioId;
	}
	public void setExercicioId(int exercicioId) {
		this.exercicioId = exercicioId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TreinoExercicioPK)) {
			return false;
		}
		TreinoExercicioPK castOther = (TreinoExercicioPK)other;
		return 
			(this.treinoId == castOther.treinoId)
			&& (this.exercicioId == castOther.exercicioId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.treinoId;
		hash = hash * prime + this.exercicioId;
		
		return hash;
	}
}