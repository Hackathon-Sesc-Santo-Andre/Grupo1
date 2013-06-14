package br.com.sesc.virtualtrainersesc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.sesc.virtualtrainersesc.dao.AbstractDao;
import br.com.sesc.virtualtrainersesc.dao.GenericDao;
import br.com.sesc.virtualtrainersesc.model.Treino;

@Repository("treinoDao")
public class TreinoDao extends AbstractDao<Treino> implements GenericDao<Treino> {

	public TreinoDao() {
		super(Treino.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
