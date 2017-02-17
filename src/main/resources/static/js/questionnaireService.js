'use strict';

app.factory('QuestionnaireService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://sample-env-3.yvqfw6pgnj.us-west-2.elasticbeanstalk.com/questionnaire/';

    var factory = {
        getAllQuestionnaire: getAllQuestionnaire,
        getOneQuestionnaire: getOneQuestionnaire,
        createQuestionnaire: createQuestionnaire,
        updateQuestionnaire: updateQuestionnaire,
        deleteQuestionnaire: deleteQuestionnaire
    };

    return factory;

    function getAllQuestionnaire() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
                .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function(errResponse){
                            console.error('Error while fetching questionnaires');
                            deferred.reject(errResponse);
                        }
                );
        return deferred.promise;
    }

    function getOneQuestionnaire(id) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+id)
                .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function(errResponse){
                            console.error('Error while fetching one questionnaire');
                            deferred.reject(errResponse);
                        }
                );
        return deferred.promise;
    }

    function createQuestionnaire(questionnaire) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, questionnaire)
                .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function(errResponse){
                            console.error('Error while creating questionnaire');
                            deferred.reject(errResponse);
                        }
                );
        return deferred.promise;
    }


    function updateQuestionnaire(questionnaire, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, questionnaire)
                .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function(errResponse){
                            console.error('Error while updating questionnaire');
                            deferred.reject(errResponse);
                        }
                );
        return deferred.promise;
    }

    function deleteQuestionnaire(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
                .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function(errResponse){
                            console.error('Error while deleting questionnaire');
                            deferred.reject(errResponse);
                        }
                );
        return deferred.promise;
    }

}]);