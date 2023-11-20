package com.ramazzotte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramazzotte.domain.Transtorno;
import com.ramazzotte.domain.dto.TranstornoDTO;
import com.ramazzotte.domain.dto.TranstornoNewDTO;
import com.ramazzotte.repository.TranstornoRepository;

@Service
public class TranstornoService {
	
	@Autowired
	private TranstornoRepository repo;

	public List<Transtorno> findAll() {
		List<Transtorno> list = repo.findAllTranstorno();
		return list;
	}

	public Transtorno findById(Integer id) {
		Transtorno usu = repo.buscarPorId(id);
		return usu;
	}
	
	public Transtorno insertTranstorno(TranstornoNewDTO obj) {
		Transtorno usuario = new Transtorno();
		return repo.save(usuario);
	}
	
	public void deleteTranstorno(Integer id) {
		repo.deleteById(id);
	}
	
	public Transtorno alterTranstorno(Integer id, TranstornoDTO obj) {
		Transtorno objT = repo.buscarPorId(id);
		objT.setCid(obj.getCid());
		objT.setMaisInfo(obj.getMaisInfo());
		objT.setDtcadastro(obj.getDtcadastro());
		objT.setDtalteracao(obj.getDtalteracao());
		return repo.save(objT);
	}

}
