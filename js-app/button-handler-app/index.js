(function(){
    var red = document.querySelector('.redButton');
    var green = document.querySelector('.greenButton');

    red.addEventListener('click', changeColor);
    green.addEventListener('click', changeColor);

    function changeColor(event){
        console.log(event.target.value)
        document.body.className = event.target.value;
    }
})();