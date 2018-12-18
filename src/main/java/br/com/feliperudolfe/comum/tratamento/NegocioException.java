package br.com.feliperudolfe.comum.tratamento;

import java.util.ArrayList;
import java.util.List;

import br.com.feliperudolfe.comum.modelo.Mensagem;

public class NegocioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 572415303334058658L;
	
	private List<Mensagem> mensagens;

	public NegocioException(Mensagem... mensagens) {
		this.mensagens = new ArrayList<Mensagem>();
		for (Mensagem mensagem : mensagens) {
			this.mensagens.add(mensagem);
		}
	}

	public NegocioException(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}


	
}