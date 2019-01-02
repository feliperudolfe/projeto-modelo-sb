package br.com.feliperudolfe.modelo.tipo;

public enum Criticidades {

	VERY_LOW("Muito baixa", 1),
	LOW("Baixa", 2),
	AVERAGE("Mormal", 3),
	MODERATE("Moderada", 4),
	HIGH("Alta", 5),
	VERY_HIGH("Muito alta", 6);

	private String value;
	private Integer potential;

	private Criticidades(String value, Integer potential) {
		this.value = value;
		this.potential = potential;
	}// Criticity()

	public String getDecription() {
		return value;
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

	public static Criticidades getCriticity(String valor) {
		Criticidades retorno = null;
		for (Criticidades criticity : Criticidades.values()) {
			if (criticity.toString().equals(valor)) {
				retorno = criticity;
				break;
			}// if
		}// for
		return retorno;
	}// getCriticity()

}