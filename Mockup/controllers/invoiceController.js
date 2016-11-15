(function()
 {
    app.controller('InvoiceController', function(){ 
        this.invoices = invoices});
    
    var invoices = [
        {
            id: 1, 
            platnik: "Paweł Kukiz" , 
            wystawiajacy: "Jarosław Kaczyński", 
            dataWystawienia:"12.09.15"
        },
        { id: 2, 
            platnik: "Paweł2 Kukiz" , 
            wystawiajacy: "Jarosław2 Kaczyński", 
            dataWystawienia:"22.09.15"}];

})();