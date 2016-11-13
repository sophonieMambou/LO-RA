
'use strict';
var especesApp=angular.module('especeMod',['ngRoute','ui.bootstrap']);
	especesApp.config(function($routeProvider) {

	  $routeProvider.
	      when('/especes/', {
	        templateUrl: 'modules/especes/views/especes.html',
	        controller: 'especesController'
	      })
	      ;
	});