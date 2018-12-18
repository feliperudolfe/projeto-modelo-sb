package br.com.phoebus.demo.resource.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.phoebus.comum.modelo.Mensagem;
import br.com.phoebus.comum.modelo.Resposta;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MethodArgumentNotValidExceptionHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Resposta methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		return processFieldErrors(fieldErrors);
	}// methodArgumentNotValidException()

	private Resposta processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		for (org.springframework.validation.FieldError fieldError : fieldErrors) {
			mensagens.add(new Mensagem(Mensagem.ALERTA, fieldError.getDefaultMessage()));
		} // for
		return new Resposta(null, mensagens);
	}// processFieldErrors()

}