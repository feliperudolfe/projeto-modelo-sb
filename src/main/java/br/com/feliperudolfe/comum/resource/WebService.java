package br.com.feliperudolfe.comum.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.feliperudolfe.comum.modelo.Resposta;
import br.com.feliperudolfe.modelo.entidade.Usuario;

public abstract class WebService {

	@Autowired
	private UserDetailsService userDetailsService;

	public Usuario getUsuarioLogado() {
		Usuario retorno = null;

		String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (login != null) {
			retorno = (Usuario) this.userDetailsService.loadUserByUsername(login);
		}// if

		return retorno;
	}// getUsuarioLogado()

	public ResponseEntity<Resposta> criarResposta(Resposta resposta) {
		return ResponseEntity.ok(resposta);
	}// criarResposta()

}