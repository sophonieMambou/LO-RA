
'use strict';
var rationsApp=angular.module('rationMod',['ngRoute','ui.bootstrap']);
	rationsApp.config(function($routeProvider) {

	  $routeProvider.
	      when('/besoinAlimentaire/', {
	        templateUrl: 'modules/ration/views/ration.html',
	        controller: 'rationsController'
	      })
	      ;
	});