package com.ramazzotte.domain.dto;

import java.time.OffsetDateTime;

import com.ramazzotte.validation.transtorno.TranstornoUpdate;

@TranstornoUpdate
public class TranstornoDTO {
	private Integer id;
	private String nome;
	private String cid;
	private String maisInfo;
	private String pagLivro;
	private OffsetDateTime dtcadastro;
	private OffsetDateTime dtalteracao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getMaisInfo() {
		return maisInfo;
	}
	public void setMaisInfo(String maisInfo) {
		this.maisInfo = maisInfo;
	}
	public String getPagLivro() {
		return pagLivro;
	}
	public void setPagLivro(String pagLivro) {
		this.pagLivro = pagLivro;
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
	public TranstornoDTO(Integer id, String nome, String cid, String maisInfo, String pagLivro,
			OffsetDateTime dtcadastro, OffsetDateTime dtalteracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cid = cid;
		this.maisInfo = maisInfo;
		this.pagLivro = pagLivro;
		this.dtcadastro = dtcadastro;
		this.dtalteracao = dtalteracao;
	}
	public TranstornoDTO() {
	}
	
	
}
