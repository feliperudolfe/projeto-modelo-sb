package br.com.feliperudolfe.resource.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.feliperudolfe.comum.modelo.Mensagem;
import br.com.feliperudolfe.comum.modelo.Resposta;
import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.comum.util.Msg;

public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(RestResponseExceptionHandler.class);

	@ExceptionHandler(NegocioException.class)
	protected ResponseEntity<Object> tratarNegocioException(NegocioException ex, WebRequest request) {
		Resposta resposta = new Resposta(ex.getMensagens());
		return handleExceptionInternal(ex, resposta, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}// tratarNegocioException()

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> tratarOutrasExceptions(Exception ex, WebRequest request) {
		LOGGER.info("ERROR: " + ex.getMessage());
		Resposta resposta = new Resposta(null, new Mensagem(Mensagem.ERRO, Msg.get("MSG_ERRO_PADRAO")));
		return handleExceptionInternal(ex, resposta, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}// tratarOutrasExceptions()


}