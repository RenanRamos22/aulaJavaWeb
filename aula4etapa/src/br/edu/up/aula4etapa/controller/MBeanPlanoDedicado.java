package br.edu.up.aula4etapa.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.up.aula4etapa.dao.DedicadoDao;
import br.edu.up.aula4etapa.entity.Dedicado;

@ManagedBean(name="mBeanDedic")
public class MBeanPlanoDedicado {

	static private ArrayList<Dedicado> dedicList = new ArrayList<Dedicado>();
	
	@PostConstruct
	public void carregar() {
		dedicList = new DedicadoDao().listar();
	}
	
	public void salvar(){
		
		Dedicado dedic = new Dedicado();
		dedic.setId(this.id);
		dedic.setData(data);
		dedic.setNome(nome);
		dedic.setHd(hd);
		dedic.setRam(ram);
		dedic.setValor(valor);
		
		
		dedic.setDescr(descr);
		
		// Se o checkbox dominio ilimitado estiver marcado
		// Ent�o � adicionado a string na lista
		// Se n�o estiver ent�o � atribuido a lista a quantidade digitada
		if(domIlim) {
		
		dedic.setIlim("Ilimitado");
				
		
		
		}else {
			
			dedic.setQtdDom(qtdDom);
		}
		
		if(ipDedic) {
			dedic.setIp("IP Dedicado");
		}else {
			dedic.setIp("");
		}
		
		//Verificando qual tipo de servidor foi selecionado
		if(win && linx) 
		{
			dedic.setServ("Windows - Linux");
		}
		if(!win && !linx)
		{
			//VERIFICAR COM PROFESSOR COMO RETORNAR O AVISO NA VIEW
			
			this.msg = "Escolha no minimo uma Plataforma";
		}
		if(!win && linx)
		{
			dedic.setServ("Linux");
		}
		if(win && !linx)
		{
			dedic.setServ("Windows");
		} 
		
		if(this.id == null) {
			new DedicadoDao().salvar(dedic);
		} else {
			new DedicadoDao().alterar(dedic);
		}
		
		dedicList = new DedicadoDao().listar();
		
	}
	
	public void alterar(Dedicado dedic) {
		
		this.id = dedic.getId();
		this.nome = dedic.getNome();
		this.data = dedic.getData();
		this.qtdDom = dedic.getQtdDom();
		this.hd = dedic.getHd();
		this.ram = dedic.getRam();
		this.ip = dedic.getIp();
		this.serv = dedic.getServ();
		this.valor = dedic.getValor();
		this.descr = dedic.getDescr();
		
	}
	
	public void remover(Dedicado dedic) {
		
		new DedicadoDao().remover(dedic.getId());
		dedicList = new DedicadoDao().listar();
		
	}
	private String msg;
	private Integer id;
	private Date data;
	private String nome;
	private Integer qtdDom;
	private Boolean domIlim;
	private String ilim;
	private String hd;
	private String ram;
	private Boolean ipDedic;
	private String ip;
	private Boolean win;
	private Boolean linx;
	private String serv;
	private String descr;
	private BigDecimal valor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtdDom() {
		return qtdDom;
	}
	public void setQtdDom(Integer qtdDom) {
		this.qtdDom = qtdDom;
	}
	public Boolean getDomIlim() {
		return domIlim;
	}
	public void setDomIlim(Boolean domIlim) {
		this.domIlim = domIlim;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public Boolean getIpDedic() {
		return ipDedic;
	}
	public void setIpDedic(Boolean ipDedic) {
		this.ipDedic = ipDedic;
	}

	public Boolean getWin() {
		return win;
	}
	public void setWin(Boolean win) {
		this.win = win;
	}
	public Boolean getLinx() {
		return linx;
	}
	public void setLinx(Boolean linx) {
		this.linx = linx;
	}
	
	public String getServ() {
		return serv;
	}
	public void setServ(String serv) {
		this.serv = serv;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public ArrayList<Dedicado> getDedicList() {
		return dedicList;
	}
	public void setDedicList(ArrayList<Dedicado> dedicList) {
		MBeanPlanoDedicado.dedicList = dedicList;
	}
	public String getIlim() {
		return ilim;
	}
	public void setIlim(String ilim) {
		this.ilim = ilim;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
