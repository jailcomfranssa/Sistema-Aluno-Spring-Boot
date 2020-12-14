package br.edu.ifpb.pweb2.sistema.aluno.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario , Integer>{
	
	
	public Usuario findBylogin(String login); 

}
