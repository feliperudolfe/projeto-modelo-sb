(function() {

	'use strict'

	angular.module("demo.app").controller("indexController", indexController);
	angular.module("demo.app").$injector = [ 'indexService', 'mensagemService' ];

	function indexController($scope, $state, indexService, mensagemService) {

		var self = this;
		self.pessoas = [];

		var RudolfesPluginWS = undefined;
		var URL_WS_PLUGIN = "ws://127.0.0.1:777/rudolfes/test";

		(function init() {
			_listarPessoas();
		})();// init()

		self.teste = function() {
			console.log("teste");

			if (!RudolfesPluginWS.isOpenConection()) {
				_solicitarExecucaoPlugin();
			} else {
				// TODO Implementando executar todos os testes
				RudolfesPluginWS.send("{funcao: 2}");
			}// if-else

		};// teste()

		self.cadastrar = function() {
			$state.go("cadastro");
		};// cadastrar()

		self.editar = function(codPessoa) {
			$state.go("edicao", {
				codPessoa : codPessoa
			});
		};// editar()

		self.remover = function(codPessoa) {
			mensagemService.exibirMensagemConfirmar("question", "Confirmação",
					"Deseja realmente excluir esta pessoa?", function() {
						indexService.remover(codPessoa).then(
								function(response) {
									_listarPessoas();
								});// _remover()
					}, function() {
						setTimeout(function() {
							alert("error",
									"Cancelado", "Pessoa não excluída");
						}, 100);
					});
		};// remover()

		function _listarPessoas() {
			indexService.listar().then(function(response) {
				self.pessoas = response.data;
				_conectarAoPlugin();
			});// _listarPessoas()
		}
		;// _listarPessoas()

		function _conectarAoPlugin() {

			try {

				RudolfesPluginWS = new WebSocket(URL_WS_PLUGIN);
				delete RudolfesPluginWS.URL;

			} catch (e) {
				alert("error", "Erro", "Não foi possível estabelecer conexão com o plugin");
			}// try-catch

			 RudolfesPluginWS.isOpenConection = function() {
				return RudolfesPluginWS.readyState === RudolfesPluginWS.OPEN;
			};// isOpenConection()

			RudolfesPluginWS.isOpenConection = function() {
				return RudolfesPluginWS.readyState === RudolfesPluginWS.OPEN;
			};// isOpenConection()

			RudolfesPluginWS.onopen = function(response) {
//				var json = "{funcao: '0', data: {nome: '" + arquivo.nome + "', dataHora: '" + arquivo.dataHora + "'}}";
//				console.log("json: ", json);
//				RudolfesPluginWS.send(json);
		    };// onopen()

		    RudolfesPluginWS.onmessage = function(response) {
		    	console.log("onmessage response: ", response);
		    	console.log("onmessage response.data: ", response.data);
		    };// onmessage()

		    RudolfesPluginWS.onclose = function(response) {
		    	alert('warning', 'Alerta', 'Conexão com o plugin foi fechada');
		    };// onclose()

		    RudolfesPluginWS.onerror = function(error) {
		    	setTimeout(() => {
		    		alert("warning", "Deseja tentar realizar conexão novamente?");
				}, 1000);
		    };// onerror()

		};// _conectarAoPlugin()

	}// indexController()

	function _solicitarExecucaoPlugin() {
		_conectarAoPlugin();
	};// _solicitarExecucaoPlugin()

})();