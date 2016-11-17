'use strict';
var alimentationsApp = angular.module('alimentationMod', ['ngRoute', 'ui.bootstrap']);
alimentationsApp.config(function ($routeProvider) {

    $routeProvider.
            when('/alimentation/', {
                templateUrl: 'modules/alimentation/views/alimentation.html',
                controller: 'alimentationsController'
            })
            ;
});