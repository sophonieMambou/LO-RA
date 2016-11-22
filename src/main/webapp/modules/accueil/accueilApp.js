
'use strict';
var especesApp=angular.module('especeMod',['ngRoute','ui.bootstrap']);
	especesApp.config(function($routeProvider) {

	  $routeProvider.
	      when('/homepage/', {
	        templateUrl: 'modules/accueil/views/accueil.html',
	        controller: 'accueilController'
	      })
	      ;
	});