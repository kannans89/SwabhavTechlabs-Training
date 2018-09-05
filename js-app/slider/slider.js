(function() {
  var buttons = document.getElementById("buttons");
  var slider = document.getElementById("slider");
  slider.addEventListener("input", generateButtons);

  function generateButtons(event) {
    while (buttons.firstChild) {
      buttons.removeChild(buttons.firstChild);
    }
    for (let i = 0; i < event.target.value; i++) {
      createButtonElement(buttons, i);
    }
  }

  function createButtonElement(buttons, i) {
    var button = document.createElement("button");
    button.innerHTML = "button " + i;
    button.setAttribute("value", i);
    button.addEventListener("click", function(event) {
      console.log(event.target.value);
    });
    buttons.appendChild(button);
  }
})();
