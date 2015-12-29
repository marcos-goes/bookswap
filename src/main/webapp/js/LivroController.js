angular
	.module('LivrosApp')
	.controller('LivroController',['$http', 'LivroService', function($http, LivroService){
		var self = this;
		self.items = [];
		LivroService.listaTodos.then(function(response){
			self.items = response.data;
		}, function(errResponse){
			console.error('Error while fetching books...');
		});
	}]);
	