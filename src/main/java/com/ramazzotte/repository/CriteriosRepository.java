package com.ramazzotte.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramazzotte.domain.Criterios;
import com.ramazzotte.domain.Transtorno;


public interface CriteriosRepository extends JpaRepository<Criterios, Integer> {
	@Query(value = "SELECT * FROM condominio", nativeQuery = true)
	List<Criterios> findAllCriterios();
	@Query(value = "SELECT * FROM condominio where id = ?", nativeQuery = true)
	Criterios buscarPorId(Integer id);
	Criterios findByNome(String nome);
	Criterios findByDescricao(String descricao);
	Criterios findByDtcadastro(String dtcadastro);
	Criterios findByDtalteracao(String dtalteracao);

}
