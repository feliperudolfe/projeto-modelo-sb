
(function() {

	'use strict'

	angular.module("demo.app").controller("edicaoController", edicaoController);
	angular.module("demo.app").$injector = ['edicaoService'];	
	
	function edicaoController($scope, $state, $stateParams, edicaoService) {
		
		var self = this;
		self.pessoa = {};

		(function init() { 
			_buscarPessoaPorId($stateParams.codPessoa);
		})();// init()
		
		self.salvar = function() {
			_editarPessoa(self.pessoa);
		};// salvar()
		
		self.cancelar = function(codPessoa) {
			$state.go("index");
		};// cancelar()
		
		function _buscarPessoaPorId(codPessoa) {
			edicaoService.buscarPorId(codPessoa).then(function(response) {
				if (response.status == "200") {

					self.pessoa = response.data;
					
					var partes = self.pessoa.dataNascimento.split("-");
					var dia = partes[2];
					var mes = partes[1];
					var ano = partes[0];
					
					self.pessoa.dataNascimento = new Date(ano, mes - 1, dia);

				} else {
					$state.go("index");
				}// if-else
			});// buscarPorId()
		};// _buscarPessoaPorId()
		
		function _editarPessoa(pessoa) {
			edicaoService.editar(pessoa).then(function(response) {
				if (response.status == "200") {
					$state.go("index");
				}// if
			});// editar()
		};// _editarPessoa()
			
	}// edicaoController()
	
})();