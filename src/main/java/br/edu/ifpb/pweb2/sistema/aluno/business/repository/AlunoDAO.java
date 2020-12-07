package br.edu.ifpb.pweb2.sistema.aluno.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Aluno;



public interface AlunoDAO extends JpaRepository<Aluno, Integer>{
	
	

}
