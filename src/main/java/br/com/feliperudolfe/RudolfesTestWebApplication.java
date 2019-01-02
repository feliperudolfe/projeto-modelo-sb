package br.com.feliperudolfe;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.feliperudolfe.comum.modelo.Mensagem;
import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.modelo.entidade.Usuario;
import br.com.feliperudolfe.service.UsuarioService;
import br.com.feliperudolfe.util.ObjetoUtil;

@Controller
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"br.com.feliperudolfe"})
public class RudolfesTestWebApplication {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(RudolfesTestWebApplication.class, args);
	}

	@GetMapping("/login")
    public String login(){
        return "login";
    }// login()

	@GetMapping("/cadastro")
    public String cadastro(Model model){
		model.addAttribute("usuario", new Usuario());
		return "cadastro";
    }// cadastro()

	@GetMapping("/esqueceuasenha")
    public String esqueceuasenha(Model model){
		model.addAttribute("usuario", new Usuario());
		return "esqueceuasenha";
    }// esqueceuasenha()

	@PostMapping(value = "/cadastro", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public String cadastrar(@ModelAttribute Usuario usuario, Model model) {

		String retorno = "login";
		try {

			this.usuarioService.cadastrar(usuario);

			model.addAttribute("msgtipo", Mensagem.SUCESSO);
			model.addAttribute("msgtexto", "Usuário cadastrado com sucesso.");

		} catch (NegocioException e) {
			for (Mensagem msg : e.getMensagens()) {
				model.addAttribute("msgtipo", msg.getTipo());
				model.addAttribute("msgtexto", msg.getTexto());
			}// for
			retorno = "cadastro";
		}// try-catch

        return retorno;
    }// cadastrar()

	@PostMapping(value = "/esqueceuasenha", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public String esqueceuasenha(@ModelAttribute Usuario usuario, Model model) {

		String retorno = "login";
		try {

			Usuario user = this.usuarioService.buscarUsuarioPorEmail(usuario.getEmail());
			if (ObjetoUtil.ehNulo(user)) {
				throw new NegocioException(Mensagem.ALERTA, "Nenhum usuário com e-mail cadastrado.");
			}// if

			model.addAttribute("msgtipo", Mensagem.SUCESSO);
			model.addAttribute("msgtexto", "E-mail de recuperação de senha enviado com sucesso.");

		} catch (NegocioException e) {
			for (Mensagem msg : e.getMensagens()) {
				model.addAttribute("msgtipo", msg.getTipo());
				model.addAttribute("msgtexto", msg.getTexto());
			}// for
			retorno = "esqueceuasenha";
		}// try-catch

        return retorno;
    }// cadastrar()

}