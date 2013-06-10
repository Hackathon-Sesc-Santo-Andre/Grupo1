package br.com.sesc.gym.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pessoa database table.
 * 
 */
@Embeddable
public class PessoaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	private int matricula;

	public PessoaPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricula() {
		return this.matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PessoaPK)) {
			return false;
		}
		PessoaPK castOther = (PessoaPK)other;
		return 
			(this.id == castOther.id)
			&& (this.matricula == castOther.matricula);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.matricula;
		
		return hash;
	}
}