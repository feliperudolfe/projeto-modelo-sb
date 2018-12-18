package br.com.feliperudolfe.comum.modelo;

/**
 * @author 	felipe.rudolfe
 * @date	3 de dez de 2018 às 18:00:28
 */
public class Mensagem {

	public static final String SUCESSO = "success";
	public static final String ERRO = "error";
	public static final String ALERTA = "warning";
	
	private String tipo;
	private String texto;

	public Mensagem(String tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}