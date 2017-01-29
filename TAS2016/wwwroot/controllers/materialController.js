app.controller('MaterialController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA Materiał';
    $scope.bodies=["Id materiału", "Nazwa", "Cena", "Cena jednostkowa", "Długość", "Szerokość", "Wysokość","Waga"];
    $scope.modelNamesForBodies = ["IdMaterialu", "Nazwa", "Cena", "CenaJednostkowa", "Dlugosc", "Szerokosc", "Wysokosc","Waga"];
    $scope.bodiesDisplay=$scope.bodies;
});