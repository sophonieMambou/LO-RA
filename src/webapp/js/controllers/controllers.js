
app.controller('Controller', ['$scope','$location',function($scope,$location) {
         $scope.help ="That is initial step ;please we are working it now, thank ...";
         
         //update different pages ...
         $scope.actualisation = function () {
          	 $scope.tab = 1;
         	 $location.path('/clients/');
          };
         $scope.actualisation();

          $scope.isSet = function(checkTab) {
            return $scope.tab === checkTab;
          };
          
          $scope.setTab = function(activeTab) {
            $scope.tab = activeTab;
          };
            $scope.onclickCustomer = function () {
            	$scope.setTab(1)
                $location.path('/clients/');
          };
           $scope.onclickAccount = function () {
           	    $scope.setTab(2)
                $location.path('/comptes/');
          };

      }]);


