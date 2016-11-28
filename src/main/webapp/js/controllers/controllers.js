
app.controller('Controller', ['$scope', '$location', function ($scope, $location) {
        $scope.help = "That is initial step ;please we are working it now, thank ...";

        $scope.isSet = function (checkTab) {
            return $scope.tab === checkTab;
        };

        $scope.setTab = function (activeTab) {
            $scope.tab = activeTab;
        };
        $scope.onclickHomepage = function () {
            $scope.setTab(1)
            $location.path('/homepage/');
        };
        $scope.onclickEspeces = function () {
            $scope.setTab(2)
            $location.path('/especes/');
        };
        $scope.onclickEngredients = function () {
            $scope.setTab(3)
            $location.path('/engredients/');
        };
        $scope.onclickComposition = function () {
            $scope.setTab(4)
            $location.path('/composition/');
        };
        $scope.onclickAlimentation = function () {
            $scope.setTab(5)
            $location.path('/alimentation/');
        };
        $scope.onclickContact = function () {
            $scope.setTab(6)
            $location.path('/besoinAlimentaire/');
        };


    }]);


