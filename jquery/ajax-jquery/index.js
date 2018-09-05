var domNode = {};
$(document).ready(init);

function init() {
  $(".fact-button").click(makeRequest);
}

function makeRequest() {
  var inputNode = $("#fact-input");
  var value = inputNode.val();

  addSpinner();

  setTimeout(function() {
    $.ajax({
      method: "get",
      url: "http://numbersapi.com/" + value,
      success: successHandler
    });
  }, 2000);
}

function addSpinner() {
  var divSpinner = $(".spinner");

  var i = $("<i></i>");
  i.attr("class", "fas fa-spinner fa-spin fa-5x");

  divSpinner.append(i);
}

function removeSpinner() {
  $(".spinner").html("");
}

function successHandler(result) {
  //console.log(result[0] + result[1] + "");
  var ulNode = $("#response-data-item");
  var liNode = $("<li>" + result + "</li>");
  liNode.attr("class", "list-group-item");
  ulNode.prepend(liNode);
  removeSpinner();
}
