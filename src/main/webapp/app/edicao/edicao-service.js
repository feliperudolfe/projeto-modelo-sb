(function() {

	'use strict'

	angular.module("demo.app").factory("edicaoService", edicaoService);
	angular.module("demo.app").$injector = ['$http', 'urlConfig'];

	function edicaoService($http, urlConfig) {

		var servico = {
			buscarPorId: buscarPorId,
			editar: editar
		};

		function buscarPorId(codPessoa) {
			var url = urlConfig.base + "pessoa/buscar/" + codPessoa;
			return $http.get(url).then(_sucesso).catch(_erro);
		};// buscarPorId()
		
		function editar(pessoa) {
			var url = urlConfig.base + "pessoa/editar/";
			return $http.post(url, pessoa).then(_sucesso).catch(_erro);
		};// editar()

		return servico;
	};// edicaoService()
	
	function _sucesso(response) {
		response.data.status = response.status;
		return response.data;
	};// sucesso()
	
	function _erro(response) {
		response.data.status = response.status;
		return response.data;
	};// erro()
	
})();