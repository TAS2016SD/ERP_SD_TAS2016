(function()
 {
    
    app.controller('NavController', function(){ this.tabs = navTabs; });
    
     var navTabs = [
        { name: 'Dane podstawowe',
            subName: ['Klienci','Dostawcy','Materiały']},
        { name: 'Magazyn',
           subName: ['Dodaj pozycję']}, 
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
    .when("/Dane podstawowe", {
        templateUrl : "../mainData.html"
    })
    .when("/Dane podstawowe/Klienci", {
        templateUrl : "../mainDataKlient.html"
    })
    .when("/Dane podstawowe/Dostawcy", {
        templateUrl : "../mainDataDostawca.html"
    })
    .when("/Dane podstawowe/Materiały", {
        templateUrl : "../mainDataMaterial.html"
    })
    .when("/Magazyn", {
        templateUrl : "../warehouse.html"
    })
    .when("/Magazyn/Dodaj pozycję", {
        templateUrl : "../warehouseDodaj.html"
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
    .when("/Użytkownik/Edytuj", {
        templateUrl : "../userEdytuj.html"
    })
//    .when("/Settings",{
//        templateUrl : "../settings.html"
//    })
});
    
    
})();