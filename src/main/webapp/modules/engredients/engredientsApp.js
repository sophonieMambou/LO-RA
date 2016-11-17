
'use strict';
var engredientsApp=angular.module('engredientsMod',['ngRoute','ui.bootstrap']);
	engredientsApp.config(function($routeProvider) {

	  $routeProvider.
	      when('/engredients/', {
	        templateUrl: 'modules/engredients/views/engredients.html',
	        controller: 'engredientsController'
	      })
	      ;
	});