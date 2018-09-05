(function() {
  var i = 0;
  window.addEventListener("hashchange", function() {
    console.log("URL changed " + i++);
    console.log(document.location.hash);
  });

  var a = document.getElementsByTagName("a");
  var arrayOfa = Array.from(a);
  console.log(typeof arrayOfa);
  arrayOfa.forEach(a => {
    a.addEventListener("click", changeHash);
  });

  function changeHash(e) {
    console.log(e.target.hash);
    document.location.hash = e.target.hash;
  }
})();
