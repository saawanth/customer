'use strict'

var demoApp = angular.module('demo', ['smart-table', 'ui.bootstrap', 'demo.controllers', 'demo.services' ]);

demoApp.constant("CONSTANTS", {	
	getCustomerByIdUrl : "/customers/",
	getAllCustomers : "/customers",
	saveCustomer : "/customers",
	searchCustomerJobs : "/customers/search"
});