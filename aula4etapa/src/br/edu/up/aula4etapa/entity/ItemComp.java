package br.edu.up.aula4etapa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemComp {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private PlanoComp planocomp;
	private Integer quantidade;
	private String plataforma;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public PlanoComp getPlanocomp() {
		return planocomp;
	}
	public void setPlanocomp(PlanoComp planocomp) {
		this.planocomp = planocomp;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
	
}
