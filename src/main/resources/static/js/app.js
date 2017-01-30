var app = angular.module('myApp', ['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when('/Questionnaires', {
		controller:'myCtrl', 
		templateUrl:'/view/questionnaires.html'
	})
	.when('/CreateQuestionnaire', {
		controller:'myCtrl', 
		templateUrl:'/view/createQuestionnaire.html'
	})
	.otherwise({
		redirectTo:'/'
	});
});