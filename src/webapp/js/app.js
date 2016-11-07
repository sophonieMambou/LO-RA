
	var app =angular.module('banque',['ngRoute','clientMod','compteMod','ngResource']);
	app.config(function($routeProvider) {

	  $routeProvider
	  .when('/help', {
	        templateUrl: 'partials/help.html',
	      	controller:'Controller'
	      })
	      .otherwise({redirectTo: '/help'});
	});