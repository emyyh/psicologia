package com.ramazzotte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramazzotte.domain.Criterios;
import com.ramazzotte.domain.dto.CriteriosDTO;
import com.ramazzotte.domain.dto.CriteriosNewDTO;
import com.ramazzotte.repository.CriteriosRepository;

@Service
public class CriteriosService {
	
	@Autowired
	private CriteriosRepository repo;

	public List<Criterios> findAll() {
		List<Criterios> list = repo.findAllCriterios ();
		return list;
	}

	public Criterios findById(Integer id) {
		Criterios usu = repo.buscarPorId(id);
		return usu;
	}
	
	public Criterios insertCriterios(CriteriosNewDTO obj) {
		Criterios usuario = new Criterios();
		return repo.save(usuario);
	}
	
	public void deleteCriterios(Integer id) {
		repo.deleteById(id);
	}
	
	public Criterios alterCriterios(Integer id, CriteriosDTO obj) {
		Criterios objC = repo.buscarPorId(id);
		objC.setNome(obj.getNome());
		objC.setDescricao(obj.getDescricao());
		objC.setDtcadastro(obj.getDtcadastro());
		objC.setDtalteracao(obj.getDtalteracao());
		return repo.save(objC);
	}

}
