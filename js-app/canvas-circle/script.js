function draw(){
    var canvas = document.getElementById('circleCanvas');
    var context = document.getElementById('circleCanvas').getContext('2d');
    var centerX = canvas.width/2;
    var centerY = canvas.height/2;
        context.beginPath();
        context.lineWidth = 1;
        context.fillStyle = 'red';
        context.arc(centerX, centerY,70, 0,270, false);
        context.closePath();
        context.fill();      

        context.beginPath();
        context.moveTo(centerX, centerY);
        context.lineTo(centerX+70, centerY);
        context.closePath();

        context.beginPath();
        context.moveTo(centerX, centerY);
        context.lineTo(centerX, centerY-70);
        context.closePath();

        context.arc(centerX, centerY, 70, 270, 360, true);
        context.closePath();
        context.fillStyle = 'black';
        context.fill();
        context.strokeStyle = '#440000';

}

window.onload = draw();