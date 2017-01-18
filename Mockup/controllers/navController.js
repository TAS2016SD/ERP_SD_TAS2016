(function()
 {
    
    app.controller('NavController', function(){ this.tabs = navTabs; });
    
    var navTabs = [
        { name: 'Main Data',
            subName: ['Klienci','Dostawcy','Materiały']},
        { name: 'Warehouse'}, 
        { name: 'Orders',
            subName: ['Dodaj']}, 
        { name: 'Invoices',
            subName: ['Dodaj']}, 
        { name: 'Manage'}, 
        { name: 'User'}, 
//        { name: 'Settings'}
    ];
    
    app.config(function($routeProvider) {
    $routeProvider
    .when("/Main Data", {
        templateUrl : "../mainData.html"
    })
    .when("/Main Data/Klienci", {
        templateUrl : "../mainDataKlient.html"
    })
    .when("/Warehouse", {
        templateUrl : "../warehouse.html"
    })
    .when("/Orders", {
        templateUrl : "../orders.html"
    })
    .when("/Orders/Dodaj", {
        templateUrl : "../ordersDodaj.html"
    })
    .when("/Invoices", {
        templateUrl : "../invoices.html"
    })
    .when("/Invoices/Dodaj", {
        templateUrl : "../invoicesDodaj.html"
    })
    .when("/Manage", {
        templateUrl : "../manage.html"
    })
    .when("/User", {
        templateUrl : "../user.html"
    })
//    .when("/Settings",{
//        templateUrl : "../settings.html"
//    })
});
    
    
})();