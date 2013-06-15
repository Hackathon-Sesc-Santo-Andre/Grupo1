package br.com.sesc.virtualtrainersesc.controller;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sesc.virtualtrainersesc.dao.impl.AcademiaDao;
import br.com.sesc.virtualtrainersesc.dao.impl.TreinoDao;
import br.com.sesc.virtualtrainersesc.model.Academia;
import br.com.sesc.virtualtrainersesc.model.Exercicio;

@Controller
public class RestMobile {

	@Autowired
	AcademiaDao academiaDao;
	
	@Autowired
	TreinoDao treinoDao;	
	
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

	@RequestMapping(value="/mobile/{treinoId}", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public @ResponseBody List<Exercicio> findTreino(@PathVariable("treinoId") Integer treinoId, Model model) {
		
		List<Exercicio> exercicios = treinoDao.findById(treinoId).getExercicios();
		exercicios.size();
		
		return exercicios;
	}
	
}
