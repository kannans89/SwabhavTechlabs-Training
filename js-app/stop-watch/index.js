(function() {
  var start = document.querySelector(".start");
  var stop = document.querySelector(".stop");
  var timeNode = document.querySelector(".time");

  start.addEventListener("click", startClock);
  stop.addEventListener("click", stopClock);
  var id;

  function startClock() {
    var milliSeconds = 0,
      seconds = 0,
      minutes = 0;
    id = setInterval(startTime, 10);

    function startTime() {
      milliSeconds += 10;
      seconds += 0.01;
      console.log(minutes + " " + seconds + " " + milliSeconds);

      if (milliSeconds > 100) {
        milliSeconds = 0;
      }
      if (seconds >= 60) {
        seconds = 0;
        minutes += 1;
      }
      var displayTime =
        Math.floor(minutes.toFixed(2)) +
        ":" +
        Math.floor(seconds.toFixed(2)) +
        ":" +
        Math.floor(milliSeconds.toFixed(2));
      timeNode.innerHTML = displayTime;
    }
  }

  function stopClock() {
    clearInterval(id);
  }
})();
