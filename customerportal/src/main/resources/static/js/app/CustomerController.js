'use strict'

var module = angular.module('demo.controllers', []);
module.controller("CustomerController", [ "$scope", "CustomerService",
		function($scope, CustomerService) {
	
			$scope.customerSearchDto = {
				fromDate : null,
				toDate : null
			};
			
			$scope.searchCustomerJobs = function() {
				
					CustomerService.searchCustomerJobs($scope.customerSearchDto).then(function(value) {
						$scope.allCustomerJobs = value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.customerSearchDto = {
						customerName : null,
						fromDate : null,
						toDate : null
					};
				}
		} ]);