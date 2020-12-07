package br.edu.ifpb.pweb2.sistema.aluno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String getIndex() {
		return "home";
	}

}
