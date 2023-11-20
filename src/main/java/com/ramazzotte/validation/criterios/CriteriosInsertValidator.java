package com.ramazzotte.validation.criterios;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ramazzotte.domain.Criterios;
import com.ramazzotte.domain.dto.CriteriosNewDTO;
import com.ramazzotte.repository.CriteriosRepository;
import com.ramazzotte.resource.exception.FieldMessage;



public class CriteriosInsertValidator implements ConstraintValidator<CriteriosInsert, CriteriosNewDTO> {
	@Autowired
	private CriteriosRepository repo;
	@Override
	public void initialize(CriteriosInsert ann) {	}
	@Override
	public boolean isValid(CriteriosNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Criterios aux1 = repo.findByDescricao(objDto.getDescricao());
		if(aux1 !=null) {
			list.add(new FieldMessage("descricao"," Descrição já existente! "));
		}	
	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();

	}
}