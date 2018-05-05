'use strict'

angular.module('demo.services', []).factory('CustomerService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			
			var service = {};
			
			service.getCustomerById = function(customerId) {
				var url = CONSTANTS.getCustomerByIdUrl + customerId;
				return $http.get(url);
			}
			
			service.getAllCustomers = function() {
				return $http.get(CONSTANTS.getAllCustomers);
			}
			
			service.searchCustomerJobs = function(searchParams) {
		        var requestUrl = CONSTANTS.searchCustomerJobs;
		        
		        var i=0;
		        angular.forEach(searchParams, function(value, key){
		        if(i==0){   
		            requestUrl = requestUrl + '?' + key + '=' + value;
		        }else{
		            requestUrl = requestUrl + '&' + key + '=' + value;}
		            i++;
		        });
		        
				return $http.get(requestUrl);
			}
			
			return service;
			
		} ]);