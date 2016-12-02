'use strict';
alimentationsApp.controller('alimentationsController', ['$scope', '$modal', '$location', 'AlimentationService', '$log', function ($scope, $modal, $location, AlimentationService, $log) {

        var self = $scope;
        $scope.valeurs = [
            {code: 'EM', val: 0, ratio: 0},
            {code: 'CB', val: 0, ratio: 0},
            {code: 'PB', val: 0, ratio: 0},
            {code: 'Ca', val: 0, ratio: 0},
            {code: 'P', val: 0, ratio: 0},
            {code: 'NaCl', val: 0, ratio: 0},
            {code: 'Ly', val: 0, ratio: 0},
            {code: 'Met', val: 0, ratio: 0},
            {code: 'Met_Cy', val: 0, ratio: 0},
            {code: 'Cy', val: 0, ratio: 0},
            {code: 'UF', val: 0, ratio: 0},
            {code: 'MAD', val: 0, ratio: 0},
            {code: 'prix', val: 0, ratio: 0}];
        $scope.selection = [];
        self.composition = [];
        self.engredients = [];
        self.especes = [];
        this.ival = 0;
        this.val = 0;
        this.espece_id = null;
        this.besoin_id = null;
        $scope.listeBesoin = [];
        $scope.listeRation = [];
        $scope.percent = [];
        self.total = 0;
        self.sum = 0;
        $scope.bilan = [];
        self.besoins = [];



        self.findAllEngredients = function () {
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

        self.Total = function () {
            self.total = 0;

            for (var i = 0; i < $scope.percent.length; i++) {
                if ($scope.percent[i])
                    self.total = self.total + $scope.percent[i];
            }
            if (self.total == 100) {
                self.calculer();
            }
        };

        self.besoinAlimentaire = function () {
            AlimentationService.findByEspece(this.espece_id).then(
                    function (d) {
                        $scope.listeBesoin = d;
                    },
                    function (errResponse) {
                    }
            );
        };

        self.ration = function () {
            AlimentationService.findByBesoin(this.besoin_id).then(
                    function (d) {
                        $scope.listeRation = d;
                        self.Bilan();
                    },
                    function (errResponse) {
                    }
            );
        };

        self.Bilan = function () {
            var cal = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
            for (var i = 0; i < $scope.selection.length; i++) {
                for (var k = 0; k < self.bilan[i].length; k++) {
                    if (self.bilan[i][k])
                        cal[k] = cal[k] + self.bilan[i][k].val;
                    else
                        cal[k] = 0;
                }
            }
            for (var k = 0; k < $scope.valeurs.length; k++) {
                $scope.valeurs[k].val = cal[k];
                for (var j = 0; j < $scope.listeRation.length; j++)
                    if ($scope.valeurs[k].code == $scope.listeRation[j].valeursEnergetiques.code) {
                        if ($scope.listeRation[j].valeursEnergetiques.valeur && cal[k] != 0 && 
                                $scope.listeRation[j].valeursEnergetiques.valeur != 0)
                            $scope.valeurs[k].ratio = cal[k] / $scope.listeRation[j].valeursEnergetiques.valeur;
                        else
                            $scope.valeurs[k].ratio = 0;
                        break;
                    }
            }
            $scope.valeurs[12].ratio = cal[12]*50;
        };

//        $scope.calculer = function () {
//            $scope.bilan = [];
//            $scope.composition = [];
//            $log.log("La longueur "+self.selection.length);
//            for (var i = 0; i < self.selection.length; i++) {
//                AlimentationService.findByEngredient(self.selection[i].id).success(function(data){
//                    $scope.composition.push(data);
//                });
//            }
//            //console.log($scope.composition);
//        };

        self.calculer = function () {
            self.bilan = [];
            self.composition = [];
            for (var k = 0; k < self.selection.length; k++) {
                self.bilan.push([]);
            }
            var cpt = 0;
            for (var i = 0; i < self.selection.length; i++) {
                AlimentationService.findByEngredient(self.selection[i].id).then(
                        function (d) {

                            var tmp = [{code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0},
                                {code: '', val: 0}];
                            var MS = 1;
                            for (var j = 0; j < d.length; j++) {
                                if (d[j].valeursEnergetiques.code == "MS") {
                                    MS = d[j].valeursEnergetiques.valeur;
                                    break;
                                }
                            }

                            var find = 0;
                            for (var k = 0; k < self.selection.length; k++) {
                                if (d[0].engredients.nom == self.selection[k].nom) {
                                    find = k;
                                    tmp[12].val = (d[0].engredients.prix* $scope.percent[find] * MS) / 100;
                                    break;
                                }
                            }

                            for (var k = 0; k < $scope.valeurs.length; k++) {
                                for (var j = 0; j < d.length; j++) {
                                    if ($scope.valeurs[k].code == d[j].valeursEnergetiques.code
                                            && d[j].engredients.nom == self.selection[find].nom) {
                                        tmp[k].val = (d[j].valeursEnergetiques.valeur * $scope.percent[find] * MS) / 100;
                                        tmp[k].code = d[j].engredients.nom;
                                        break;
                                    }
                                }
                            }
                            self.bilan[find] = tmp;
                            self.Bilan();
                        },
                        function (errResponse) {
                        }
                );
            }

        };

        self.findAllEngredients();
        self.findAllEspeces();

        $scope.toggleSelection = function toggleSelection(engr) {
            var idx = $scope.selection.indexOf(engr);
            if (idx > -1) {
                $scope.selection.splice(idx, 1);
                $scope.percent.splice(idx, 1);
                self.Total();
            }
            else {
                $scope.selection.push(engr);
                $scope.percent.push(this.ival);
            }
        };

    }]);