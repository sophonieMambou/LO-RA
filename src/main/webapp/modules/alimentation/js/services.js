'use strict';

alimentationsApp.factory('AlimentationService', ['$http', '$q', '$location', function ($http, $q, $location) {

        return {
            findAllEspeces: function () {
                return $http.get('especes/')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    return $q.reject(errResponse);
                                }
                        );
            },
            findAllEngredients: function () {
                return $http.get('engredients/')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };

    }]);