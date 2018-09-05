angular
  .module("swabhav.modB", [])
  .controller("student-controller", function($scope, $rootScope) {
    console.log("Inside student controller");
    $scope.studentController = {
      students: [
        {
          name: "Manoj B",
          id: "123",
          phone: 7276234147
        },
        {
          name: "Umesh Patil",
          id: "123",
          phone: 7276234147
        },
        {
          name: "Varshil Mehta",
          id: "123",
          phone: 7276234147
        }
      ]
    };
  });
