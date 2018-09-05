var questionsArray;
var ansArray;
var numberOfQuestion;
var questionsAndAnswers = [
  {
    question: "Choose the capital of India?",
    options: ["Mumbai", "Bangalore", "New Delhi", "Chennai"],
    answer: "New Delhi"
  },
  {
    question: "Choose the capital of Karnataka?",
    options: ["Mumbai", "Bangalore", "New Delhi", "Chennai"],
    answer: "Bangalore"
  },
  {
    question: "Caluclate (9-5)*5?",
    options: ["20", "50", "10", "15"],
    answer: "20"
  },
  {
    question: "President of US?",
    options: ["Obama", "Trump", "Clinton", "Modi"],
    answer: "Trump"
  },
  {
    question: "Choose the capital of India?",
    options: ["Mumbai", "Bangalore", "New Delhi", "Chennai"],
    answer: "New Delhi"
  }
];

function init() {
  questionsArray = [];
  numberOfQuestion = 5;
  ansArray = [];
  ansArray.length = numberOfQuestion;
  generateQuestions();
}

function generateQuestions() {
  for (var i = 0; i < numberOfQuestion; i++) {
    questionsArray.push(getQuestion(i));
  }
}

function getQuestion(i) {
  const question = {};
  question.question = questionsAndAnswers[i].question;
  question.options = questionsAndAnswers[i].options;
  question.answer = questionsAndAnswers[i].answer;
  return question;
}

function displayQuestion() {
  const question = questionsArray[displayQuestion.counter];

  const questionNode = document.querySelector(".question");
  const optionsNode = document.querySelector(".options");
  questionNode.innerHTML = "";
  optionsNode.innerHTML = "";

  const h4 = document.createElement("h4");
  if (displayQuestion.counter >= numberOfQuestion) {
    console.log("You have answered all the qustions");
    chceckAnswers();
  } else {
    h4.innerHTML = ++displayQuestion.counter + ")" + " " + question.question;
    questionNode.appendChild(h4);

    displayOptions(question, optionsNode);
  }
}

displayQuestion.counter = 0;

function displayOptions(question, optionsNode) {
  question.options.map(option => {
    const div = document.createElement("div");
    div.className = "opt";
    const radio = document.createElement("input");
    const label = document.createElement("label");
    radio.setAttribute("type", "radio");
    radio.setAttribute("name", "question" + displayQuestion.counter);
    radio.addEventListener("click", storeAnswer);
    radio.value = option;

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
  let rightAnswer = 0;
  let wrongAnswer = 0;
  const rightWrongNode = document.querySelector(".right-wrong");
  const p1 = document.createElement("p");
  const p2 = document.createElement("p");
  const p3 = document.createElement("p");

  for (var i = 0; i < ansArray.length; i++) {
    console.log("value of i is " + i + " " + questionsArray[i].answer);
    if (ansArray[i] !== undefined) {
      if (ansArray[i] === questionsArray[i].answer) {
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
  var percetage = (rightAnswer / 5) * 100;
  p1.innerHTML = "Right answers " + rightAnswer;
  p2.innerHTML = "Wrong answers " + wrongAnswer;
  p3.innerHTML = "Percentage " + percetage + "%";

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

window.onload = init();
