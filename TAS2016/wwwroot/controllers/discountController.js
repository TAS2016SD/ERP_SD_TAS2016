app.controller('DiscountController', function($scope, $http)
{
    $scope.test = 'TEST CONTROLLERA RABATÓW';
    $scope.bodies=["Id rabatu", "Wartość", "Podstawa", "Data początkowa", "Data Końcowa"];
    $scope.modelNamesForBodies = ["IdRabatu", "Wartosc", "Podstawa", "DataPoczatkowa", "DataKoncowa"];
    $scope.bodiesDisplay=$scope.bodies;
    $scope.bodiesMaterial=["Materiał", "Rabat"];
    $scope.modelNamesForBodiesMaterial = ["Material","Rabat"];
     $scope.bodiesDisplayMaterial=$scope.bodiesMaterial;
    $scope.bodiesClient=["Klient", "Rabat"];
    $scope.modelNamesForBodiesClient = ["Klient","Rabat"];
    $scope.bodiesDisplayClient=$scope.bodiesClient;
    
    $http({
    method: 'GET',
    url: 'http://localhost:61690/clientDiscount'})
    .then(function successCallback(response) {
        console.log(response.data);
        $scope.clientDiscounts = response.data;
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
        });
    $http({
    method: 'GET',
    url: 'http://localhost:61690/materialDiscount'})
    .then(function successCallback(response) {
        console.log(response.data);
        $scope.materialDiscounts = response.data;
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
        });
});

