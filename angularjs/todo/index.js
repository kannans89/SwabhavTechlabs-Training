angular.module("todo-app", []).controller("todo-controller", function($scope) {
  $scope.todoList = [];

  $scope.addTodo = function() {
    console.log($scope.todo);
    $scope.todoList.push($scope.todo);
  };

  $scope.removeTodo = function(key) {
    const oldList = $scope.todoList;
    console.log(key);
    $scope.todoList = [];
    const updated = oldList.filter(todo => {
      console.log("Key is " + key, "todo is " + oldList[todo]);
      return oldList[key] !== todo;
    });
    console.log(updated);
    $scope.todoList = updated;
  };
});
