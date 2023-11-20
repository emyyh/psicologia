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

import com.ramazzotte.domain.Criterios;
import com.ramazzotte.domain.dto.CriteriosNewDTO;
import com.ramazzotte.repository.CriteriosRepository;
import com.ramazzotte.service.CriteriosService;


@RestController
@RequestMapping(value = "/criterio")
public class CriteriosResource {
	
	@Autowired
	private CriteriosService service;
	@Autowired
	private CriteriosRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Criterios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(@PathVariable Integer id) {
		Criterios condominio = service.findById(id);
		return ResponseEntity.ok().body(condominio);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody CriteriosNewDTO obj) {
		System.out.println("Linha 37");
		Criterios apart = service.insertCriterios(obj);
		return ResponseEntity.ok().body(apart);
	}
	
}
