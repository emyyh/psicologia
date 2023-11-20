package com.ramazzotte.validation.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.ramazzotte.domain.Usuario;
import com.ramazzotte.domain.dto.UsuarioDTO;
import com.ramazzotte.repository.UsuarioRepository;
import com.ramazzotte.resource.exception.FieldMessage;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, UsuarioDTO> {
	
	@Autowired
	private HttpServletRequest request;	
	@Autowired
	UsuarioRepository repo;	
	@Override
	public void initialize(UsuarioUpdate ann) {
	}
	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));			
		Usuario aux = repo.findByNome(objDto.getNome());		
		if(aux !=null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("nome"," Nome já existente."));
		}			
		Usuario aux1 = repo.findByEmail(objDto.getEmail());		
		if(aux1 !=null && !aux1.getId().equals(uriId)) {
			list.add(new FieldMessage("email"," Email já existente."));
		}			
		Usuario aux2 = repo.findByNome(objDto.getSenha());		
		if(aux2 !=null && !aux2.getId().equals(uriId)) {
			list.add(new FieldMessage("senha"," Senha já existente."));
		}			

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
