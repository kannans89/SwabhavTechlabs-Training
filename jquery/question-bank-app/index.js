var questionsArray;
var ansArray;
var numberOfQuestion;
var rightAnswer;
var wrongAnswer;

$(document).ready(function() {
  questionsArray = [];
  getQuestions();

  ansArray = [];
  ansArray.length = questionsArray.length;
  rightAnswer = 0;
  wrongAnswer = 0;
  console.log("doc ready");
});

function getQuestions() {
  console.log("inside make");
  $.ajax({
    method: "get",
    url: "http://127.0.0.1:5500/question-bank-app/resources/question-bank.json",
    success: successHandler
  });
}

function successHandler(questions) {
  questionsArray = $.map(questions.questionAnswers, (question, key) => {
    return [question];
  });
  console.log(questionsArray);
}

function displayQuestion() {
  console.log("inside display question");
  const question = questionsArray[displayQuestion.counter];
  console.log(questionsArray[0]);
  const questionNode = document.querySelector(".question");
  const optionsNode = document.querySelector(".options");
  questionNode.innerHTML = "";
  optionsNode.innerHTML = "";

  const h3 = document.createElement("h3");
  console.log("display question counter" + displayQuestion.counter);
  console.log("number of questions " + numberOfQuestion);
  console.log(questionsArray);
  if (displayQuestion.counter >= questionsArray.length) {
    console.log("You have answered all the qustions");
    chceckAnswers();
  } else {
    h3.innerHTML = ++displayQuestion.counter + ")" + " " + question.question;
    questionNode.appendChild(h3);

    displayOptions(question, optionsNode);
  }
}

displayQuestion.counter = 0;

function displayOptions(question, optionsNode) {
  question.options.map(option => {
    const div = document.createElement("div");
    div.setAttribute("class", "custom-control custom-radio");
    const radio = document.createElement("input");
    const label = document.createElement("label");

    radio.setAttribute("type", "radio");
    radio.setAttribute("class", "custom-control-input");
    radio.setAttribute("name", "question" + displayQuestion.counter);
    radio.addEventListener("click", storeAnswer);
    radio.value = option;

    label.setAttribute("class", "custom-control-label");

    label.innerHTML = option;
    div.appendChild(radio);
    div.appendChild(label);
    optionsNode.appendChild(div);
  });
}

function storeAnswer(event) {
  if (event.target.value) {
    ansArray[displayQuestion.counter] = event.target.value;
  }
  console.log(ansArray);
}

function chceckAnswers() {
  const rightWrongNode = document.querySelector(".right-wrong");
  const p1 = document.createElement("p");
  const p2 = document.createElement("p");
  const p3 = document.createElement("p");

  console.log(ansArray);
  for (var i = 0; i < ansArray.length - 1; i++) {
    if (ansArray[i + 1] !== undefined) {
      if (
        ansArray[i + 1] ===
        questionsArray[i].options[parseInt(questionsArray[i].answer)]
      ) {
        rightAnswer++;
      } else {
        wrongAnswer++;
      }
    } else {
      wrongAnswer++;
    }
  }

  console.log("Right answer " + rightAnswer);
  console.log("Wrong answer " + wrongAnswer);
  var percetage = (rightAnswer / questionsArray.length) * 100;
  p1.innerHTML = "Right answers " + rightAnswer;
  p2.innerHTML = "Wrong answers " + wrongAnswer;
  p3.innerHTML = "Percentage " + percetage.toFixed(2) + "%";

  draw(percetage);

  rightWrongNode.appendChild(p1);
  rightWrongNode.appendChild(p2);
  rightWrongNode.appendChild(p3);
}

function draw(percetage) {
  console.log("Percetage " + percetage);
  var canvas = document.getElementById("statistics");
  var context = canvas.getContext("2d");
  var anglePercent = (percetage / 100).toFixed(2);
  console.log("Angle Percetage " + anglePercent);

  var angleArray = [];
  var colorArray = [];
  if (anglePercent == 1) {
    var angle = anglePercent * 2 * Math.PI;
    angleArray.push(angle);
    colorArray.push("green");
  } else {
    var angle1 = anglePercent * 2 * Math.PI;
    var angle2 = (1 - anglePercent) * 2 * Math.PI;
    angleArray.push(angle1);
    angleArray.push(angle2);
    colorArray.push("green");
    colorArray.push("red");
  }

  var beginAngle = 0;
  var endAngle = 0;

  for (var i = 0; i < angleArray.length; i++) {
    beginAngle = endAngle;
    endAngle = beginAngle + angleArray[i];

    context.beginPath();
    context.fillStyle = colorArray[i];
    context.moveTo(200, 200);
    context.arc(200, 200, 120, beginAngle, endAngle);
    context.lineTo(200, 200);
    context.stroke();
    context.fill();
  }
}
