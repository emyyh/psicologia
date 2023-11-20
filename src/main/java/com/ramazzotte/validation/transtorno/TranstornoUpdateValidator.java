package com.ramazzotte.validation.transtorno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.ramazzotte.domain.Transtorno;
import com.ramazzotte.domain.dto.TranstornoDTO;
import com.ramazzotte.repository.TranstornoRepository;
import com.ramazzotte.resource.exception.FieldMessage;

public class TranstornoUpdateValidator implements ConstraintValidator<TranstornoUpdate, TranstornoDTO> {
	
	@Autowired
	private HttpServletRequest request;	
	@Autowired
	TranstornoRepository repo;	
	@Override
	public void initialize(TranstornoUpdate ann) {
	}
	@Override
	public boolean isValid(TranstornoDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));			
		Transtorno aux = repo.findByNome(objDto.getNome());		
		if(aux !=null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("nome"," Nome já existente."));
		}			

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
