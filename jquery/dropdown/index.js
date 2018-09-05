$(document).ready(function() {
  $("#header").text("Welcome");
  $dropDown = $("body").find("#dropdown");
  setOptions($dropDown);
  $dropDown.change(displayColor);
  displayColor($dropDown);
});

function displayColor(dropDown) {
  $("body").css("background-color", $dropDown.val() + "");
}

function setOptions() {
  $dropDown.append('<option value="#66BB6A">Green</option>');
  $dropDown.append('<option value="#EF5350">Red</option>');
  $dropDown.append('<option value="#0277BD">Blue</option>');
}
