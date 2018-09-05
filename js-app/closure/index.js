var scope = "global";

function checkScope() {
  var scope = "local";
  function inner() {
    return scope;
  }
  return inner;
}

console.log(checkScope());
