(function() {

	'use strict'

	angular.module("rudolfes-test.app").factory("indexService", indexService);
	angular.module("rudolfes-test.app").$injector = ['$http', 'urlConfig'];

	function indexService($http, urlConfig) {

		var servico = {
			listar: listar,
			remover: remover
		};

		function listar() {
			var url = urlConfig.base + "pessoa/listar";
			return $http.get(url).then(_sucesso).catch(_erro);
		};// listar()

		function remover(codPessoa) {
			var url = urlConfig.base + "pessoa/remover/";
			return $http.delete(url, {params: {codPessoa: codPessoa}}).then(_sucesso).catch(_erro);
		};// remover()

		return servico;
	};// indexService()

	function _sucesso(response) {
		response.data.status = response.status;
		return response.data;
	};// sucesso()

	function _erro(response) {

		console.log("response: ", response);
		response.data.status = response.status;
		return response.data;
	};// erro()

})();