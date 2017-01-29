app.controller('ClientController', function($scope, $http)
{
    $scope.test = 'TEST CONTROLLERA KLIENT';
    $scope.bodies=["Id klienta", "Nazwa", "Adres", "E-mail", "Numer telefonu", "NIP", "VAT"];
    $scope.modelNamesForBodies = ["IdKlienta", "Nazwa", "Adres","Email","NumerTelefonu","NIP","VAT"];
    $scope.bodiesDisplay =$scope.bodies;
    $scope.data = ["janusz"];
    
//    $http({
//  method: 'GET',
//  url: 'http://tas2016.azurewebsites.net/Client/'
//}).then(function successCallback(response) {
//    // this callback will be called asynchronously
//    // when the response is available
//  }, function errorCallback(response) {
//    // called asynchronously if an error occurs
//    // or server returns response with an error status.
//  });
});