package br.com.feliperudolfe.resource.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.feliperudolfe.comum.modelo.Resposta;
import br.com.feliperudolfe.comum.resource.WebService;
import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.modelo.entidade.Projeto;
import br.com.feliperudolfe.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoWS extends WebService {

	@Autowired
	private ProjetoService projetoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> listar() throws NegocioException {
		List<Projeto> projetos = this.projetoService.listar();
		return criarResposta(new Resposta(projetos));
	}// listar()

}