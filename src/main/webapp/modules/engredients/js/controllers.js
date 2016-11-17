'use strict';

engredientsApp.controller('engredientsController', ['$scope', '$modal', '$location', 'EngredientsService', '$log', function ($scope, $modal, $location, EngredientsService, $log) {

        var self = $scope;

        self.engredient = {id: null, nom: '', prix: '', type_aliment: '', composition: null};

        self.engredients = [];

        self.compositon = [];
         
        $scope.percent = 15;
        
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

  
        self.findAllEngredients = function () {
            self.compositon = [];
            EngredientsService.findAllEngredients().then(
                    function (d) {
                        self.engredients = d;
                        for (var i = 0; i < self.engredients.length; i++) {
                            EngredientsService.findByEngredient(self.engredients[i].id).then(
                                    function (d) {
                                        self.compositon.push(d);
                                    },
                                    function (errResponse) {
                                       // console.log(errResponse);
                                    }
                            );
                        }
                    },
                    function (errResponse) {
                    }
            );
        };
        self.findAllComposition = function () {
            EngredientsService.findAllComposition().then(
                    function (d) {
                        self.compostion = d;
                    },
                    function (errResponse) {
                    }
            );
        };
        self.findAllEngredients();
    }]);
