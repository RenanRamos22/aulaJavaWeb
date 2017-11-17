package br.edu.up.aula4etapa.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

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
}
