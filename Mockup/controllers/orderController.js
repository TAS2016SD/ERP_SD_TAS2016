app.controller('OrderController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA ZAMÓWNIEŃ';
    $scope.headers = ["Id odbiorcy", "Id wystawcy","Status","Wartość zlecenia", "Data utworzenia", "Tworzący"];
    $scope.modelNames = ["idOdbiorcy", "idWystawcy","status","wartoscZlecenia", "dataUtworzenia", "tworzacy"];
});