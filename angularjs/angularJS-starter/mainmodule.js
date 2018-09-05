angular
  .module("swabhav.modA", ["swabhav.modB", "swabhav.modC"])
  .controller("home-controller", function($scope, $rootScope) {
    console.log("Inside home controller");
    $scope.home = {
      data: "Module swabhav"
    };

    $rootScope.company = {
      name: "Swabhavtechlabs"
    };
  });


  