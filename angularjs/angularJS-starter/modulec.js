angular
  .module("swabhav.modC", [])
  .controller("faculty-controller", function($scope, $rootScope) {
    console.log("Inside faculty controller");
    $scope.faculty = {
      data: "Module swabhavC"
    };
  });
