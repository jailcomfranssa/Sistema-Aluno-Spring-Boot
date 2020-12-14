package br.edu.ifpb.pweb2.sistema.aluno.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Usuario;
import br.edu.ifpb.pweb2.sistema.aluno.business.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/form")
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.setViewName("usuario/form");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicioneConta(Usuario usuario, ModelAndView modelAndView, RedirectAttributes attr ) {
		
		usuarioService.saveUsuario(usuario);
		modelAndView.setViewName("redirect:/login");
		attr.addFlashAttribute("mensagem", "Usuario salva com sucesso!");
		return modelAndView;
	}

	
	
	
	
}
