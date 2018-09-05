angular
  .module("numbers-app", [])
  .factory("factService", function($http, $q) {
    const obj = {};

    obj.getNumberFact = number => {
      return $q((resolve, reject) => {
        $http({
          method: "GET",
          url: "http://numbersapi.com/" + number
        })
          .then(response => {
            if (response.status !== 404) {
              resolve(response.data);
            } else {
              reject(response.statusText);
            }
          })
          .catch(error => {
            console.log(error.status);
          });
      });
    };
    return obj;
  })
  .controller("numbers-controller", function(factService) {
    factService
      .getNumberFact(5)
      .then(fact => console.log(fact))
      .catch(error => console.log(error));
  });
