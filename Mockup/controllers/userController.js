app.controller('UserController', function($scope)
{
    $scope.test = "TEST KONTROLERA USER";
    $scope.data=["Imię", "Nazwisko", "Numer telefonu", "Nowe hasło", "Powtórz nowe hasło"];
    $scope.modelNames=["Imie", "Nazwisko", "NumerTelefonu", "NoweHaslo", "PowtorzNoweHaslo"];
});