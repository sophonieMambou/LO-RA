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
            },
            findByEngredient: function (id) {
                return $http.get('composition/cmp/' + id)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    return $q.reject(errResponse);
                                }
                        );
            },
            findByEspece: function (id) {
                return $http.get('besoinAlimentaire/BA/' + id)
                        .then(
                                function (response) {
                                    //console.log(response.data);
                                    return response.data;
                                },
                                function (errResponse) {
                                    return $q.reject(errResponse);
                                }
                        );
            },
            findByBesoin: function (id) {
                return $http.get('ration/Ra/' + id)
                        .then(
                                function (response) {
                                    //console.log(response.data);
                                    return response.data;
                                },
                                function (errResponse) {
                                    return $q.reject(errResponse);
                                }
                        );
            },
            findAllComposition: function () {
                return $http.get('composition/')
                        .then(
                                function (response) {
//                                    console.log(response.data);
                                    return response.data;
                                },
                                function (errResponse) {
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };
    }]);