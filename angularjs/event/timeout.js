angular
  .module("time-out", [])
  .controller("timeout-controller", function($scope, $timeout) {
    $scope.person = {
      name: "Manoj B",
      company: "Aurion Pro"
    };

    $timeout(function() {
      $scope.person.name = "Varshil";
      $scope.person.company = "Swabhav";
    }, 3000);
  });
