package br.edu.up.aula4etapa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Integer id;
	private Date data;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemComp> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemComp> getItens() {
		return itens;
	}

	public void setItens(List<ItemComp> itens) {
		this.itens = itens;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
