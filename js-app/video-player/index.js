var video = document.querySelector('.video');
var juice = document.querySelector('.orange-juice');
var button = document.getElementById('play-pause');

function togglePlayButton(){
    if(video.paused){
        button.className = 'pause';
        video.play();
    } else{
        button.className = 'play';
        video.pause();
    }
}

button.onclick = function() {
    togglePlayButton();
}

video.addEventListener('timeupdate', function(){
    var position = video.currentTime/video.duration;
    juice.style.width = position*100+"%";
})