package com.ramazzotte.validation.transtorno;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ramazzotte.domain.Transtorno;
import com.ramazzotte.domain.dto.TranstornoNewDTO;
import com.ramazzotte.repository.TranstornoRepository;
import com.ramazzotte.resource.exception.FieldMessage;



public class TranstornoInsertValidator implements ConstraintValidator<TranstornoInsert, TranstornoNewDTO> {
	@Autowired
	private TranstornoRepository repo;
	@Override
	public void initialize(TranstornoInsert ann) {	}
	@Override
	public boolean isValid(TranstornoNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Transtorno aux1 = repo.findByNome(objDto.getNome());
		if(aux1 !=null) {
			list.add(new FieldMessage("Nome"," Nome já existente! "));
		}	
		Transtorno aux3 = repo.findByMaisInfo(objDto.getMaisInfo());
		if(aux3 !=null) {
			list.add(new FieldMessage("maisInfo"," MaisInfo já existente! "));
		}
		Transtorno aux4 = repo.findByPagLivro((objDto.getPagLivro()));
		if(aux4 !=null) {
			list.add(new FieldMessage("pagLivro("," PagLivro já existente! "));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();

	}
}
