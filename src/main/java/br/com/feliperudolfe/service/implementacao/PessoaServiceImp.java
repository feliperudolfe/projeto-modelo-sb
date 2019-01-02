package br.com.feliperudolfe.service.implementacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.feliperudolfe.modelo.entidade.Pessoa;
import br.com.feliperudolfe.repositorio.PessoaRepository;
import br.com.feliperudolfe.service.PessoaService;

@Service
public class PessoaServiceImp implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}// listar()

	@Override
	public void cadastrar(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}// cadastrar()

	@Override
	public Pessoa buscarPorId(Long codigo) {
		Pessoa retorno = null;
		Optional<Pessoa> opt = this.pessoaRepository.findById(codigo);
		if (opt.isPresent()) {
			retorno = opt.get();
		}// if
		return retorno;
	}// buscarPorId()
	
	@Override
	public void editar(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}// editar()

	@Override
	public void remover(Long codigo) {
		this.pessoaRepository.deleteById(codigo);
	}

}