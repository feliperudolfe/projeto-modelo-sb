/**
 *
 */

(function() {

	'use strict'

	angular.module("app.controller", []);
	angular.module("app.controller").controller("rootController", rootController);
	angular.module("app.controller").$injector = ['rootService'];

	function rootController($scope, $state, rootService) {

		var self = this;
		var usuario = {};

		(function inif() {
			console.log("Root Controller");
			_getUsuarioLogado();
		})()

		self.getImagemUsuario = function() {
			return usuario.imagem;
		};// getImagemUsuario()

		self.getApelidoUsuario = function() {
			return usuario.apelido;
		};// getApelidoUsuario()

		self.getUsuarioLogado = function() {
			return usuario;
		};// getUsuarioLogado()

		function _getUsuarioLogado() {
			rootService.getUsuarioLogado().then(function (response) {
				if (response.status == "200") {

					usuario = response.data;
					if (usuario.imagem == null) {
						if (usuario.pessoa.genero == "F") {
							usuario.imagem = "resources/img/avatar/avatar-mulher.png"
						} else {
							usuario.imagem = "resources/img/avatar/avatar-homem.png"
						}// if-else
					}// if

				}// if
			});// getUsuarioLogado()
		};// _getUsuarioLogado()

	};// rootController()

})();