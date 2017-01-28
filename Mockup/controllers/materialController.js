app.controller('MaterialController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA Materiał';
    $scope.bodies=["Id klienta", "Nazwa", "Adres", "E-mail", "Numer telefonu", "NIP", "VAT"];
    $scope.modelNamesForBodies = ["IdKlienta", "Nazwa", "Adres","Email","NumerTelefonu","NIP","VAT"];
    $scope.bodiesDisplay=$scope.bodies;
});