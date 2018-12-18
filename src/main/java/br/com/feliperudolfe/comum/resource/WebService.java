package br.com.feliperudolfe.comum.resource;

import org.springframework.http.ResponseEntity;

import br.com.feliperudolfe.comum.modelo.Resposta;

public abstract class WebService {

	public ResponseEntity<Resposta> criarResposta(Resposta resposta) {
		return ResponseEntity.ok(resposta);
	}
	
}