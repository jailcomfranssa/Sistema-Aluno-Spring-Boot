package br.edu.ifpb.pweb2.sistema.aluno.business.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.sistema.aluno.business.model.Aluno;
import br.edu.ifpb.pweb2.sistema.aluno.business.model.Falta;
import br.edu.ifpb.pweb2.sistema.aluno.business.repository.AlunoDAO;
import br.edu.ifpb.pweb2.sistema.aluno.business.repository.FaltaDAO;

@Service
public class FaltaService {
	
	@Autowired
	private FaltaDAO faltaDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	public List<Falta> listAll(){
		return faltaDAO.findAll();
	}
	
	public List<Aluno> listAluno(){
		return alunoDAO.findAll();
	}
	
	@Transactional
	public void saveFalta(Falta falta){
		faltaDAO.save(falta);
	}
	
	public Falta findById(Integer id) {
		Optional <Falta> opFalta = faltaDAO.findById(id);
		return opFalta.isPresent() ? opFalta.get(): null;
	}
	
	@Transactional
	public void deleteById(Integer id) {
		faltaDAO.deleteById(id);
		
	}
	
	public List<Falta> faltaTotal(Integer id){
		List<Falta> falta  = faltaDAO.findTotalFalta(id);
		
		return falta;

	}
	
	public int Total(Integer id){
		String x = faltaDAO.total(id);
		int falta =0;
		if(x!= null){
		  falta  = Integer.parseInt(faltaDAO.total(id));
		}
		else {
			falta = 0;
		}
		return falta;

	}
	
	public int media(Integer id){
		String media = faltaDAO.media(id);
		
		int somaMedia =0;
		if(media!= null){
			 somaMedia = Integer.parseInt(faltaDAO.media(id));
		}
		return (somaMedia / 3) ;
		
		
	}
	
	public String situacao(Integer id) {
		int totalFalta = Total(id);
		int media =  media(id);
		if(media >= 70 && totalFalta < 25) {
			return "Aprovado";
		}
		if(media < 70 && media >= 40 && totalFalta < 25 ){
			return "Em Final";
		}
		if(totalFalta  >= 25){
			return " Reprovado por Falta";
			
		}
		if(media < 40 && totalFalta < 25 ){
			return " Reprovado";
		}
		else {
			return "MT";
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
