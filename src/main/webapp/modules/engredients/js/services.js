'use strict';
engredientsApp.factory('EngredientsService', ['$http', '$q', '$location', function ($http, $q, $location) {

        return {
            
            findByEngredient: function (id) {
                return $http.get('composition/cmp/'+id)
                        .then(
                                function (response) {
                                    console.log(response.data);
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
                                    // response.data = response.data.Replace(":","");
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