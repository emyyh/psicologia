package com.ramazzotte.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramazzotte.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query(value = "SELECT * FROM condominio", nativeQuery = true)
	List<Usuario> findAllUsuario();
	@Query(value = "SELECT * FROM condominio where id = ?", nativeQuery = true)
	Usuario buscarPorId(Integer id);
	Usuario findByNome(String nome);
	Usuario findByEmail(String email);
	Usuario findBySenha(String senha);
	Usuario findByDtnascimento(String dtnascimento);
	Usuario findByDtcadastro(String dtcadastro);
	Usuario findByDtalteracao(String dtalteracao);
	


}
