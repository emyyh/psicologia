package com.ramazzotte.validation.criterios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.ramazzotte.domain.Criterios;
import com.ramazzotte.domain.dto.CriteriosDTO;
import com.ramazzotte.repository.CriteriosRepository;
import com.ramazzotte.resource.exception.FieldMessage;

public class CriteriosUpdateValidator implements ConstraintValidator<CriteriosUpdate, CriteriosDTO> {
	
	@Autowired
	private HttpServletRequest request;	
	@Autowired
	CriteriosRepository repo;	
	@Override
	public void initialize(CriteriosUpdate ann) {
	}
	@Override
	public boolean isValid(CriteriosDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));			
		Criterios aux = repo.findByDescricao(objDto.getDescricao());		
		if(aux !=null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("descricao"," Descrição já existente."));
		}			

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
