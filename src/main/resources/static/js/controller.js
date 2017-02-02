app.controller('myCtrl', ['$scope', 'QuestionnaireService', function($scope, QuestionnaireService) {
	var self = this;
	self.questionnaires = [];
	fetchAllQuestionnaires();

	function fetchAllQuestionnaires(){
		QuestionnaireService.getAllQuestionnaire()
				.then(
						function(d) {
							self.questionnaires = d;
							$scope.questionnaires = self.questionnaires;
						},
						function(errResponse){
							console.error('Error while fetching questionnaires');
						}
				);
	}
}]);