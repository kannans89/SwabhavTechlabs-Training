angular
  .module("binding-app", [])
  .controller("binding-controller", function($scope) {
    $scope.student = {
      firstName: "Varshil",
      lastName: "Mehta"
    };
  });
