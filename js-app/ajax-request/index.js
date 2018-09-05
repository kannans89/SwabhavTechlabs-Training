function makeRequest(e) {
    var http = new XMLHttpRequest();
    http.onreadystatechange = () => {
        if (http.readyState == 4 && http.status == 200) {
            console.log(http.responseText);
            document.getElementById('frame').setAttribute("src", "http://swabhavtechlabs.com/");
            document.getElementById('button').disabled = false;
        } else if (http.readyState === 3) {
            document.getElementById('button').disabled = true;
        }
    }
    http.open("get", "https://cors-anywhere.herokuapp.com/https://swabhav-tech.firebaseapp.com/emp.txt", true);
    http.send();
}