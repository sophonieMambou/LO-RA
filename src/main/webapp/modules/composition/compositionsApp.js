
'use strict';
var compositionsApp = angular.module('compositionMod', ['ngRoute', 'ui.bootstrap']);
compositionsApp.config(function ($routeProvider) {

    $routeProvider.
            when('/composition/', {
                templateUrl: 'modules/composition/views/composition.html',
                controller: 'compositionsController'
            })
            ;
});