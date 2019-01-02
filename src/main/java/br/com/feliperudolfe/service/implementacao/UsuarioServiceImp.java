package br.com.feliperudolfe.service.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.feliperudolfe.comum.modelo.Mensagem;
import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.comum.util.Msg;
import br.com.feliperudolfe.modelo.entidade.Perfil;
import br.com.feliperudolfe.modelo.entidade.Pessoa;
import br.com.feliperudolfe.modelo.entidade.Usuario;
import br.com.feliperudolfe.modelo.tipo.Generos;
import br.com.feliperudolfe.repositorio.UsuarioRepository;
import br.com.feliperudolfe.service.PerfilService;
import br.com.feliperudolfe.service.PessoaService;
import br.com.feliperudolfe.service.UsuarioService;
import br.com.feliperudolfe.util.EmailUtil;
import br.com.feliperudolfe.util.ObjetoUtil;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		return this.usuarioRepository.buscarUsuarioPorEmail(email);
	}// buscarUsuarioPorEmail()

	@Override
	public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
		return this.usuarioRepository.buscarUsuarioPorEmailESenha(email, senha);
	}// buscarUsuarioPorEmailESenha()

	@Override
	public Usuario getUsuarioLogado() {
		Usuario retorno = null;
		String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (login != null) {
			retorno = (Usuario) this.userDetailsService.loadUserByUsername(login);
		}// if
		return retorno;
	}// getUsuarioLogado()

	@Override
	public Boolean isUsuarioLogado() {
		Boolean retorno = Boolean.FALSE;
		try {

			Usuario usuario = this.getUsuarioLogado();
			if (usuario != null) {
				retorno = Boolean.TRUE;
			}// if

		} catch (UsernameNotFoundException e) {
			return retorno;
		}// try-catch

		return retorno;
	}// isUsuarioLogado()

	@Override
	public void cadastrar(Usuario usuario) throws NegocioException {

		if (usuario == null) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, "Usuário obrigatório"));
		}// if

		if (usuario.getApelido() == null || "".equals(usuario.getApelido())) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_OBRIGATORIO", "Apelido")));
		} else if (usuario.getApelido().length() < 6) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_TAMANHO_MIN", "Apelido", 6)));
		} else if (usuario.getApelido().length() > 45) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_TAMANHO_MAX", "Apelido", 30)));
		}// if-else

		if (usuario.getEmail() == null || "".equals(usuario.getEmail())) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_OBRIGATORIO", "E-mail")));
		} else if (!EmailUtil.isValido(usuario.getEmail())) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_INVALIDO", "E-mail")));
		} else if (ObjetoUtil.naoEhNulo(this.usuarioRepository.buscarUsuarioPorEmail(usuario.getEmail()))) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_CADASTRADO", "E-mail")));
		}// if-else

		if (usuario.getSenha() == null || "".equals(usuario.getSenha())) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_OBRIGATORIO", "Senha")));
		} else if (usuario.getSenha().length() < 6) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_TAMANHO_MIN", "Senha", 6)));
		} else if (usuario.getSenha().length() > 20) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_TAMANHO_MAX", "Senha", 20)));
		} else if (!usuario.getSenha().equals(usuario.getConfirmarSenha())) {
			throw new NegocioException(new Mensagem(Mensagem.ALERTA, Msg.get("MSG_DIFERENTE", "Senha", "Confirmar Senha")));
		}// if-else

		Perfil perfil = this.perfilService.buscarPorId(1L);

		Pessoa pessoa = new Pessoa();
		pessoa.setNomeCompleto(usuario.getApelido());
		pessoa.setGenero(Generos.M);
		usuario.setPessoa(pessoa);
		usuario.setPerfil(perfil);
		usuario.setAtivo(Boolean.TRUE);

		this.pessoaService.cadastrar(pessoa);
		this.usuarioRepository.save(usuario);
	}// cadastrar()

}