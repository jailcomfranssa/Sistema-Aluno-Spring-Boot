package br.edu.ifpb.pweb2.sistema.aluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.sistema.aluno.business.exception.AlunoException;
import br.edu.ifpb.pweb2.sistema.aluno.business.model.Aluno;
import br.edu.ifpb.pweb2.sistema.aluno.business.model.Falta;
import br.edu.ifpb.pweb2.sistema.aluno.business.service.AlunoService;
import br.edu.ifpb.pweb2.sistema.aluno.business.service.FaltaService;

@Controller
@RequestMapping("/falta")
public class FaltaController {
	
	
	
	@Autowired
	private FaltaService faltaService;
	
	@RequestMapping("/form")
	public ModelAndView getForm(ModelAndView modelAndView) {
		
		List<Aluno> listaAluno = faltaService.listAluno();
		modelAndView.setViewName("falta/form");
		modelAndView.addObject("falta", new Falta());
		modelAndView.addObject("listaAluno",listaAluno);
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicioneFalta(Falta falta, ModelAndView modelAndView, RedirectAttributes attr ) {
		faltaService.saveFalta(falta);
		modelAndView.setViewName("redirect:/falta/form");
		attr.addFlashAttribute("mensagem", "Falta add!");
		return modelAndView;
	}
	
	
	

}