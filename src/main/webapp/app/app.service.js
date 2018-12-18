/**
 *
 */

(function() {

	'use strict'

	angular.module("app.service", []);
	angular.module("app.service").factory("mensagemService", mensagemService);
		function mensagemService() {

		return {
			exibirMensagemSimples: exibirMensagemSimples,
			exibirMensagensSimples: exibirMensagensSimples,
			exibirMensagemConfirmar: exibirMensagemConfirmar
		}

		function exibirMensagemSimples(tipo, titulo, mensagem) {

			const toast = swal.mixin({
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				timer: 5000
			});

			toast({
				title: titulo,
				text: mensagem,
				type: tipo
			});
		};// exibirMensagemSimples()

		function exibirMensagensSimples(mensagem) {

			const toast = swal.mixin({
				toast: true,
				position: 'top',
				showConfirmButton: false,
				timer: 5000
			});

			var tipo = mensagem.tipo;
			var titulo = "Erro";
			if (tipo === 'error') {
				titulo = "Erro";
			} else if (tipo === 'warning') {
				titulo = "Alerta";
			} else if (tipo === 'info') {
				titulo = "Aviso";
			} else if (tipo === 'success') {
				titulo = "Sucesso";
			} else if (tipo === 'question') {
				titulo = "Confirmação";
			}// if-else

			var html = "";
			var html = mensagem.texto + "<br/>";

			toast({
				title: titulo,
				type: tipo,
				html: html
			});

		};// exibirMensagemSimples()

		function exibirMensagemConfirmar(tipo, titulo, mensagem, funcaoConfirmar, funcaoCancelar) {

			const toast = swal.mixin({
				toast: true,
				position: 'top',
				showConfirmButton: true,
				showCancelButton: true
			});

			Swal({
				  title: titulo,
				  text: mensagem,
				  type: tipo,
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Sim',
				  cancelButtonText: 'Não',
				  confirmButtonClass: 'btn btn-success btn-sm',
				  cancelButtonClass: 'btn btn-danger btn-sm',
				  buttonsStyling: false
			}).then((result) => {
				if (result.value) {
					funcaoConfirmar();
				} else {
					funcaoCancelar();
				}
			});

		}// exibirMensagemConfirmar()

	};// exibirMensagensSimples()

})();