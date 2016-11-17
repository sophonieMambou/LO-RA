'use strict';

compositionsApp.factory('CompositionService', ['$http', '$q', '$location', function ($http, $q, $location) {

        return {
            createEngredient: function (engredient) {
                return $http.post('engredients/', engredient)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating engredient, service');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createValeurs: function (valeur) {
                return $http.post('valeursenergetiques/', valeur)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating valeur, service');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createComposition: function (composition) {
                return $http.post('composition/', composition)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating composition, service');
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };

    }]);