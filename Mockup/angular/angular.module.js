//var App = angular.module('app', ['ui.router']);
var App = angular.module('app', ['ui.router']);
//var myApp = angular.module('myApp', ['ui.router','myApp.filters', 'myApp.services', 'myApp.directives', 'ngSanitize']);
App.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider
    .state('basicData', {
      url: '/basicData',
      views: {
        nav: {
          templateUrl: 'navbar.html'
        },
        content: {
          templateUrl: 'basicData.html'
        }
      }
    })
    .state('warehouse', {
      url: '/warehouse',
      views: {
        nav: {
          templateUrl: 'navbar.html'
        },
        content: {
          templateUrl: 'warehouse.html'
        }
      } 
    }).state('landingpage', {
      url: '/landingpage',
      views: {
        content: {
          templateUrl: 'landingpage.html'
        }
      } 
    });
  $urlRouterProvider.otherwise('/basicData');
});

app.directive('appInfo', function() { 
  return { 
    restrict: 'E', 
    scope: { 
      info: '=' 
    }, 
    templateUrl: 'basicData.html' 
  }; 
});