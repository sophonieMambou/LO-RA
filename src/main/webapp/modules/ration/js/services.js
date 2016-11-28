
'use strict';

rationsApp.factory('RationServices', ['$http', '$q', '$location', function ($http, $q, $location) {

        return {
            createBesoin: function (id, besoin) {
                return $http.post('besoinAlimentaire/'+id, besoin).then(
                        function (response) {
                            return response.data;
                        },
                        function (errResponse) {
                            console.error('Error while creating besoin');
                            return $q.reject(errResponse);
                        }
                );
            },
            createValeurs: function (valeur) {
                return $http.post('valeursenergetiques/', valeur).then(
                        function (response) {
                            return response.data;
                        },
                        function (errResponse) {
                            console.error('Error while creating valeur, service');
                            return $q.reject(errResponse);
                        }
                );
            },
            createRation: function (ration, id, id2) {
                return $http.post('ration/'+id+'/'+id2, ration).then(
                        function (response) {
                            return response.data;
                        },
                        function (errResponse) {
                            console.error('Error while creating composition, service');
                            return $q.reject(errResponse);
                        }
                );
            },
            findAllEspeces: function () {
                return $http.get('especes/').then(
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