package com.ramazzotte.validation.usuario;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ramazzotte.domain.Usuario;
import com.ramazzotte.domain.dto.UsuarioNewDTO;
import com.ramazzotte.repository.UsuarioRepository;
import com.ramazzotte.resource.exception.FieldMessage;



public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {
	@Autowired
	private UsuarioRepository repo;
	@Override
	public void initialize(UsuarioInsert ann) {	}
	@Override
	public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario aux1 = repo.findByNome(objDto.getNome());
		if(aux1 !=null) {
			list.add(new FieldMessage("nome"," Nome já existente! "));
		}	
		Usuario aux2 = repo.findByEmail(objDto.getEmail());
		if(aux2 !=null) {
			list.add(new FieldMessage("email"," Email já existente! "));
		}	
		Usuario aux3 = repo.findBySenha(objDto.getSenha());
		if(aux3 !=null) {
			list.add(new FieldMessage("senha"," Senha já existente! "));
		}	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();

	}
}
