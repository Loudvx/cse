app.controller('myCtrl', ['$scope', 'QuestionnaireService', '$routeParams', function($scope,  QuestionnaireService, $routeParams) {
	var self = this;
	self.questionnaires = [];
	self.thisQuestionnaire = [];
	self.creationQuestionnaire = [];
	$scope.questionnaires = [];
	$scope.thisQuestionnaire = [];
	$scope.creationQuestionnaire = {
		nom_questionnaire: "Inserer le texte ici",
		questions: [],
		date_debut: "Inserer le texte ici",
		date_fin: "Inserer le texte ici",
		entreprise: "Inserer le texte ici"
	};


	if($routeParams.id != null) {
		getOneQuestionnaire($routeParams.id);
	} else {
		fetchAllQuestionnaires();
	}

	function formatDate(value){
		if(value){
			Number.prototype.padLeft = function(base,chr){
				var len = (String(base || 10).length - String(this).length)+1;
				return len > 0? new Array(len).join(chr || '0')+this : this;
			};
			var d = new Date(value),
					dformat = [ (d.getMonth()+1).padLeft(),
								d.getDate().padLeft(),
								d.getFullYear()].join('/')+
							' ' +
							[ d.getHours().padLeft(),
								d.getMinutes().padLeft(),
								d.getSeconds().padLeft()].join(':');
			return dformat;
		}
	}

	function fetchAllQuestionnaires(){
		QuestionnaireService.getAllQuestionnaire()
				.then(
						function(d) {
							self.questionnaires = d;
							var cpt;
							for(cpt=0;cpt<self.questionnaires.length;cpt++) {
								self.questionnaires[cpt].questionnaire.date_debut = formatDate(self.questionnaires[cpt].questionnaire.date_debut);
								self.questionnaires[cpt].questionnaire.date_fin = formatDate(self.questionnaires[cpt].questionnaire.date_fin);
							}
							$scope.questionnaires = self.questionnaires;
						},
						function(errResponse){
							console.error('Error while fetching questionnaires');
						}
				);
	}

	function getOneQuestionnaire(id) {
		QuestionnaireService.getOneQuestionnaire(id)
				.then(
						function(d) {
							self.questionnaire = d;
							$scope.thisQuestionnaire = self.questionnaire;
						},
						function(errResponse){
							console.error('Error while getting one questionnaire');
						}
				)
	}

	$scope.addQuestion = function addQuestion() {
		var question = {intitule: "Inserer le texte ici"};
		$scope.creationQuestionnaire.questions.push(question);
	}

	$scope.saveQuestionnaire = function saveQuestionnaire() {
		QuestionnaireService.createQuestionnaire($scope.creationQuestionnaire);
	}


}]);

