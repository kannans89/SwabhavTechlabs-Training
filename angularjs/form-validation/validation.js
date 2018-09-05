angular
  .module("validation-app", [])
  .controller("validation-controller", function($scope) {
    $scope.users = [];

    $scope.submitData = function(isValid) {
      //console.log($scope.user.gender);
      $scope.users.push($scope.user);
      //console.log($scope.users);
      if (isValid) {
        $scope.user = "";
      }
    };

    $scope.callName = function() {
      // console.log(
      //   $scope.userForm.name.$invalid && !$scope.userForm.name.$pristine
      // );
    };

    $scope.deleteRow = key => {
      var users = $scope.users.filter(user => {
        console.log(user[0]);
        return user.name !== $scope.users[key].name;
      });
      console.log(users);
    };

    $scope;
  });

var validationApp = angular.module("validation-app");
validationApp.filter("colorchange", function() {
  return function(gender) {
    //console.log(gender === "female");
    if (gender === "female") {
      //console.log(gender === "female");
      return true;
    } else {
      return false;
    }
  };
});
