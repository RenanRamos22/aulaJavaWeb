package br.edu.up.aula4etapa.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.aula4etapa.dao.PlanoCompartilhadoDao;
import br.edu.up.aula4etapa.entity.ItemComp;
import br.edu.up.aula4etapa.entity.PlanoComp;


@ManagedBean(name = "mBeanCarrinho")
@SessionScoped
public class MBeanCarrinho {

	private ArrayList<ItemComp> itens = new ArrayList<ItemComp>();
	private boolean win;
	private boolean linx;
	private String msg;
	private String Dom;
	
	public String adicionar(Integer idPlanoCom) {
		
		PlanoComp plano = new PlanoCompartilhadoDao().buscar(idPlanoCom);

		ItemComp item = new ItemComp();

		item.setPlanocomp(plano);

		item.setQuantidade(1);
		
		item.setDominio(Dom);

		if(win && linx) 
		{
			item.setPlataforma("Windows - Linux");
		}
		if(!win && !linx)
		{
			
			this.msg = "Escolha no minimo uma Plataforma";
		}
		if(!win && linx)
		{
			item.setPlataforma("Linux");
		}
		if(win && !linx)
		{
			item.setPlataforma("Windows");
		}

		itens.add(item);
		
		return "carrinho.jsf";
	}
	
	public ArrayList<ItemComp> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemComp> itens) {
		this.itens = itens;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isLinx() {
		return linx;
	}

	public void setLinx(boolean linx) {
		this.linx = linx;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDom() {
		return Dom;
	}

	public void setDom(String dom) {
		Dom = dom;
	}
	
	
}
