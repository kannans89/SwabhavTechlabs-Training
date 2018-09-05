var toDoList;

$(document).ready(function() {
  toDoList = [];
  init();
  $(document).keypress(function(event) {
    var keycode = event.keyCode ? event.keyCode : event.which;
    if (keycode == "13") {
      analyseValue();
    }
  });

  function init() {
    //localStorage.clear();
    $(".add-to-do").click(analyseValue);
    retrieveToDoList();
    displayToDoList();
    console.log(toDoList);
  }

  function analyseValue() {
    var inputNode = $("#to-do");
    var value = inputNode.val();
    if (checkValue(value)) {
      toDoList.push({
        id: getDate(),
        item: value,
        completed: false,
        deleted: false
      });
      console.log(toDoList[toDoList.length - 1]);
      displayTodo(toDoList[toDoList.length - 1]);

      storeToDoList(toDoList);
    } else {
      displayError();
    }
  }

  function checkValue(value) {
    //console.log(value.length);
    return value.length > 0;
  }
});

function displayError() {
  console.log("Please enter something");
}

function storeToDoList(todoList) {
  localStorage.setItem("toDoList", JSON.stringify(todoList));
  //console.log(JSON.stringify(todoList));
}

function retrieveToDoList() {
  if (localStorage.getItem("toDoList")) {
    toDoList = JSON.parse(localStorage.getItem("toDoList"))
      ? JSON.parse(localStorage.getItem("toDoList"))
      : [];
  }
}

function getDate() {
  var newDate = new Date();
  var year = newDate.getFullYear();
  var date = newDate.getDate();
  var month = newDate.getMonth();
  var hours = newDate.getHours();
  var minutes = newDate.getMinutes();
  var seconds = newDate.getSeconds();
  var milliSec = newDate.getMilliseconds();
  var element =
    name +
    " " +
    date +
    "/" +
    month +
    "/" +
    year +
    " " +
    hours +
    ":" +
    minutes +
    ":" +
    seconds +
    ":" +
    milliSec;
  console.log("Date " + element);
  return element;
}

function displayToDoList() {
  if (toDoList) {
    toDoList.forEach(todo => {
      if (!todo.deleted) {
        displayTodo(todo);
      }
    });
  }
}

function displayTodo(todo) {
  console.log(todo);

  var div = $("<div></div>");

  var li = $("<li>" + todo.item + "</li>");
  li.attr("class", "list-group-item list-group-item-light");
  li.attr("id", todo.id);
  //console.log(todo.id);
  //console.log(toDoList[toDoList.length - 1].id);

  var i = $("<i></i>");
  i.attr("class", "fa-li fa-fw fa fa-square");

  var iDelete = $("<i></i>");
  iDelete.attr("class", "fa fa-window-close");

  var span = $("<span></span>");
  span.attr("class", "float-right");

  span.append(iDelete);
  li.append(i);
  li.append(span);
  div.append(li);
  $(".to-do-s").append(div);

  var id = todo.id;
  console.log("id " + id);
  iDelete.attr("onclick", "removeElement(this)");
  i.attr("onclick", "markFinish(this, null)");

  if (todo.completed) {
    markFinish(i, todo.id);
  }
  console.log(`${todo.id}`);
}

function markFinish(iTag, id) {
  var id;
  if (iTag) {
    id = $(iTag)
      .closest("li")
      .attr("id");
  } else {
    id = id;
  }

  console.log("id is " + id);
  retrieveToDoList();
  const updatedToDoList = toDoList.map(todo => {
    if (todo.id === id) {
      console.log(todo.id + " " + id);
      const updatedTodo = {
        ...todo,
        completed: !todo.completed
      };
      toggleClass(iTag);
      //$(div + "#id").css("text-decoration", "line-through");
      return updatedTodo;
    } else {
      return todo;
    }
  });
  console.log(updatedToDoList);
  storeToDoList(updatedToDoList);
}

function toggleClass(iTag) {
  console.log("inside toggle");
  var id = $("#id")
    .closest("i")
    .attr("onclick");
  console.log(id);

  $(iTag).toggleClass("fa-check-square");
}

function removeElement(span) {
  $(span)
    .closest("li")
    .remove();

  var id = $(span)
    .closest("li")
    .attr("id");

  retrieveToDoList();
  const updatedToDoList = toDoList.map(todo => {
    if (todo.id === id) {
      console.log(todo.id + " " + id);
      const updatedTodo = {
        ...todo,
        deleted: true
      };
      return updatedTodo;
    } else {
      return todo;
    }
  });
  console.log(updatedToDoList);
  storeToDoList(updatedToDoList);
}
