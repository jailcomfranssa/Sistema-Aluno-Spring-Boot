package br.edu.ifpb.pweb2.sistema.aluno.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "situacao ")
	private String situacao;
	
	@Column(name="dt_nascimento")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "nota1")
	private Integer nota1;
	
	@Column(name = "nota2")
	private Integer nota2;
	
	@Column(name = "nota3")
	private Integer nota3;
	
	
	@OneToMany (mappedBy = "aluno", cascade = {CascadeType.ALL})
	private Set<Notas> nota = new HashSet<Notas>();
	
	@OneToMany (mappedBy = "aluno", cascade = {CascadeType.ALL})
	private Set<Falta> falta = new HashSet<Falta>();
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<Notas> getNota() {
		return nota;
	}

	public void setNota(Set<Notas> nota) {
		this.nota = nota;
	}

	public Set<Falta> getFata() {
		return falta;
	}

	public void setFata(Set<Falta> fata) {
		this.falta = fata;
	}
	
	

	public Integer getNota1() {
		return nota1;
	}

	public void setNota1(Integer nota1) {
		this.nota1 = nota1;
	}

	public Integer getNota2() {
		return nota2;
	}

	public void setNota2(Integer nota2) {
		this.nota2 = nota2;
	}

	public Integer getNota3() {
		return nota3;
	}

	public void setNota3(Integer nota3) {
		this.nota3 = nota3;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", situacao=" + situacao + ", data=" + data + ", nota1=" + nota1
				+ ", nota2=" + nota2 + ", nota3=" + nota3 + ", nota=" + nota + ", falta=" + falta + "]";
	}

	

	

	
	
	
	
	

}
