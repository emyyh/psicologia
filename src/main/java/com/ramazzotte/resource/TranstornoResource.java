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

import com.ramazzotte.domain.Transtorno;
import com.ramazzotte.domain.dto.TranstornoNewDTO;
import com.ramazzotte.repository.TranstornoRepository;
import com.ramazzotte.service.TranstornoService;


@RestController
@RequestMapping(value = "/transtorno")
public class TranstornoResource {
	
	@Autowired
	private TranstornoService service;
	@Autowired
	private TranstornoRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Transtorno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(@PathVariable Integer id) {
		Transtorno condominio = service.findById(id);
		return ResponseEntity.ok().body(condominio);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody TranstornoNewDTO obj) {
		System.out.println("Linha 37");
		Transtorno apart = service.insertTranstorno(obj);
		return ResponseEntity.ok().body(apart);
	}

	
}
