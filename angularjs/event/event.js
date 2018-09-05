angular
  .module("event-app", ["time-out"])
  .controller("event-controller", function($scope) {
    $scope.employee = {
      id: 1234,
      firstName: "Varshil",
      lastName: "Mehta",
      Photo: "resources/emp.jpeg"
    };
  });
