(function()
 {
    
    app.controller('NavController', function(){ this.tabs = navTabs; });
    
     var navTabs = [
        { name: 'Main Data',
            subName: ['Klienci','Dostawcy','Materiały']},
        { name: 'Magazyn'}, 
        { name: 'Zlecenia',
            subName: ['Dodaj zlecenie']}, 
        { name: 'Faktury',
            subName: ['Dodaj fakturę']}, 
        { name: 'Rabaty',
             subName: ['Rabat czasowy','Rabat na klienta','Rabat na materiał']}, 
        { name: 'Użytkownik'}, 
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
    .when("/Magazyn", {
        templateUrl : "../warehouse.html"
    })
    .when("/Zlecenia", {
        templateUrl : "../orders.html"
    })
    .when("/Zlecenia/Dodaj zlecenie", {
        templateUrl : "../ordersDodaj.html"
    })
    .when("/Faktury", {
        templateUrl : "../invoices.html"
    })
    .when("/Faktury/Dodaj fakturę", {
        templateUrl : "../invoicesDodaj.html"
    })
    .when("/Rabaty", {
        templateUrl : "../manage.html"
    })
    .when("/Rabaty/Rabat czasowy", {
        templateUrl : "../discount.html"
    })
    .when("/Rabaty/Rabat na klienta", {
        templateUrl : "../clientDiscount.html"
    })
    .when("/Rabaty/Rabat na materiał", {
        templateUrl : "../materialDiscount.html"
    })
    .when("/Użytkownik", {
        templateUrl : "../user.html"
    })
//    .when("/Settings",{
//        templateUrl : "../settings.html"
//    })
});
    
    
})();