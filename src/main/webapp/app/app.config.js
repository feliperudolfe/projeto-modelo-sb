/**
 *
 */

(function() {

	'use strict'

	angular.module('app.config', ["ui.router"]);

	angular.module('app.config').value("urlConfig", {
		base: window.location.origin + "/",// + "${servico.url}:${servico.porta}/",
	});// baseConfig()

	angular.module('app.config').config(function($httpProvider) {
		$httpProvider.interceptors.push("appInterceptor");
	});// interceptors()

	angular.module('app.config').config(function($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/');

		$stateProvider

		.state('index', {
			name: 'index',
			url: '/',
			views: {
				'view@': {
					templateUrl: 'app/index/index-view.html',
					resolve : {
	    				load : function($ocLazyLoad) {
	    					return $ocLazyLoad.load({
	    						name : 'js',
	    						files : [
	    							'app/index/index-controller.js',
	    							'app/index/index-service.js'
    							]
	    					});
	    				}
	    			}
				}
			}
		})

		.state('cadastro', {
			name: 'cadastro',
			url: '/cadastro',
			views: {
				'view@': {
					templateUrl: 'app/cadastro/cadastro-view.html',
					resolve : {
	    				load : function($ocLazyLoad) {
	    					return $ocLazyLoad.load({
	    						name : 'js',
	    						files : [
	    							'app/cadastro/cadastro-controller.js',
	    							'app/cadastro/cadastro-service.js'
    							]
	    					});
	    				}
	    			}
				}
			}
		})

		.state('edicao', {
			name: 'edicao',
			url: '/edicao/:codPessoa',
			views: {
				'view@': {
					templateUrl: 'app/edicao/edicao-view.html',
					resolve : {
	    				load : function($ocLazyLoad) {
	    					return $ocLazyLoad.load({
	    						name : 'js',
	    						files : [
	    							'app/edicao/edicao-controller.js',
	    							'app/edicao/edicao-service.js'
    							]
	    					});
	    				}
	    			}
				}
			}
		})

	});

})()