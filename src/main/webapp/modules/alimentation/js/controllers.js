'use strict';
alimentationsApp.controller('alimentationsController', ['$scope', '$modal', '$location', 'AlimentationService', '$log', function ($scope, $modal, $location, AlimentationService, $log) {

        var self = $scope;
        $scope.valeurs = [
            {code: 'MS'},
            {code: 'EM'},
            {code: 'CB'},
            {code: 'PB'},
            {code: 'Ca'},
            {code: 'P'},
            {code: 'NaCl'},
            {code: 'Ly'},
            {code: 'Met_Cy'},
            {code: 'Cy'},
            {code: 'UF'},
            {code: 'MAD'}];
        $scope.selection = [];
        self.engredients = [];
        self.especes = [];
        self.findAllEngredients = function () {
            self.compositon = [];
            AlimentationService.findAllEngredients().then(
                    function (d) {
                        self.engredients = d;
                    },
                    function (errResponse) {
                    }
            );
        };
        self.findAllEspeces = function () {
            self.especes = [];
            AlimentationService.findAllEspeces().then(
                    function (d) {
                        self.especes = d;
                    },
                    function (errResponse) {
                    }
            );
        };
        self.findAllEngredients();
        self.findAllEspeces();
        $scope.toggleSelection = function toggleSelection(engr) {
            var idx = $scope.selection.indexOf(engr);
            if (idx > -1) {
                $scope.selection.splice(idx, 1);
            }
            else {
                $scope.selection.push(engr);
            }
        };
        
    }]);