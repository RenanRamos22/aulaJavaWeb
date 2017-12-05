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
import br.edu.up.aula4etapa.entity.Dedicado;
import br.edu.up.aula4etapa.entity.PlanoComp;
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
	plano.setValor(valor);
	plano.setDesc(desc);
	plano.setImgUrl(caminhoImagem);
	
	if(hd.equals("NULL")) {
		plano.setHd("Não possui ");
	}else {
		plano.setHd(hd);
	}
	
	if(qtdDom.equals("0")) {
		plano.setQtdDom("- Não possui Site");
	}
	
	else {
		
		plano.setQtdDom("Ate "+qtdDom+" Site(s)");
	}
	
	if(qtdMsq == null || qtdMsq== 0) {
		plano.setQtdMsq(qtdMsq = null);
		plano.setBancoMsql("Não possui Banco de Dados MySQL");
		}else {
		plano.setQtdMsq(qtdMsq);
		plano.setBancoMsql(" Banco de Dados MySQL");
		}
		
	if(qtdSql == null || qtdSql== 0) {
		plano.setQtdSql(qtdSql = null);
		plano.setBancoSql("Não possui Banco de Dados SQL");
		}else {
			plano.setQtdSql(qtdSql);
			plano.setBancoSql(" Banco de Dados SQL");
		}

	//Logica para sinalizar se o plano terï¿½ os serviï¿½os de contas de e-mail ou softaculous
			if(flagEmail == false  && flagSoftc == false) 
			{
				plano.setEmail("");
				plano.setSoftc("");
			}
			if (flagEmail == true && flagSoftc == true) 
			{
					plano.setSoftc("Softaculous");
					plano.setEmail("Contas de E-mail");
			}
			if(flagEmail == false && flagSoftc == true)
			{
				plano.setSoftc("Softaculous");
				plano.setEmail("");
			}	
			if(flagEmail == true && flagSoftc == false)
			{
				plano.setSoftc("");
				plano.setEmail("Contas de E-mail");
			}
			
			
			
			if(this.id == null) {
				new RevendaDao().salvar(plano);
			} else {
				new RevendaDao().alterar(plano);
			}
			revList = new RevendaDao().listar();
			limpar();
	}
	
	public void limpar() {
		this.id = null;
		this.data = null;
		this.nome = "";
		this.qtdDom = "";
		this.hd = "";
		this.qtdMsq = null;
		this.qtdSql = null;
		this.valor =null;
		this.desc = "";
		revList = new RevendaDao().listar();
		
	}
	
	public void alterar(Revenda plano) {
		this.id = plano.getId();
		this.data = plano.getData();
		this.nome = plano.getNome();
		//this.qtdDom = plano.getQtdDom();
		this.hd = plano.getHd();
		this.qtdMsq = plano.getQtdMsq();
		this.qtdSql = plano.getQtdSql();
		this.valor = plano.getValor();
		this.desc = plano.getDesc();
		
	}
	
	public void remover(Revenda plano) {
		
		new RevendaDao().remover(plano.getId());
		revList = new RevendaDao().listar();
		
	}
	
	public String carregarPlano(Revenda plano) {
		this.id = plano.getId();
		this.data = plano.getData();
		this.nome = plano.getNome();
		this.qtdDom = plano.getQtdDom();
		this.hd = plano.getHd();
		this.qtdMsq = plano.getQtdMsq();
		this.qtdSql = plano.getQtdSql();
		this.valor = plano.getValor();
		this.desc = plano.getDesc();
		this.bancoMsql = plano.getBancoMsql();
		this.bancoSql = plano.getBancoSql();
		this.email = plano.getEmail();
		this.softc = plano.getSoftc();
		
		return "descricaoRevenda.jsf";
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
	/*private boolean win;
	private boolean linx;
	private String serv;*/
	private BigDecimal valor;
	private String desc;
	private ApplicationPart imagem;
	private String bancoMsql;
	private String bancoSql;
	
	public ArrayList<Revenda> getRevList() {
		return revList;
	}
	public void setRevList(ArrayList<Revenda> revList) {
		this.revList = revList;
	}
	public Integer getId() {
		return id;
	}
	
	public String getBancoMsql() {
		return bancoMsql;
	}

	public void setBancoMsql(String bancoMsql) {
		this.bancoMsql = bancoMsql;
	}

	public String getBancoSql() {
		return bancoSql;
	}

	public void setBancoSql(String bancoSql) {
		this.bancoSql = bancoSql;
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
	/*public boolean isWin() {
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
	}*/
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
