package br.edu.ifpb.pweb2.sistema.aluno.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private FaltaService faltaService;
	
	@RequestMapping("/form")
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.setViewName("aluno/form");
		modelAndView.addObject("aluno", new Aluno());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicioneConta(Aluno aluno, ModelAndView modelAndView, RedirectAttributes attr ) {
		alunoService.saveAluno(aluno);
		modelAndView.setViewName("redirect:/aluno");
		attr.addFlashAttribute("mensagem", "Aluno salva com sucesso!");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listAluno(ModelAndView modelAndView) {
		modelAndView.setViewName("/aluno/list");
		try {
			List<Aluno> aluno = alunoService.findAll();
			modelAndView.addObject("aluno", aluno);
		} catch (AlunoException e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}
		return modelAndView;
	}
	
	
	@RequestMapping("/{id}")
	public String busquePorId(@PathVariable("id") Integer id, Model model, RedirectAttributes attr) {
		Aluno aluno = alunoService.findById(id);
		if (aluno != null) {
			model.addAttribute("aluno", aluno);
		} else {
			attr.addFlashAttribute("mensagem", "Aluno nao encontrado!");
			model.addAttribute("aluno", new Aluno());
		}
		return "aluno/form";
	}
	
	
	@RequestMapping(value="/{id}/delete")
	public ModelAndView deletePorId(@PathVariable("id") Integer id, ModelAndView modelAndView , RedirectAttributes attr) {
		alunoService.deleteById(id);
		modelAndView.setViewName("redirect:/aluno");
		attr.addFlashAttribute("mensagem", "Aluno excluídas!");
		return modelAndView;
	}
	
	
	
	@RequestMapping("/{id}/nota")
	public String busquePorId1(@PathVariable("id") Integer id, Model model, RedirectAttributes attr) {
		Aluno aluno = alunoService.findById(id);
		if (aluno != null) {
			model.addAttribute("aluno", aluno);
		} else {
			attr.addFlashAttribute("mensagem", "Aluno nao encontrado!");
			model.addAttribute("aluno", new Aluno());
		}
		return "aluno/notas";
	}
	
	
	
	@RequestMapping("/{id}/resultado")
	public String resultado(@PathVariable("id") Integer id, Model model, RedirectAttributes attr) {
		Aluno aluno = alunoService.findById(id);
		//List<Falta> listaFalta = faltaService.listAll();
		List<Falta> listaFalta = faltaService.faltaTotal(id);
		int listaFaltatotal = faltaService.Total(id);
		String media = faltaService.situacao(id);
		
		
		if (aluno != null) {
			model.addAttribute("aluno", aluno);
			model.addAttribute("listaFalta", listaFalta);
			model.addAttribute("listaFaltatotal", listaFaltatotal);
			model.addAttribute("situacao", media);
			
			
		} else {
			attr.addFlashAttribute("mensagem", "Aluno nao encontrado!");
			model.addAttribute("aluno", new Aluno());
		}
		return "aluno/resultado";
	}
	
	
	
	
	
	
	
	
	
	
	

}
