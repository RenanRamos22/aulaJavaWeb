package br.edu.up.aula4etapa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.up.aula4etapa.dao.DedicadoDao;
import br.edu.up.aula4etapa.dao.PedidoDao;
import br.edu.up.aula4etapa.dao.PlanoCompartilhadoDao;
import br.edu.up.aula4etapa.dao.RevendaDao;
import br.edu.up.aula4etapa.entity.Dedicado;
import br.edu.up.aula4etapa.entity.ItemComp;
import br.edu.up.aula4etapa.entity.Pedido;
import br.edu.up.aula4etapa.entity.PlanoComp;
import br.edu.up.aula4etapa.entity.Revenda;
import br.edu.up.aula4etapa.entity.Usuario;


@ManagedBean(name = "mBeanCarrinho")
@SessionScoped
public class MBeanCarrinho {

	 private ArrayList<ItemComp> itens = new ArrayList<ItemComp>();
	 private ArrayList<Dedicado> intensDedic = new ArrayList<Dedicado>(); 
	 private ArrayList<Revenda> intensReve = new ArrayList<Revenda>();
	 private ArrayList<Pedido> listPedido = new ArrayList<Pedido>();
	 
	private boolean win;
	private boolean linx;
	private String msg;
	private String Dom;
	private String plat;
	
	@PostConstruct
	public void carregar() {
		listPedido = new PedidoDao().listar();
	}
	public String salvarPedido()  {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Usuario u = (Usuario) req.getSession().getAttribute("usuario");

		Pedido p = new Pedido();
		p.setData(new Date());
		p.setItens(itens);	
		p.setUsuario(u);
		
		for (ItemComp i : itens) {

			i.setPedido(p);

		}
		
		new PedidoDao().inserir(p);
		
		
		
		listPedido = new PedidoDao().listar();
		itens = new ArrayList<ItemComp>();
		
	
		
		return"pedidoFinalizado.jsf";
		 
	}
	
	public void adicionar(Integer id) throws IOException {
		
		PlanoComp plano = new PlanoCompartilhadoDao().buscar(id);
		
		//Dedicado dedic = new DedicadoDao().buscar(id);
		
		//Revenda revenda = new RevendaDao().buscar(id);
		
		ItemComp item = new ItemComp();
		
		//item.setDedic(dedic);
		
		//item.setRevenda(revenda);
		
		item.setPlanocomp(plano);

		item.setQuantidade(+1);
		
		
		item.setDominio(Dom);
		
		if(plat.equals("")) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Escolha uma plataforma",""));
		 
			 new MBeanComp().carregarPlano(plano);
			 
		
			
		}else {
		item.setPlataforma(plat);
		
		itens.add(item);
		
		FacesContext.
		getCurrentInstance().
getExternalContext().redirect("carrinho.jsf");
		}
		
		
		
	}
	
public String adicionarDedicado(Integer id) {
		
		
		
		Dedicado dedic = new DedicadoDao().buscar(id);
		
		
		
		ItemComp item = new ItemComp();
		
		item.setDedic(dedic);
		
		

		item.setQuantidade(1);
		
		item.setDominio(Dom);
		
		if(plat.equals("")) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Escolha uma plataforma",""));
		 
			 new MBeanPlanoDedicado().carregaDedicado(dedic);
			 
			 return"";
			
		}else {
		item.setPlataforma(plat);
		}

		itens.add(item);
		
		return "carrinho.jsf";
	}

public String adicionarRevenda(Integer id) {
	
	
	
	Revenda revenda = new RevendaDao().buscar(id);
	
	
	
	ItemComp item = new ItemComp();
	
	item.setRevenda(revenda);
	
	

	item.setQuantidade(1);
	
	item.setDominio(Dom);
	
	if(plat.equals("")) {
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Escolha uma plataforma",""));
	 
		 new MbeanRevenda().carregarPlano(revenda);
		 
		 return"";
		
	}else {
	item.setPlataforma(plat);
	}

	itens.add(item);
	
	return "carrinho.jsf";
}
	
	public String removerItem(ItemComp item) {
		itens.remove(item);
		return "";
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

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}
	public ArrayList<Pedido> getListPedido() {
		return listPedido;
	}
	public void setListPedido(ArrayList<Pedido> listPedido) {
		this.listPedido = listPedido;
	}
	
	
}
