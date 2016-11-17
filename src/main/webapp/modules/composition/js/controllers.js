'use strict';

compositionsApp.controller('compositionsController', ['$scope', '$modal', '$location', 'CompositionService', '$log', function ($scope, $modal, $location, CompositionService, $log) {

        var self = $scope;

        self.engredient = {id: null, nom: '', prix: '', type_aliment: ''};

        $scope.valeurs = [
            {id: null, code: 'MS', nom: 'matiere seche', valeur: ''},
            {id: null, code: 'EM', nom: 'energie metabolisable', valeur: ''},
            {id: null, code: 'CB', nom: 'cellulose brute', valeur: ''},
            {id: null, code: 'PB', nom: 'proteine brute', valeur: ''},
            {id: null, code: 'Ca', nom: 'calcium', valeur: ''},
            {id: null, code: 'P', nom: 'phosphore', valeur: ''},
            {id: null, code: 'NaCl', nom: 'sel', valeur: ''},
            {id: null, code: 'Ly', nom: 'lysine', valeur: ''},
            {id: null, code: 'Met_Cy', nom: 'methionine cystine', valeur: ''},
            {id: null, code: 'Cy', nom: 'cystine', valeur: ''},
            {id: null, code: 'UF', nom: 'UF', valeur: ''},
            {id: null, code: 'MAD', nom: 'MAD', valeur: ''}
        ];

        $scope.composition = {id: null, valMin: '', valMax: '', engredient: '', valeurs: ''};

        $scope.enregistrer = function (engredient, valeurs) {
            CompositionService.createEngredient(engredient).then(
                    function (donnees) {
                        self.engredient = donnees;
                        for (var i = 0; i < self.valeurs.length; i++) {
                            CompositionService.createValeurs(valeurs[i]).then(
                                    function (donnee) {
                                        $scope.valeurs[i] = donnee;
                                        self.composition.engredients = donnees;
                                        self.composition.valeursEnergetiques = donnee;
                                        CompositionService.createComposition(self.composition).then(
                                                function (donnee) {
                                                   // console.log(donnee);
                                                }
                                        );
                                    }
                            );
                        }
                    }
            );
        };

    }]);