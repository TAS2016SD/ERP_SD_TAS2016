app.controller('MaterialController', function($scope, $http)
{
    $scope.test = 'TEST CONTROLLERA Materiał';
    $scope.bodies=["Id materiału", "Nazwa", "Cena", "Cena jednostkowa", "Długość", "Szerokość", "Wysokość","Waga"];
    $scope.modelNamesForBodies = ["IdMaterialu", "Nazwa", "Cena", "CenaJednostkowa", "Dlugosc", "Szerokosc", "Wysokosc","Waga"];
    $scope.bodiesDisplay=$scope.bodies;
    
       $http({
    method: 'GET',
    url: 'http://localhost:61690/Material'})
    .then(function successCallback(response) {
        console.log(response.data);
        $scope.materials = response.data;
//        console.log($scope.models[0]);
//        $scope.databaseModel = response.
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
        });
});