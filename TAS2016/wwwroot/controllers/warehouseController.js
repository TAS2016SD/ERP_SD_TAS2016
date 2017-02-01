app.controller('WarehouseController', function($scope, $http)
{
    $scope.test = 'TEST CONTROLLERA MAGAZYNU';
    $scope.bodies=["Materiał", "Ilość", "Miejsce w magazynie"];
    $scope.modelNamesForBodies = ["Material", "Ilosc", "MiejsceWMagazynie"];
    $scope.bodiesDisplay=$scope.bodies;
    
    $http({
    method: 'GET',
    url: 'http://localhost:61690/warehouseStatus'})
    .then(function successCallback(response) {
        console.log(response.data);
        $scope.warehouses = response.data;
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
        });
    $scope.jsonTest = {
    materialId: 4,
    material: null,
    amount: 10
    };
   $scope.sendPost = function()
    {
    $scope.parameter = JSON.stringify($scope.jsonTest);
    $scope.url = 'http://localhost:61690/warehouseStatus';
    $http.post($scope.url, $scope.parameter).
    success(function(data, status, headers, config) {
        // this callback will be called asynchronously
        // when the response is available
        console.log(data);
      }).
      error(function(data, status, headers, config) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
      }); 
    }
});