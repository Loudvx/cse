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
	.when('/Questionnaires/:id?', {
		controller:'myCtrl',
		templateUrl:'view/affichageQuestionnaire.html'
	})
	.otherwise({
		redirectTo:'/'
	});
});