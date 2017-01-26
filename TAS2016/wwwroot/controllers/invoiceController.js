//(function()
// {
//    app.controller('InvoiceController', function(/*$scope,invoiceFactory*/)
//    { 
//        this.invoices /* = invoices*/ = {};
////        this.id = invoiceFactory.getId();
//        
//    });
//    
//    var invoices = [
//        {
//            id: 1,
//            platnik: "Paweł Kukiz" , 
//            wystawiajacy: "Jarosław Kaczyński", 
//            dataWystawienia:"12.09.15"
//        },
//        { id: 2, 
//            platnik: "Paweł2 Kukiz" , 
//            wystawiajacy: "Jarosław2 Kaczyński", 
//            dataWystawienia:"22.09.15"}];
//            
//        
//})();
//////////////////////////////////////
//var app = angular.module('myApp', []);
app.controller('InvoiceController', function($scope, $http) {
    $http.get("../../resources/invoices.json")
    .then(function(response) {
        //First function handles success
        $scope.myWelcome = response.data;
    }, function(response) {
        //Second function handles error
        $scope.myWelcome = "Something went wrong";
    });
});
//(function () {
//    'use strict';
//
//    var controllerId = 'InvoiceController';
//
//    angular.module('app').controller(controllerId,
//        ['$scope', 'invoiceFactory', InvoiceController]);
//
//    function InvoiceController($scope, invoiceFactory) {
//        $scope.invoices = [];
//
//        invoiceFactory.getInvoice().success(function (data) {
//            $scope.invoices = data;
//        }).error(function (error) {
//            // log errors
//        });
//    }
//})();