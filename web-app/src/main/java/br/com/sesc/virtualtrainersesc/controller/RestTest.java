package br.com.sesc.virtualtrainersesc.controller;

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
import br.com.sesc.virtualtrainersesc.model.Academia;

@Controller
@Transactional
public class RestTest {

	@Autowired
	AcademiaDao academiaDao;
	
	@RequestMapping(value="/rest/{name}", method = RequestMethod.GET)
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
}
