var dataService = (function() {
  var obj = {};

  obj.getData = () => {
    return new Promise((resolve, reject) => {
      var result = (Math.random() * 10).toFixed(2);
      if (result >= 5) {
        resolve(result);
      } else {
        reject("Number is less than 5 " + result);
      }
    });
  };
  return obj;
})();

dataService
  .getData()
  .then(
    result => {
      console.log(result + " 1st call");
      return dataService.getData();
    },
    error => {
      console.log(error);
    }
  )
  .then(
    result => {
      console.log(result + " 2nd call");
    },
    error => {
      console.log(error + " 2nd call");
    }
  );
