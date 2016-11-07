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
    
    app.controller('NavController', function(){ this.tabs = navTabs; });
    
    var navTabs = [
        { name: 'Maindatas'},
        { name: 'Warehouse'}, 
        { name: 'Jobs'}, 
        { name: 'Invoices'}, 
        { name: 'Manage'}, 
        { name: 'User'}, 
        { name: 'Settings'}];
    
    app.config(function($routeProvider) {
    $routeProvider
    .when("/Maindatas", {
        templateUrl : "mainData.html"
    })
    .when("/Warehouse", {
        templateUrl : "warehouse.html"
    })
    .when("/Jobs", {
        templateUrl : "jobs.html"
    })
    .when("/Invoices", {
        templateUrl : "invoices.html"
    })
    .when("/Manage", {
        templateUrl : "manage.html"
    })
    .when("/User", {
        templateUrl : "user.html"
    })
    .when("/Settings",{
        templateUrl : "settings.html"
    })
});
    
    
})();