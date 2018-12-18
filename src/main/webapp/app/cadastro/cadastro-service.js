(function() {

	'use strict'

	angular.module("demo.app").factory("cadastroService", cadastroService);
	angular.module("demo.app").$injector = ['$http', 'urlConfig'];

	function cadastroService($http, urlConfig) {

		var servico = {
			cadastrar: cadastrar
		};

		function cadastrar(pessoa) {
			var url = urlConfig.base + "pessoa/cadastrar";
			return $http.post(url, pessoa).then(_sucesso).catch(_erro);
		};// cadastrar()

		return servico;
	};// cadastroService()
	
	function _sucesso(response) {
		response.data.status = response.status;
		return response.data;
	};// sucesso()
	
	function _erro(response) {
		response.data.status = response.status;
		return response.data;
	};// erro()
	
})();