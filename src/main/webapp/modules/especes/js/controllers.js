'use strict';
especesApp.controller('especesController', ['$scope', '$modal', '$location', 'Espece', '$log', function ($scope, $modal, $location, Espece, $log) {

        var self = $scope;
        self.espece = {id: null, nom: '', type: ''};

        self.especes = [];

        $scope.editEspece = function () {
            var modalInstance = $modal.open({
                templateUrl: 'modules/especes/views/editespece.html',
                controller: 'editEspeceCtrl',
                backdrop: 'static',
                resolve: {
                    espece: function () {
                        return $scope.espece;
                    }
                }
            });
            modalInstance.result.then(function (selectedItem) {
                $log.info('Save changes at: ' + new Date());
                self.updateEspece(selectedItem, selectedItem.id);
            }, function () {
                $log.info('Closed at: ' + new Date());
            })
        };

        self.createEspeces = function () {
            //create modal frame
            var modalInstance = $modal.open({
                templateUrl: 'modules/especes/views/newespece.html',
                controller: 'createEspeceCtrl',
                backdrop: 'static'
            });
            modalInstance.result.then(function (selectedItem) {
              //  $log.info('Save changes at: ' + new Date());
                self.createEspece(selectedItem);
                alert("enregistrement de "+selectedItem.nom+" réussi");
            }, function () {
              // $log.info('Closed at: ' + new Date());
            })
        };

        self.createEspece = function (espece) {

            console.log('espece', espece.nom);

            Espece.createEspeces(espece)
                    .then(
                            self.findAllEspeces,
                            function (errResponse) {
                                //console.error('Error while creating Espece.');
                            }
                    );
        };

        self.updateEspece = function (espece, id) {
            Espece.updateEspece(espece, id)
                    .then(
                            self.findAllEspeces,
                            //$location.path('/clients/'),
                                    function (errResponse) {
                                        console.error('Error while updating Espece.', id);
                                    }
                            );
                        };

                self.findAllEspeces = function () {
                    Espece.findAllEspeces()
                            .then(
                                    function (d) {
                                        self.especes = d;

                                    },
                                    function (errResponse) {
                                        console.error('Error while fetching Currencies');
                                    }
                            );
                };

                self.deleteEspece = function (id) {
                    console.log('id to be deleted', id);
                    var res = confirm("Are you sure to delete this Espece ?");
                    if (res === true) {
                        Espece.deleteEspece(id)
                                .then(
                                        self.findAllEspeces,
                                        $location.path('/especes/'),
                                        function (errResponse) {
                                            console.error('Error while deleting Especes.Oups');
                                        }
                                );
                    }
                };

                self.findAllEspeces();
                self.edit = function (id) {
                    console.log('id to be edited plus', id);
                    for (var i = 0; i < self.especes.length; i++) {
                        if (self.especes[i].id == id) {

                            self.espece = angular.copy(self.especes[i]);
                            $scope.editEspece();
                            break;
                        }
                    }
                };

            }]);

especesApp.controller('editEspeceCtrl', ['$scope', '$modalInstance', 'espece',
    function ($scope, $modalInstance, espece) {
        $scope.espece = espece;

        $scope.save = function () {
            $modalInstance.close(espece);
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }
]);

especesApp.controller('createEspeceCtrl', ['$scope', '$modalInstance',
    function ($scope, $modalInstance) {

        $scope.save = function (espece) {
            $modalInstance.close(espece);
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }
]);



