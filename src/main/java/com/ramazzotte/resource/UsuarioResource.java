package com.ramazzotte.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ramazzotte.domain.Usuario;
import com.ramazzotte.domain.dto.UsuarioNewDTO;
import com.ramazzotte.repository.UsuarioRepository;
import com.ramazzotte.service.UsuarioService;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(@PathVariable Integer id) {
		Usuario condominio = service.findById(id);
		return ResponseEntity.ok().body(condominio);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody UsuarioNewDTO obj) {
		System.out.println("Linha 37");
		Usuario apart = service.insertUsuario(obj);
		return ResponseEntity.ok().body(apart);
	}
	
}