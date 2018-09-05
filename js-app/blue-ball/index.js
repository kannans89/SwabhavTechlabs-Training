var buttonArray;
var random1;
var numberOfBalls;
var attempts;

function init(){
    buttonArray = []    
    random1 = 0;
    numberOfBalls = 80;
    attempts = 5;
    generateButtons();
}

function generateButtons() {
    var buttons = document.querySelector('.blue-balls');
    for (var i = 0; i < numberOfBalls; i++) {
        createButtonElement(buttons, i)
    }
    assignColors(buttons);
    document.querySelector('.start-game').disabled = true;
}

function createButtonElement(buttons, i) {
    var button = document.createElement("button");
    button.setAttribute('value', i);
    button.className = 'button';
    button.setAttribute('id', i);
    button.addEventListener('click', checkLeftAndRight);
    buttons.appendChild(button);
}

function assignColors(buttons) {
    random1 = Math.floor((Math.random() * numberOfBalls) + 1);
    console.log(random1);

    var childNodes = buttons.childNodes;
    for (var j = 0; j < random1; j++) {
        buttonArray.push({
            id: childNodes[j].value,
            color: '#D32F2F'
        });
    }

    buttonArray.push({
        id: childNodes[random1].value,
        color: '#283593'
    })

    for (var k = random1 + 1; k < numberOfBalls; k++) {
        buttonArray.push({
            id: childNodes[k].value,
            color: '#1B5E20'
        });
    }
}


function displayBackGroundColor(buttonValue){
    if(buttonValue<random1){
        document.getElementById(buttonValue).style.backgroundColor = '#D32F2F';
    }else{
        document.getElementById(buttonValue).style.backgroundColor = '#1B5E20';
    }
}

function displayAttempts(attempts){
    var attemptNode = document.getElementById('attempt');
    if(attempts>=0){
        attemptNode.innerHTML = '<h2>Attempt '+attempts+"";
    } else{
        attemptNode.innerHTML = '<h2>Attempt 0';
    }   
}

function checkLeftAndRight(e) {
    var buttonValue = e.target.value;
    attempts = attempts-1;
    displayAttempts(attempts);
    
    if(e.target.value !== numberOfBalls && attempts>=0){

        if (buttonArray[buttonValue].color === '#283593') {
            document.getElementById(buttonValue).style.backgroundColor = '#283593';
            console.log('Winner');
        } else {
            displayBackGroundColor(buttonValue);
        }
    } else{
        console.log("ooops...sorry you run out of attempts")
    }
}