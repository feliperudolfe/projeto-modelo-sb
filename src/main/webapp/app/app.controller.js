/**
 *
 */

(function() {

	'use strict'

	angular.module("app.controller", []);
	angular.module("app.controller").controller("appController", appController);
	angular.module("app.controller").$injector = ['rootService'];

	function appController($scope, $state, cadastroService) {

		var self = this;
		self.pessoa = {};

	};// appController()

})();