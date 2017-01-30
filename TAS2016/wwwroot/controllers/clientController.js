app.controller('ClientController', function($scope, $http)
{
    $scope.test = 'TEST CONTROLLERA KLIENT';
    $scope.bodies=["Id klienta", "Nazwa", "Adres", "E-mail", "Numer telefonu", "NIP", "VAT"];
    $scope.modelNamesForBodies = ["IdKlienta", "Nazwa", "Adres","Email","NumerTelefonu","NIP","VAT"];
    $scope.bodiesDisplay =$scope.bodies;
    $scope.data = ["janusz"];
    
    $http({
    method: 'GET',
    url: 'http://localhost:61690/Client'})
    .then(function successCallback(response) {
        console.log(response.data);
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    });
});