package com.ramazzotte.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramazzotte.domain.Transtorno;


public interface TranstornoRepository extends JpaRepository<Transtorno, Integer> {
	@Query(value = "SELECT * FROM condominio", nativeQuery = true)
	List<Transtorno> findAllTranstorno();
	@Query(value = "SELECT * FROM condominio where id = ?", nativeQuery = true)
	Transtorno buscarPorId(Integer id);
	Transtorno findByNome(String nome);
	Transtorno findByCid(String cid);
	Transtorno findByMaisInfo(String maisInfo);
	Transtorno findByPagLivro(String pagLivro);
	Transtorno findByDtcadastro(String dtcadastro);
	Transtorno findByDtalteracao(String dtalteracao);



}
