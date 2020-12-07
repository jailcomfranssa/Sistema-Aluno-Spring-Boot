package br.edu.ifpb.pweb2.sistema.aluno.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Falta;

public interface FaltaDAO extends JpaRepository<Falta, Integer>{
	
	@Query("from Falta f  where f.aluno.id = :id")
	public List<Falta> findTotalFalta (@Param("id") Integer id );
	
	
	@Query("select sum(faltas) from Falta f  where f.aluno.id = :id")
	public String total (@Param("id") Integer id );
	
	@Query("select nota1+nota2+nota3 from Aluno a  where a.id = :id")
	public String media (@Param("id") Integer id );
	

}
