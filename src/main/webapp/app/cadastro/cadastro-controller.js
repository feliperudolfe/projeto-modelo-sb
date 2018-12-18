
(function() {

	'use strict'

	angular.module("demo.app").controller("cadastroController", cadastroController);
	angular.module("demo.app").$injector = ['cadastroService'];	
	
	function cadastroController($scope, $state, cadastroService) {
		
		var self = this;
		self.pessoa = {};

		(function init() { 
			
			self.pessoa = {
				nome: "",
				genero: "M",
				dataNascimento: ""
			};
			
		})();// init()
		
		self.cadastrar = function() {
			_cadastrarPessoa(self.pessoa);
		};// cadastrar()
		
		self.cancelar = function(codPessoa) {
			$state.go("index");
		};// cancelar()
		
		self.limpar = function() {
			self.pessoa = {
				nome: "",
				genero: "M",
				dataNascimento: ""
			};
		};// limpar()
		
		function _cadastrarPessoa(pessoa) {
			cadastroService.cadastrar(pessoa).then(function(response) {
				if (response.status == "200") {
					$state.go("index");
				}// if
			});// cadastrar()
		};// _cadastrarPessoa()
			
	}// cadastroController()
	
})();