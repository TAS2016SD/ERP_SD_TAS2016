app.controller('DiscountController', function($scope)
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
});