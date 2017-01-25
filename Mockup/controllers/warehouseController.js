app.controller('WarehouseController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA ZAMÓWNIEŃ';
    $scope.headers = ["Id odbiorcy", "Id wystawcy", "Data utworzenia", "Tworzący"];
    $scope.modelNames = ["IdOdbiorcy", "IdWystawcy", "DataUtworzenia", "Tworzacy"];
    $scope.bodies=["Materiał", "Cena"];
    $scope.modelNamesForBodies = ["Material", "Cena"];
    $scope.headersDisplay = ["Id","Id odbiorcy", "Id wystawcy", "Status", "Wartość zamównienia", "Data utworzenia", "Tworzący"];
    $scope.bodiesDisplay=["Id","Materiał","Ilość","Cena jednostkowa", "Cena za całość", "Cena po rabacie"];
});