package com.ramazzotte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramazzotte.domain.Usuario;
import com.ramazzotte.domain.dto.UsuarioDTO;
import com.ramazzotte.domain.dto.UsuarioNewDTO;
import com.ramazzotte.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	public List<Usuario> findAll() {
		List<Usuario> list = repo.findAllUsuario();
		return list;
	}

	public Usuario findById(Integer id) {
		Usuario usu = repo.buscarPorId(id);
		return usu;
	}
	
	public Usuario insertUsuario(UsuarioNewDTO obj) {
		Usuario usuario = new Usuario();
		return repo.save(usuario);
	}
	
	public void deleteUsuario(Integer id) {
		repo.deleteById(id);
	}
	
	public Usuario alterUsuario(Integer id, UsuarioDTO obj) {
		Usuario objU = repo.buscarPorId(id);
		objU.setNome(obj.getNome());
		objU.setEmail(obj.getEmail());
		objU.setSenha(obj.getSenha());
		objU.setDtnascimento(obj.getDtnascimento());
		objU.setDtcadastro(obj.getDtcadastro());
		objU.setDtalteracao(obj.getDtalteracao());
		return repo.save(objU);
	}

}
