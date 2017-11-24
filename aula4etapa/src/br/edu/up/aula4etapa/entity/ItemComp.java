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
	@ManyToOne
	private Dedicado dedic;
	@ManyToOne
	private Revenda revenda;
	@ManyToOne
	private Pedido pedido;
	private Integer quantidade;
	private String plataforma;
	
	private String dominio;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
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
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Dedicado getDedic() {
		return dedic;
	}
	public void setDedic(Dedicado dedic) {
		this.dedic = dedic;
	}
	public Revenda getRevenda() {
		return revenda;
	}
	public void setRevenda(Revenda revenda) {
		this.revenda = revenda;
	}
	
	
	
}
