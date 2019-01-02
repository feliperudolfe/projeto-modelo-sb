package br.com.feliperudolfe.modelo.tipo;

public enum Relevancias {

	VERY_LOW("Muito baixa", 1),
	LOW("Baixa", 2),
	AVERAGE("Mormal", 3),
	MODERATE("Moderada", 4),
	HIGH("Alta", 5),
	VERY_HIGH("Muito alta", 6);

	private String value;
	private Integer potential;

	private Relevancias(String value, Integer potential) {
		this.value = value;
		this.potential = potential;
	}// Relevance()

	public String getDecription() {
		return this.value;
	}// getDecription()

	public Integer getPotence() {
		return this.potential;
	}// getPotence()

	public String getReference() {
		return name();
	}// getReference()

	public Integer getReferenceLevel() {
		return ordinal();
	}// getReferenceLevel()

	public static Integer getReferencePotential(String valor) {
		Integer retorno = null;
		for (Relevancias relevance : Relevancias.values()) {
			if (relevance.toString().equals(valor)) {
				retorno = relevance.getPotence();
				break;
			}// if
		}// for
		return retorno;
	}// getReferencePotential()

	public static Relevancias getReference(String valor) {
		Relevancias retorno = null;
		for (Relevancias relevance : Relevancias.values()) {
			if (relevance.toString().equals(valor)) {
				retorno = relevance;
				break;
			}// if
		}// for
		return retorno;
	}// getReference()

}