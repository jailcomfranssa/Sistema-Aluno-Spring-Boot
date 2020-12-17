package br.edu.ifpb.pweb2.sistema.aluno.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Usuario;
import br.edu.ifpb.pweb2.sistema.aluno.business.repository.UsuarioDAO;
import br.edu.ifpb.pweb2.sistema.aluno.util.PasswordUtil;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Transactional
	public void saveUsuario(Usuario usuario){
		usuario.setSenha(PasswordUtil.hashPassword(usuario.getSenha()));
		
		usuarioDAO.save(usuario);
	}
	
	public List<Usuario>findAll() {
		return usuarioDAO.findAll();
		
	}
	public Usuario isValido(Usuario usuario) {
		Usuario usuarioBD = usuarioDAO.findBylogin(usuario.getLogin());
		
		boolean valido = false;
		if(usuarioBD != null) {
			if (PasswordUtil.checkPass(usuario.getSenha(), usuarioBD.getSenha())) {
					
					valido = true;
			}
		}
		return valido ? usuarioBD : null;
		
	}
}










































