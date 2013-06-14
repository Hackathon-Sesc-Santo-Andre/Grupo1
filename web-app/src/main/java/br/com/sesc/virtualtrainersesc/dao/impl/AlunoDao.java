package br.com.sesc.virtualtrainersesc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.sesc.virtualtrainersesc.dao.AbstractDao;
import br.com.sesc.virtualtrainersesc.dao.GenericDao;
import br.com.sesc.virtualtrainersesc.model.Academia;
import br.com.sesc.virtualtrainersesc.model.Aluno;

@Repository("alunoDao")
public class AlunoDao extends AbstractDao<Aluno> implements GenericDao<Aluno> {

	public AlunoDao() {
		super(Academia.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
