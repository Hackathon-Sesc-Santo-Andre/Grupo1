package br.com.sesc.virtualtrainersesc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sesc.virtualtrainersesc.dao.impl.AlunoDao;
import br.com.sesc.virtualtrainersesc.dao.impl.TreinoDao;
import br.com.sesc.virtualtrainersesc.model.Aluno;
import br.com.sesc.virtualtrainersesc.model.Exercicio;

@Controller
public class AdminController {

	@Autowired
	AlunoDao alunoDao;
	
	@Autowired
	TreinoDao treinoDao;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdminPage(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("alunos", alunoDao.findAll());
		
		return "admin";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos", method=RequestMethod.GET)
	public String showTreinosPage(@PathVariable("matricula") Integer matricula,  /*Model model, */HttpServletRequest request) {
		Aluno aluno = alunoDao.findByMatricula(matricula);
		aluno.getTreinos().size();
		
		request.setAttribute("aluno", aluno);
		
		return "treinosList";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos/{treinoId}", method=RequestMethod.GET)
	public String showExerciciosPage(@PathVariable("matricula") Integer matricula, @PathVariable("treinoId") Integer treinoId, HttpServletRequest request) {
		List<Exercicio> exercicios = treinoDao.findById(treinoId).getExercicios();
		exercicios.size();
		
		request.setAttribute("exercicios", exercicios);
		
		return "exerciciosList";
	}
}
