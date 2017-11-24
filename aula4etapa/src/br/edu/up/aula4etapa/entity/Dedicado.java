package br.edu.up.aula4etapa.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Dedicado {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Date data;
	private String nome;
	private String qtdDom;
	private String ilim;
 	private String hd;
	private String ram;
	private String ip;
	private String imgUrl;
	private String BancoMysql;
	private String BancoSql;
	
	@Column(length = 100000)
	private String descr;
	private BigDecimal valor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBancoMysql() {
		return BancoMysql;
	}
	public void setBancoMysql(String bancoMysql) {
		BancoMysql = bancoMysql;
	}
	public String getBancoSql() {
		return BancoSql;
	}
	public void setBancoSql(String bancoSql) {
		BancoSql = bancoSql;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
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
	
}
