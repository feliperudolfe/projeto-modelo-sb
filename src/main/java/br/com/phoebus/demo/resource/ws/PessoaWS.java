package br.com.phoebus.demo.resource.ws;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.phoebus.comum.modelo.Mensagem;
import br.com.phoebus.comum.modelo.Resposta;
import br.com.phoebus.comum.resource.WebService;
import br.com.phoebus.demo.modelo.dto.PessoaDTO;
import br.com.phoebus.demo.modelo.entidade.Pessoa;
import br.com.phoebus.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaWS extends WebService {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> listar() {
		List<Pessoa> pessoas = this.pessoaService.listar();
		return criarResposta(new Resposta(pessoas));
	}// listar()

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> cadastrar(@Valid @RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaDTO.converterEmEntidade();
		this.pessoaService.cadastrar(pessoa);
		return criarResposta(new Resposta(null, new Mensagem(Mensagem.SUCESSO, "Pessoa cadastrada com sucesso")));
	}// cadastrar()

	@RequestMapping(value = "/buscar/{codPessoa:[\\d]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> buscarPorId(@PathVariable(name = "codPessoa", required = true) Long codPessoa) {
		Pessoa pessoa = this.pessoaService.buscarPorId(codPessoa);
		return criarResposta(new Resposta(pessoa));
	}// buscarPorId()

	@RequestMapping(value = "/editar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> editar(@Valid @RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaDTO.converterEmEntidade();
		this.pessoaService.editar(pessoa);
		return criarResposta(new Resposta(null, new Mensagem(Mensagem.SUCESSO, "Pessoa atualizada com sucesso")));
	}// editar()

	@RequestMapping(value = "/remover", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> remover(@RequestParam(name = "codPessoa", required = true) Long codPessoa) {
		this.pessoaService.remover(codPessoa);
		return criarResposta(new Resposta(null, new Mensagem(Mensagem.SUCESSO, "Pessoa removida com sucesso")));
	}// remover()

}