package br.com.phoebus.comum.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resposta implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -9218095593897726651L;

	private Object data;
	private List<Mensagem> mensagens;

	public Resposta(Object data, Mensagem ... mensagens) {
		this.data = data;
		this.mensagens = new ArrayList<Mensagem>();
		for (Mensagem msg : mensagens) {
			this.mensagens.add(msg);
		}// for
	}

	public Resposta(Object data, List<Mensagem> mensagens) {
		this.data = data;
		this.mensagens = new ArrayList<Mensagem>();
		for (Mensagem msg : mensagens) {
			this.mensagens.add(msg);
		}// for
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public void addMensagem(Mensagem mensagem) {
		if (this.mensagens == null) {
			this.mensagens = new ArrayList<Mensagem>();
		}
		this.mensagens.add(mensagem);
	}

}