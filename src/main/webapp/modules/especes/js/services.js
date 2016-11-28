
'use strict';

especesApp.factory('Espece', ['$http', '$q', '$location', function ($http, $q, $location) {

        return {
            findAllEspeces: function () {
                return $http.get('especes/')//(/api)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching especes');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            createEspeces: function (espece) {
                return $http.post('especes/', espece)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                //$location.path('/especes/'),
                                        function (errResponse) {
                                            console.error('Error while creating espece');
                                            return $q.reject(errResponse);
                                        }
                                );
                            },
                    updateEspece: function (id, espece) {
                        return $http.put('especes/' + id, espece)
                                .then(
                                        function (response) {
                                            return response.data;
                                        },
                                        function (errResponse) {
                                            console.error('Error while updating espece', id);
                                            return $q.reject(errResponse);
                                        }
                                );
                    },
                    deleteEspece: function (id) {
                        return $http.delete('especes/' + id)
                                .then(
                                        function (response) {
                                            return response.data;
                                        },
                                        function (errResponse) {
                                            console.error('Error while deleting espece');
                                            return $q.reject(errResponse);
                                        }
                                );
                    }

                };

            }]);