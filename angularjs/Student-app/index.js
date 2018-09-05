angular
  .module("student-app", [])
  .controller("student-controller", function(
    $scope,
    $timeout,
    studentDataService
  ) {
    $scope.students = [];
    $scope.loading = false;

    studentDataService
      .getStudents()
      .then(students => {
        students.map(student => {
          if (student.isMale) {
            student.gender = "Male";
          } else {
            student.gender = "Female";
          }
          $scope.students.push(student);
        });

        console.log($scope.students);
      })
      .catch(error => {
        console.log("Error");
      });

    $scope.submitData = function(isValid) {
      $scope.loading = true;

      if (isValid) {
        console.log($scope.students);
        $scope.students.push($scope.student);

        $timeout(function() {
          $scope.loading = false;
        }, 2000);

        studentDataService
          .putStudents($scope.student)
          .then(response => {
            console.log(response.data);
            $scope.loading = false;
            console.log("Data added");
          })
          .catch(response => {
            $scope.loading = false;
          });
      } else {
        $scope.student = "";
      }
    };

    $scope.g;
  });

var studentApp = angular.module("student-app");
studentApp.filter("colorchange", function() {
  return function(gender) {
    if (gender === "Female") {
      return true;
    } else {
      return false;
    }
  };
});

angular
  .module("student-app")
  .factory("studentDataService", function($http, $q) {
    const studentService = {};

    studentService.getStudents = () => {
      return $q((resolve, reject) => {
        $http({
          method: "GET",
          url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students"
        }).then(response => {
          if (response.status !== 404) {
            resolve(response.data);
          } else {
            reject(response.statusText);
          }
        });
      });
    };

    studentService.putStudents = student => {
      return $q((resolve, reject) => {
        const updatedStudent = student;
        if (student.gender === "Male") {
          updatedStudent.isMale = true;
        }
        console.log(updatedStudent);
        $http({
          method: "POST",
          url: "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students",
          data: updatedStudent
        }).then(response => {
          if (response.status !== 404) {
            resolve(response.data);
          } else {
            reject(response.statusText);
          }
        });
      });
    };
    return studentService;
  });

angular.module("student-app").filter("checkGender", function() {
  return function(isMale) {
    if (isMale) {
      return "Male";
    } else {
      return "Female";
    }
  };
});
