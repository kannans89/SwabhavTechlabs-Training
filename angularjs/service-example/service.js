angular
  .module("service-app", [])
  .factory("mathService", function($log, $q) {
    $log.info("Inside math service");
    const obj = {};
    obj.cubeEven = number => {
      if (number % 2 != 0) {
        $log.log("Not an even number");
      } else {
        return number * number * number;
      }
    };

    obj.cubeOdd = number => {
      return $q((resolve, reject) => {
        if (number % 2 != 0) {
          resolve(number * number * number);
        } else {
          reject("Not an odd number");
        }
      });
    };
    return obj;
  })
  .controller("service-controller", function($log, mathService) {
    console.log(mathService.cubeEven(6));
    mathService
      .cubeOdd(6)
      .then(result => {
        console.log(result);
      })
      .catch(result => {
        console.log(result);
      });
  });
