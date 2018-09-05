angular.module("spa-app", ["ngRoute"]).config(function($routeProvider) {
  // $locationProvider.html5Mode(true);
  // $locationProvider.hashPrefix("!");
  $routeProvider
    .when("/", {
      templateUrl: "partialView/home.html",
      controller: "home-controller"
    })
    .when("/about", {
      templateUrl: "partialView/about.html",
      controller: "about-controller"
    })
    .when("/career", {
      templateUrl: "partialView/career.html",
      controller: "career-controller"
    });
});
angular.module("spa-app").controller("home-controller", function($scope) {
  $scope.home = {
    message: "I am from Home controller"
  };
});
angular.module("spa-app").controller("about-controller", function($scope) {
  $scope.about = {
    message: "I am from About controller"
  };
});
angular.module("spa-app").controller("career-controller", function($scope) {
  $scope.career = {
    message: "I am from Career controller"
  };
});
