package br.edu.ifpb.pweb2.sistema.aluno.business.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.sistema.aluno.business.exception.AlunoException;
import br.edu.ifpb.pweb2.sistema.aluno.business.model.Aluno;
import br.edu.ifpb.pweb2.sistema.aluno.business.model.Falta;
import br.edu.ifpb.pweb2.sistema.aluno.business.repository.AlunoDAO;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void saveAluno(Aluno aluno){
		alunoDAO.save(aluno);
	}
	
	public List<Aluno> findAll() throws AlunoException{
		return alunoDAO.findAll();
	}
	
	public Aluno findById(Integer id) {
		Optional <Aluno> opAluno = alunoDAO.findById(id);
		return opAluno.isPresent() ? opAluno.get(): null;
	}
	
	@Transactional
	public void deleteById(Integer id) {
		alunoDAO.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
