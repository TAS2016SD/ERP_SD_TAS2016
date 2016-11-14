///**
// * @author 
// * @since 11/9/2016
// */
//(function () {
//    'use strict';
//
//    angular
//        .module('app')
//        .controller('InvoicesController', InvoicesController);
//
//    /* @ngInject */
//    function InvoicesController ($log) {
//        var vm = this;
//        vm.class = 'InvoicesController';
//
//        activate();
//
//        //////////////
//
//        function activate() {
//            $log.debug('Activating ' + vm.class);
//            
//            var fields = ["Id", "Płatnik", "Wystawiający", "DataWystawienia"];
//        }
//    }
//})();
//console.log('app.js file is loaded');


//var app = angular.module('app',[]);
//
//app.controller = ('NavController', function(){
// this.name = nav;
//});
//
//var navTab = 
//    {
//        name: ['Main datas', 'Warehouse', 'Jobs', 'Invoices', 'Manage', 'User', 'Settings']
//    }
//

////(function(){
//var app = angular.module('app', [ ]);
//app.controller('NavController', function($scope){ 
//$scope.navTabs = [
//    { name: 'Main datas'},
//    { name: 'Warehouse'}, 
//    { name: 'Jobs'}, 
//    { name: 'Invoices'}, 
//    { name: 'Manage'}, 
//    { name: 'User'}, 
//    { name: 'Settings'}
//]
//});
////})();


(function()
 {
    var app = angular.module('app', ["ngRoute"]);
    
    app.controller('InvoiceController', function(){ 
//      this.invoice = invoices;
        this.fields = fields;                                             });
    
    var fields = [
        {Name: "Id"}, 
         {Name: "Płatnik"}, 
         {Name: "Wystawiający"}, 
         {Name: "DataWystawienia"}
    ];

});
    
    
})();