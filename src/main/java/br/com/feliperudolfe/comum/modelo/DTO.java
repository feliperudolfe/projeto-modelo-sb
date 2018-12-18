package br.com.feliperudolfe.comum.modelo;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import com.google.gson.Gson;

public abstract class DTO<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Gson GSON = new Gson();
	
	@SuppressWarnings("unchecked")
	public E converterEmEntidade() {
		E entidade = null;
		Class<?> classe = ((Class<?>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		if (Entidade.class.isAssignableFrom(classe)) {
			String json = GSON.toJson(this);
			entidade = (E) GSON.fromJson(json, classe);
		}// if
		return entidade;
	}// converterEmEntidade()
	
}