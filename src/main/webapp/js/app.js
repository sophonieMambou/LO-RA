
	var app =angular.module('LORA',['ngRoute','especeMod','compositionMod','ngResource']);
	app.config(function($routeProvider) {

	  $routeProvider
	  .when('/help', {
	        templateUrl: 'partials/help.html',
	      	controller:'Controller'
	      })
	      .otherwise({redirectTo: '/help'});
	});