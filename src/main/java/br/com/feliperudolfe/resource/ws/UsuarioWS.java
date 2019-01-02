package br.com.feliperudolfe.resource.ws;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.feliperudolfe.comum.modelo.Resposta;
import br.com.feliperudolfe.comum.resource.WebService;
import br.com.feliperudolfe.modelo.entidade.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioWS extends WebService {

//	@Autowired
//	private UsuarioService usuarioService;

	@RequestMapping(value = "/getDados", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> getDados() {
		Usuario usuario = super.getUsuarioLogado();
		return criarResposta(new Resposta(usuario));
	}// cadastrar()

}