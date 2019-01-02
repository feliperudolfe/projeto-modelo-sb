package br.com.feliperudolfe.service.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.feliperudolfe.comum.modelo.Mensagem;
import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.comum.util.Msg;
import br.com.feliperudolfe.modelo.entidade.Projeto;
import br.com.feliperudolfe.modelo.entidade.Usuario;
import br.com.feliperudolfe.repositorio.ProjetoRepository;
import br.com.feliperudolfe.service.ProjetoService;
import br.com.feliperudolfe.service.UsuarioService;
import br.com.feliperudolfe.util.ObjetoUtil;

/**
 * @Autor 		Felipe Rudolfe Carvalho Pinheiro
 * @Data		26 de dez de 2018 às 21:07:17
 */
@Service
public class ProjetoServiceImp implements ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public List<Projeto> listar() throws NegocioException {

		Usuario usuario = this.usuarioService.getUsuarioLogado();
		if (ObjetoUtil.ehNulo(usuario)) {
			throw new NegocioException(Mensagem.ERRO, Msg.get("MSG_NAO_AUTENTICADO"));
		}// if

		return this.projetoRepository.buscarProjetosPorUsuario(usuario.getCodigo());
	}// listar()

}