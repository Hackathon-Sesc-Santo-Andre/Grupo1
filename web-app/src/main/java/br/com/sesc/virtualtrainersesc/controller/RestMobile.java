package br.com.sesc.virtualtrainersesc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sesc.virtualtrainersesc.dao.impl.AcademiaDao;
import br.com.sesc.virtualtrainersesc.dao.impl.ExercicioDao;
import br.com.sesc.virtualtrainersesc.dao.impl.TreinoDao;
import br.com.sesc.virtualtrainersesc.model.Academia;
import br.com.sesc.virtualtrainersesc.model.Exercicio;
import br.com.sesc.virtualtrainersesc.model.Treino;

@Controller
public class RestMobile {

	@Autowired
	AcademiaDao academiaDao;
	
	@Autowired
	TreinoDao treinoDao;	
	
	@Autowired
	ExercicioDao exercicioDao;
	
	@RequestMapping(value="/rest/{name}", method = RequestMethod.GET)
	@Transactional(readOnly=true)
	public @ResponseBody Academia getShopInJSON(@PathVariable String name) throws Exception {
		
		List<Academia> all = academiaDao.findAll();
		
		for (Academia academia : all) {
			System.out.println(academia);
			
			return academia;
		}
		
		throw new Exception("Não deveria chegar aqui");
	}
	
	@RequestMapping(value="/mobile/{ownerId}/{ownerPi}", method=RequestMethod.GET)
	public String findOwner(@PathVariable("ownerId") String theOwner, @PathVariable("ownerPi") String ownerPi, Model model) {
		System.out.println("["+theOwner+","+ownerPi+"]");
		
		return "ola";
	}

	@RequestMapping(value="/mobile/exercicios_{treinoId}", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public @ResponseBody List<Exercicio> findExercicios(@PathVariable("treinoId") Integer treinoId, Model model) {
		
		List<Exercicio> exerciciosBase = treinoDao.findById(treinoId).getExercicios();
		
		List<Exercicio> exerciciosReturn = new ArrayList<Exercicio>();
		
		for (Exercicio exercicio : exerciciosBase) {
			Exercicio exeClone = new Exercicio();
			
			exeClone.setId(exercicio.getId());
			exeClone.setExecucao(exercicio.getExecucao());
			exeClone.setEquipamento(exercicio.getEquipamento());
			exeClone.setMusculatura(exercicio.getMusculatura());
			exeClone.setQualidade(exercicio.getQualidade());
			
			exerciciosReturn.add(exeClone);
		}
		
		return exerciciosReturn;
	}
	
	@RequestMapping(value="/mobile/treinos_{matricula}", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public @ResponseBody List<Treino> findTreinos(@PathVariable("matricula") Integer matricula, Model model) {
		
		List<Treino> treinosBase = treinoDao.findByAlunoMatricula(matricula);
		
		List<Treino> treinosReturn = new ArrayList<Treino>();
		
		for (Treino treino : treinosBase) {
			Treino treinoClone = new Treino();
			
			treinoClone.setId(treino.getId());
			treinoClone.setNome(treino.getNome());
			treinoClone.setQtde(treino.getQtde());
			
			treinosReturn.add(treinoClone);
		}
		
		return treinosReturn;
	}	
}
