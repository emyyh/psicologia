package com.ramazzotte.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Criterios implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Transtorno transtono;
	private String nome;
	private String descricao;
	private OffsetDateTime dtcadastro;
	private OffsetDateTime dtalteracao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Transtorno getTranstono() {
		return transtono;
	}
	public void setTranstono(Transtorno transtono) {
		this.transtono = transtono;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDtcadastro() {
		return dtcadastro;
	}
	public void setDtcadastro(OffsetDateTime dtcadastro) {
		this.dtcadastro = dtcadastro;
	}
	public OffsetDateTime getDtalteracao() {
		return dtalteracao;
	}
	public void setDtalteracao(OffsetDateTime dtalteracao) {
		this.dtalteracao = dtalteracao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Criterios(Integer id, Transtorno transtono, String nome, String descricao, OffsetDateTime dtcadastro,
			OffsetDateTime dtalteracao) {
		super();
		this.id = id;
		this.transtono = transtono;
		this.nome = nome;
		this.descricao = descricao;
		this.dtcadastro = dtcadastro;
		this.dtalteracao = dtalteracao;
	}
	public Criterios() {
	}
	
	
}