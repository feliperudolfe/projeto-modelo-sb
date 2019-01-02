(function() {

	'use strict'

	angular.module("rudolfes-test.app").controller("indexController", indexController);
	angular.module("rudolfes-test.app").$injector = [ 'indexService', 'mensagemService' ];

	function indexController($scope, $state, indexService, mensagemService) {

		var self = this;
		self.projetos = [];

		(function init() {
			_listarProjetos();
		})();// init()

//		self.cadastrar = function() {
//			$state.go("cadastro");
//		};// cadastrar()
//
//		self.editar = function(codProjeto) {
//			$state.go("edicao", {
//				codProjeto : codProjeto
//			});
//		};// editar()

		self.remover = function(codPessoa) {
			mensagemService.exibirMensagemConfirmar("question", "Confirmação",
				"Deseja realmente excluir esta pessoa?", function() {
					indexService.remover(codPessoa).then(
						function(response) {
							_listarProjetos();
						});// _remover()
				}, function() {
					setTimeout(function() {}, 100);
				});
		};// remover()

		function _listarProjetos() {
			indexService.listarProjetos().then(function(response) {


				console.log("response > ", response);

				self.projetos = response.data;
			});// listarProjetos()
		};// _listarProjetos()

	}// indexController()

})();