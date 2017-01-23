app.controller('OrderController', function($scope)
{
    $scope.test = 'TEST CONTROLLERA ZAMÓWNIEŃ';
    $scope.headers = ["Id odbiorcy", "Id wystawcy", "Data utworzenia", "Tworzący"];
    $scope.modelNames = ["IdOdbiorcy", "IdWystawcy", "DataUtworzenia", "Tworzacy"];
    $scope.bodies=["Materiał", "TEST1","TEST2","TEST3"];
    $scope.modelNamesForBodies = ["Material", "Test1","Test2","Test3"];
});