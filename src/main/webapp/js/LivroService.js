angular
	.module('LivrosApp')
	.factory('LivroService',['$http',function($http){
		return {
			listaTodos: function(){
				return $http.get('api/book');
			}
		};
	}]);