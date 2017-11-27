package br.edu.up.aula4etapa.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table
public class Revenda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Date data;
	private String nome;
	private String qtdDom;
	private String hd;
	private Integer qtdMsq;
	private Integer qtdSql;
	private String email;
	private String softc;
	private String serv;
	private BigDecimal valor;
	@Column(length = 100000)
	@Lob
	private String desc;
	private String imgUrl;
	private String bancoMsql;
	private String bancoSql;
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public String getSoftc() {
		return softc;
	}
	public void setSoftc(String softc) {
		this.softc = softc;
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
	
	
}
