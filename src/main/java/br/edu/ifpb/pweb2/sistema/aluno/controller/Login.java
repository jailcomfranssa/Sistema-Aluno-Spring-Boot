package br.edu.ifpb.pweb2.sistema.aluno.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Usuario;
import br.edu.ifpb.pweb2.sistema.aluno.business.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class Login {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.setViewName("/login/form");
		modelAndView.addObject("usuario",new Usuario());
		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView autentique(Usuario usuario, HttpSession session, ModelAndView modelAndView, RedirectAttributes attrs){
		if((usuario = usuarioService.isValido(usuario)) != null){
			session.setAttribute("usuarioLogado", usuario);
			session.setMaxInactiveInterval(5 * 60);
			modelAndView.setViewName("redirect:/home");
			System.out.println(usuario);
			
		}
		else{
			attrs.addFlashAttribute("mensagem", "usuario ou senha invalida");
			modelAndView.setViewName("redirect:/login");
			
		}
		return modelAndView;

	}
	@RequestMapping("/out")
	public ModelAndView logout(HttpSession session, ModelAndView modelAndView) {
		session.invalidate();
		modelAndView.setViewName("redirect:/login");
		modelAndView.addObject("usuario",new Usuario());
		return modelAndView;
	}

	

}
