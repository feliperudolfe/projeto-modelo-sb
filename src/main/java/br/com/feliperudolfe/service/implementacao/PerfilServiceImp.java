package br.com.feliperudolfe.service.implementacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.feliperudolfe.modelo.entidade.Perfil;
import br.com.feliperudolfe.repositorio.PerfilRepository;
import br.com.feliperudolfe.service.PerfilService;

@Service
public class PerfilServiceImp implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public Perfil buscarPorId(Long codigo) {
		Perfil retorno = null;
		Optional<Perfil> opt = this.perfilRepository.findById(codigo);
		if (opt.isPresent()) {
			retorno = opt.get();
		}// if
		return retorno;
	}// buscarPorId()

}