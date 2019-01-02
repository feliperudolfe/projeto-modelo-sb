package br.com.feliperudolfe.modelo.tipo;

public enum Resultados {

	ACERTO,
	ERRO,
	FALHA,
	NAO_EXECUTADO

	;

	@SuppressWarnings("static-access")
	public static Resultados getResultado(String avaliacao) {

		Resultados retorno = null;
		if ("SUCCESS".equals(avaliacao)) {
			retorno = retorno.ACERTO;
		} else if ("ERROR".equals(avaliacao)) {
			retorno = retorno.ERRO;
		} else if ("FAILURE".equals(avaliacao)) {
			retorno = retorno.FALHA;
		} else if ("NO_EXECUTION".equals(avaliacao)) {
			retorno = retorno.NAO_EXECUTADO;
		}// if-else

		return retorno;
	}// getResultado()

}