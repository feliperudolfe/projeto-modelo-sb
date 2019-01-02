(function() {

	'use strict'

	angular.module("rudolfes-test.app").factory("indexService", indexService);
	angular.module("rudolfes-test.app").$injector = ['$http', 'urlConfig'];

	function indexService($http, urlConfig) {

		var servico = {
			listarProjetos: listarProjetos,
		};

		function listarProjetos() {
			var url = urlConfig.base + "projeto/listar";
			return $http.get(url).then(_sucesso).catch(_erro);
		};// listarProjetos()

		return servico;
	};// indexService()

	function _sucesso(response) {
		response.data.status = response.status;
		return response.data;
	};// sucesso()

	function _erro(response) {
		response.data.status = response.status;
		return response.data;
	};// erro()

})();