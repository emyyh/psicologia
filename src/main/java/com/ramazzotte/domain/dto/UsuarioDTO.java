package com.ramazzotte.domain.dto;

import java.time.OffsetDateTime;

import com.ramazzotte.validation.usuario.UsuarioUpdate;

@UsuarioUpdate
public class UsuarioDTO {

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private OffsetDateTime dtnascimento;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public OffsetDateTime getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(OffsetDateTime dtnascimento) {
		this.dtnascimento = dtnascimento;
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
	public UsuarioDTO(Integer id, String nome, String email, String senha, OffsetDateTime dtnascimento,
			OffsetDateTime dtcadastro, OffsetDateTime dtalteracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dtnascimento = dtnascimento;
		this.dtcadastro = dtcadastro;
		this.dtalteracao = dtalteracao;
	}
	public UsuarioDTO() {
	}
	
	
}
