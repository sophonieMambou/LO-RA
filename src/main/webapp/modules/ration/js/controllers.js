'use strict';
rationsApp.controller('rationsController', ['$scope', '$modal', '$location', 'RationServices', '$log', function ($scope, $modal, $location, RationServices, $log) {

        var self = $scope;
        self.especes = [];
        this.especeChoisie = null;
        self.besoin = {id: null, nom: '', especes_id: ''};
        $scope.ration = {id: null, date: '', besoin: '', valeur: ''};

        $scope.valeurs = [
            {id: null, code: 'EM', nom: 'energie metabolisable', valeur: ''},
            {id: null, code: 'CB', nom: 'cellulose brute', valeur: ''},
            {id: null, code: 'PB', nom: 'proteine brute', valeur: ''},
            {id: null, code: 'Ca', nom: 'calcium', valeur: ''},
            {id: null, code: 'P', nom: 'phosphore', valeur: ''},
            {id: null, code: 'NaCl', nom: 'sel', valeur: ''},
            {id: null, code: 'Ly', nom: 'lysine', valeur: ''},
            {id: null, code: 'Met', nom: 'Methionine', valeur: ''},
            {id: null, code: 'Met_Cy', nom: 'methionine cystine', valeur: ''},
            {id: null, code: 'Cy', nom: 'cystine', valeur: ''},
            {id: null, code: 'UF', nom: 'UF', valeur: ''},
            {id: null, code: 'MAD', nom: 'MAD', valeur: ''}
        ];
        self.findAllEspeces = function () {
            self.especes = [];
            RationServices.findAllEspeces().then(
                    function (d) {
                        self.especes = d;
                    },
                    function (errResponse) {
                    }
            );
        };
        self.enregistrer = function (besoin, valeurs) {
            RationServices.createBesoin(this.especeChoisie, self.besoin).then(
                    function (donnees) {
                        for (var i = 0; i < self.valeurs.length; i++) {
                            RationServices.createValeurs($scope.valeurs[i]).then(
                                    function (donnee) {
                                        RationServices.createRation(self.ration, donnees.id, donnee.id).then(
                                                function (donnee) {
                                                    //console.log(donnee);
                                                }
                                        );
                                    }
                            );
                        }
                    }
            );
        };
        self.findAllEspeces();
    }]);