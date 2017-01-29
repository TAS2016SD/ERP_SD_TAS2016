app.controller('ProviderController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA DOSTWACA';
    $scope.bodies=["Id dostawcy", "Nazwa", "Adres", "E-mail", "Numer telefonu"];
    $scope.modelNamesForBodies = ["IdDostawcy", "Nazwa", "Adres","Email","NumerTelefonu"];
    $scope.bodiesDisplay=$scope.bodies;
});