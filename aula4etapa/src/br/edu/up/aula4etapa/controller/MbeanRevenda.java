package br.edu.up.aula4etapa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.catalina.core.ApplicationPart;

import br.edu.up.aula4etapa.dao.PlanoCompartilhadoDao;
import br.edu.up.aula4etapa.dao.RevendaDao;
import br.edu.up.aula4etapa.entity.Revenda;



@ManagedBean(name = "mBeanRevenda")
public class MbeanRevenda {

	static private ArrayList<Revenda> revList = new ArrayList<Revenda>(); 
	
	@PostConstruct
	public void carregar() {
		revList = new RevendaDao().listar();
	}
	
	public void salvar() {
	
String caminhoImagem = "";
		
		if(imagem != null && imagem.getSubmittedFileName() != null) {
			
			 caminhoImagem = "C:\\Users\\Renan\\Documents\\Imagens_ProjetoJava\\"+imagem.getSubmittedFileName();
			
			try {
				byte[] bytesImagem = new byte[(int) imagem.getSize()];
				imagem.getInputStream().read(bytesImagem);
				File f = new File(caminhoImagem);
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytesImagem);
				
				fos.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	Revenda plano = new Revenda();
	plano.setId(this.id);
	plano.setData(data);
	plano.setNome(nome);
	plano.setQtdDom(qtdDom);
	plano.setHd(hd);
	plano.setQtdMsq(qtdMsq);
	plano.setQtdSql(qtdSql);
	plano.setValor(valor);
	plano.setDesc(desc);
	plano.setImgUrl(caminhoImagem);
	
	//Logica para sinalizar se o plano terá os serviços de contas de e-mail ou softaculous
			if(flagEmail == false  && flagSoftc == false) 
			{
				plano.setEmail("Não");
				plano.setSoftc("Não");
			}
			if (flagEmail == true && flagSoftc == true) 
			{
					plano.setSoftc("Sim");
					plano.setEmail("Sim");
			}
			if(flagEmail == false && flagSoftc == true)
			{
				plano.setSoftc("Sim");
				plano.setEmail("Não");
			}	
			if(flagEmail == true && flagSoftc == false)
			{
				plano.setSoftc("Não");
				plano.setEmail("Sim");
			}
			
			//A mesma logica aplicada acima para os checkbox dos servidores
			if(win && linx) 
			{
				plano.setServ("Windows - Linux");
			}
			if(!win && !linx)
			{
				//VERIFICAR COM PROFESSOR COMO RETORNAR O AVISO NA VIEW
				System.out.print("Escolha no minimo uma Plataforma");
			}
			if(!win && linx)
			{
				plano.setServ("Linux");
			}
			if(win && !linx)
			{
				plano.setServ("Windows");
			}
			
			if(this.id == null) {
				new RevendaDao().salvar(plano);
			} else {
				new RevendaDao().alterar(plano);
			}
			revList = new RevendaDao().listar();
	}
	private Integer id;
	private Date data;
	private String nome;
	private String qtdDom;
	private String hd;
	private Integer qtdMsq;
	private Integer qtdSql;
	private String email;
	private boolean flagEmail;
	private String softc;
	private boolean flagSoftc;
	private boolean win;
	private boolean linx;
	private String serv;
	private BigDecimal valor;
	private String desc;
	private ApplicationPart imagem;
	
	
	public ArrayList<Revenda> getRevList() {
		return revList;
	}
	public void setRevList(ArrayList<Revenda> revList) {
		this.revList = revList;
	}
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQtdDom() {
		return qtdDom;
	}
	public void setQtdDom(String qtdDom) {
		this.qtdDom = qtdDom;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public Integer getQtdMsq() {
		return qtdMsq;
	}
	public void setQtdMsq(Integer qtdMsq) {
		this.qtdMsq = qtdMsq;
	}
	public Integer getQtdSql() {
		return qtdSql;
	}
	public void setQtdSql(Integer qtdSql) {
		this.qtdSql = qtdSql;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isFlagEmail() {
		return flagEmail;
	}
	public void setFlagEmail(boolean flagEmail) {
		this.flagEmail = flagEmail;
	}
	public String getSoftc() {
		return softc;
	}
	public void setSoftc(String softc) {
		this.softc = softc;
	}
	public boolean isFlagSoftc() {
		return flagSoftc;
	}
	public void setFlagSoftc(boolean flagSoftc) {
		this.flagSoftc = flagSoftc;
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
	public String getServ() {
		return serv;
	}
	public void setServ(String serv) {
		this.serv = serv;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ApplicationPart getImagem() {
		return imagem;
	}
	public void setImagem(ApplicationPart imagem) {
		this.imagem = imagem;
	}
	
	
}
