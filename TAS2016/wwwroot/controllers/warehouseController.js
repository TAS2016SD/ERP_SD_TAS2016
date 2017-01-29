app.controller('WarehouseController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA MAGAZYNU';
    $scope.bodies=["Materiał", "Ilość", "Miejsce w magazynie"];
    $scope.modelNamesForBodies = ["Material", "Ilosc", "MiejsceWMagazynie"];
    $scope.bodiesDisplay=$scope.bodies;
});