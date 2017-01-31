app.controller('ProviderController', function($scope, $http)
{
    $scope.test = 'TEST CONTROLLERA DOSTWACA';
    $scope.bodies=["Id dostawcy", "Nazwa", "Adres", "E-mail", "Numer telefonu"];
    $scope.modelNamesForBodies = ["IdDostawcy", "Nazwa", "Adres","Email","NumerTelefonu"];
    $scope.bodiesDisplay=$scope.bodies;
    $http({
    method: 'GET',
    url: 'http://localhost:61690/Provider'})
    .then(function successCallback(response) {
        console.log(response.data);
        $scope.provider = response.data;
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
        });
});