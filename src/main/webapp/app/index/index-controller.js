(function() {

	'use strict'

	angular.module("rudolfes-test.app").controller("indexController", indexController);
	angular.module("rudolfes-test.app").$injector = [ 'indexService', 'mensagemService' ];

	function indexController($scope, $state, indexService, mensagemService) {

		var self = this;
		self.pessoas = [];

		(function init() {
			_listarPessoas();
		})();// init()

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
					setTimeout(function() {}, 100);
				});
		};// remover()

		function _listarPessoas() {
			indexService.listar().then(function(response) {
				self.pessoas = response.data;
			});// _listarPessoas()
		};// _listarPessoas()

	}// indexController()

})();