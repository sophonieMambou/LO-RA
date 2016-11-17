
var app = angular.module('LORA', ['ngRoute', 'alimentationMod', 'especeMod', 'compositionMod', 'engredientsMod', 'ngResource']);
app.config(function ($routeProvider) {

    $routeProvider
            .when('/help', {
                templateUrl: 'partials/help.html',
                controller: 'Controller'
            })
            .otherwise({redirectTo: ''});
});