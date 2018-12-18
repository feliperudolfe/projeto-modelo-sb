/**
 *
 */

(function () {

	'use strict'

	angular.module("app.interceptor", []);
	angular.module("app.interceptor").factory("appInterceptor", appInterceptor);
	angular.module("app.interceptor").$inject = ['mensagemService'];

	function appInterceptor($q, mensagemService) {

		return {

			request : function(appConfig) {
				return appConfig;
			},// request

			requestError : function(rejection) {
				return $q.reject(rejection);
			},// requestError

			response : function(response) {

				console.log("response: ", response);
				if (response != undefined && response.data != undefined && response.data.mensagens != undefined && response.data.mensagens.length > 0) {
					for (var i in response.data.mensagens) {
						mensagemService.exibirMensagensSimples(response.data.mensagens[i]);
					}// for
				}// if
//				if (response != undefined && response.data != undefined && response.data.mensagens != undefined && response.data.mensagens.length > 0) {
//					mensagemService.exibirMensagensSimples(response.data.mensagens);
//				}// if
				return response;
			},// response

			responseError : function(response) {
				console.log("response: ", response);
				if (response != undefined && response.data != undefined && response.data.mensagens != undefined && response.data.mensagens.length > 0) {
					for (var i in response.data.mensagens) {
						mensagemService.exibirMensagensSimples(response.data.mensagens[i]);
					}// for
				}// if
				return $q.reject(response);
			}// responseError

		};
	};// appInterceptor()

})();