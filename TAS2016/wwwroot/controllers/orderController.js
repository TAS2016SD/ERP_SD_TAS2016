app.controller('OrderController', function($scope, $http)
{
//    $scope.test = 'TEST CONTROLLERA ZLECEŃ';
    $scope.headers = ["Id odbiorcy", "Id wystawcy", "Data utworzenia", "Tworzący"];
    
    $scope.modelNames = ["IdOdbiorcy", "IdWystawcy", "DataUtworzenia", "Tworzacy"];
    
    $scope.bodies=["Materiał", "Cena"];
    
    $scope.modelNamesForBodies = ["Material", "Cena"];
    
    $scope.headersDisplay = ["Id","Id odbiorcy", "Id wystawcy", "Status", "Wartość zamównienia", "Data utworzenia", "Tworzący"];
    $scope.bodiesDisplay=["Id","Materiał","Ilość","Cena jednostkowa", "Cena za całość", "Cena po rabacie"];
//    console.log($scope.test);
//    $scope.pos=["id","amount","material","materialId","price"];
    
    $scope.init = function(index) 
    {
        $scope.position = $scope.orders[index].positions[index];
    }
    
    $http({
    method: 'GET',
    url: 'http://localhost:61690/order'})
    .then(function successCallback(response) {
        console.log(response.data);
        $scope.orders = response.data;
    }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
        });
    
});