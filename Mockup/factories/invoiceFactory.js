//(function () {
//    'use strict';
//
//    var serviceId = 'invoiceFactory';
//
//    angular.module('app').factory(serviceId,
//        ['$http', invoiceFactory]);
//
//    function personFactory($http) {
//
//        function getInvoice() {
//            return $http.get('../resources/invoices.json');
//        }
//
//        var service = {
//            getInvoice: getInvoice
//        };
//
//        return service;
//    }
//})();
//
//console.log("ZAŁĄCZONE INVOICE FACTORY");