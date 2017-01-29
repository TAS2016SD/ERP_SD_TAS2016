app.controller('UserController', function($scope)
{
    $scope.test = "TEST KONTROLERA USER";
    $scope.data=["Imię", "Nazwisko", "Numer telefonu", "Nowe hasło", "Powtórz nowe hasło"];
    $scope.modelNames=["Imie", "Nazwisko", "NumerTelefonu", "NoweHaslo", "PowtorzNoweHaslo"];
    $scope.userData=["Janusz", "test", "test", "test", "test"];
});