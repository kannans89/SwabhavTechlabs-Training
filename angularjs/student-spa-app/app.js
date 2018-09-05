angular
  .module("student-app", ["ngRoute", "ngStorage"])
  .config(function($routeProvider) {
    $routeProvider
      .when("/", {
        templateUrl: "templates/home.html",
        controller: "main-controller"
      })
      .when("/add", {
        templateUrl: "templates/form.html",
        controller: "add-controller"
      })
      .when("/edit/:id", {
        templateUrl: "templates/form.html",
        controller: "edit-controller"
      })
      .when("/delete/:id", {
        templateUrl: "templates/home.html",
        controller: "delete-controller"
      })
      .when("/signup", {
        templateUrl: "templates/signup.html",
        controller: "signup-controller"
      })
      .when("/login", {
        templateUrl: "templates/login.html",
        controller: "login-controller"
      });
  });

angular
  .module("student-app")
  .controller("signup-controller", function(userService, $scope, $window) {
    $scope.addUser = function() {
      console.log("User is " + $scope.user);
      userService
        .addUser($scope.user)
        .then(function(result) {
          console.log(result);
          $window.location.href = "#/";
        })
        .catch(result => {
          console.log(result);
        });
    };
  });

angular
  .module("student-app")
  .controller("login-controller", function(
    $scope,
    authenticateService,
    $window,
    $localStorage
  ) {
    $scope.loginUser = function() {
      console.log($scope.user);
      authenticateService
        .checkUserIsRegistered($scope.user.email)
        .then(user => {
          console.log("inside then logincontroll");
          console.log(user + " user found");
          authenticateService
            .authenticateUser($scope.user)
            .then(result => {
              console.log(result);
              $localStorage.currentuser = {
                user: $scope.user,
                loggedIn: true
              };
              $window.location.href = "#/";
            })
            .catch(error => {
              console.log(error);
            });
        })
        .catch(error => {
          console.log("inside catch logincontroll");
          console.log(error);
          $window.location.href = "#/login";
        });
    };
  });

angular
  .module("student-app")
  .factory("authenticateService", function(userService, $q) {
    var authService = {};
    authService.loggedIn = false;
    authService.currentUser = {};

    authService.authenticateUser = function(user) {
      return $q((resolve, reject) => {
        userService.getUser(user.email).then(returnedUser => {
          console.log(returnedUser[0].password);
          if (user.password === returnedUser[0].password) {
            authService.currentUser = returnedUser[0];
            console.log(authService.currentUser);
            resolve("Successfully logged in");
            authService.loggedIn = true;
          } else {
            reject("Password wrong");
          }
        });
      });
    };

    authService.checkUserIsRegistered = function(email) {
      return $q((resolve, reject) => {
        userService
          .getUser(email)
          .then(user => {
            console.log("inside resolver authservice");
            resolve(user);
          })
          .catch(error => {
            console.log("inside reject authservice");
            reject(error);
          });
      });
    };

    authService.checkLoginState = function() {};
    return authService;
  });

angular.module("student-app").factory("userService", function($q) {
  users = [
    {
      id: 101,
      firstname: "Manoj",
      lastname: "B",
      email: "manojb912@gmail.com",
      password: "123456"
    }
  ];
  var userService = {};

  userService.getUsers = function() {
    return users;
  };
  userService.addUser = user => {
    var newId = users[users.length - 1].id + 1;
    var newEmail = user.email;

    return $q((resolve, reject) => {
      var userExist = users.every(user => {
        return user.email !== newEmail;
      });

      console.log(userExist);
      if (userExist) {
        user.id = newId;
        users.push(user);
        resolve("Success");
      } else {
        reject("Already exist");
      }
    });
  };

  userService.getUser = email => {
    return $q((resolve, reject) => {
      var user = users.filter(user => {
        return user.email === email;
      });
      console.log(user);
      if (user.length > 0) {
        console.log("Inside resolver userservice");
        resolve(user);
      } else {
        console.log("Inside reject userservice");
        reject("No user found");
      }
    });
  };

  userService;
  return userService;
});

angular
  .module("student-app")
  .controller("main-controller", function(
    $scope,
    studentService,
    authenticateService,
    $rootScope,
    $window,
    $localStorage
  ) {
    $scope.users = [];
    $scope.students = [];
    $rootScope.loggedIn = authenticateService.loggedIn;
    $scope.showFilter = false;
    $scope.namesArray = [];

    $scope.filterNames = function() {
      studentService.getStudents().then(students => {
        console.log(students);
        var fil = $scope.input;
        $scope.namesArray = [];
        if ($scope.input) {
          students.map(student => {
            student.firstName.split("").map(char => {
              for (let i = 0; i < fil.length; i++) {
                if (fil[i].toUpperCase() == char.toUpperCase()) {
                  $scope.namesArray.push(student.firstName);
                }
              }
            });
          });
          if ($scope.namesArray.length > 0) {
            $scope.showFilter = true;
          }
        }
      });
    };

    if ($localStorage.currentuser) {
      console.log($localStorage.currentuser.user);
      $rootScope.currentUser = $localStorage.currentuser.user.email;
      $rootScope.loggedIn = $localStorage.currentuser.loggedIn;
    }
    //$rootScope.currentUser = authenticateService.currentUser.firstname;
    console.log($rootScope.currentUser);
    //console.log("Logged Out " + authenticateService.loggedIn);
    studentService.getStudents().then(students => {
      $scope.students = students;
    });

    $scope.logOutUser = () => {
      authenticateService.loggedIn = false;
      $rootScope.loggedIn = false;
      $localStorage.currentuser = "";
      $window.location.href = "#/";
    };

    $scope.submitData = function(isValid) {
      if (isValid) {
        $scope.user = "";
      }
    };
  });

angular
  .module("student-app")
  .controller("add-controller", function(
    studentService,
    $scope,
    $window,
    authenticateService
  ) {
    if (!authenticateService.loggedIn) {
      $window.location.href = "#/login";
    }
    $scope.addStudent = function() {
      if (authenticateService.loggedIn) {
        console.log($scope.student);
        studentService.addStudent($scope.student).then(res => {
          console.log("Student added successfully");
          $window.location.href = "#/";
        });
      } else {
        $window.location.href = "#/";
      }
    };
  });

angular
  .module("student-app")
  .controller("delete-controller", function(
    $scope,
    $routeParams,
    studentService,
    $window,
    authenticateService
  ) {
    if (!authenticateService.loggedIn) {
      $window.location.href = "#/login";
    }
    console.log($routeParams.id);

    console.log("Id is " + $routeParams.id);
    studentService.deleteSingleStudent($routeParams.id).then(result => {
      console.log(result);
      $window.location.href = "#/";
      $scope.message = "Deleted successfully";
    });
  });

angular
  .module("student-app")
  .controller("edit-controller", function(
    $scope,
    studentService,
    $routeParams,
    $window,
    authenticateService
  ) {
    if (!authenticateService.loggedIn) {
      $window.location.href = "#/login";
    }
    $scope.edit = true;

    console.log("Edit controller");
    console.log("Id is " + $routeParams.id);
    studentService.getSingleStudent($routeParams.id).then(student => {
      console.log(student);
      $scope.student = student[0];
      $scope.gender = student[0].gender;
      //$scope.student.firstName = student[0].firstName;
      console.log($scope.student);
      //$scope.student.firstName = student.firstName;
    });

    $scope.updateStudent = function() {
      console.log($scope.student);
      studentService
        .updateStudent($routeParams.id, $scope.student)
        .then(res => {
          console.log("Student updated successfully");
          $window.location.href = "#/";
        });
    };
  });

angular.module("student-app").factory("studentService", function($q, $timeout) {
  var studentService = {};
  students = [];

  students = [
    {
      id: 101,
      firstName: "Manoj",
      lastName: "B",
      cgpa: 7.45,
      rollNo: 21,
      gender: "Male"
    },
    {
      id: 102,
      firstName: "Mansa",
      lastName: "B",
      cgpa: 7,
      rollNo: 19,
      gender: "Female"
    },
    {
      id: 103,
      firstName: "Varshil",
      lastName: "B",
      cgpa: 7,
      rollNo: 19,
      gender: "Male"
    },
    {
      id: 104,
      firstName: "Shubham",
      lastName: "B",
      cgpa: 7,
      rollNo: 25,
      gender: "Male"
    }
  ];

  studentService.getStudents = function() {
    return $q((resolve, reject) => {
      if (students.length > 0) {
        resolve(students);
      } else {
        reject("Error");
      }
    });
  };

  studentService.getSingleStudent = function(id) {
    return $q((resolve, reject) => {
      var student = [];
      if (students.length > 0) {
        student = students.filter(student => {
          console.log(student.id + "=" + id);
          return student.id == id;
        });
        if (student) {
          resolve(student);
        }
      } else {
        reject("Error");
      }
    });
  };

  studentService.updateStudent = function(id, student) {
    return $q((resolve, reject) => {
      $timeout(function() {
        var student = students.map(student => {
          if (student.id === id) {
            students[student] = student;
          }
        });

        students;
        resolve("Success");
      }, 2000);
    });
  };

  studentService.deleteSingleStudent = function(id) {
    return $q((resolve, reject) => {
      students = students.filter(student => {
        console.log(student.id + "from deleteSingleStudent");
        return student.id != id;
      });

      console.log(students);
      resolve("deleted Successfully");
    });
  };

  studentService.addStudent = function(student) {
    student.id = students[students.length - 1].id + 1;
    console.log(student.id);
    return $q((resolve, reject) => {
      $timeout(function() {
        students.push(student);
        resolve("Success");
      }, 2000);
    });
  };

  return studentService;
});

angular.module("student-app").filter("colorchange", function() {
  return function(gender) {
    if (gender === "Female") {
      return true;
    } else {
      return false;
    }
  };
});
