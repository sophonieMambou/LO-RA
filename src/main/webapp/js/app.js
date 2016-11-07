
	var app =angular.module('lora',['ngRoute','ngResource']);
	app.config(function($routeProvider) {

	  $routeProvider
	  .when('/help', {
	        templateUrl: 'partials/help.html',
	      	controller:'Controller'
	      })
	      .otherwise({redirectTo: '/help'});
	});