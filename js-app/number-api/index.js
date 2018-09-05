(function () {
    var input = document.getElementById('text-box');
    var button = document.getElementById('find-fact');
    var res = document.getElementById('response');

    button.addEventListener('click', fetchFact);

    function fetchFact(event) {
        var http = new XMLHttpRequest();
        var value = input.value;

        http.onreadystatechange = (value) => {
            if (http.readyState === 4 && http.status === 200) {
                var p = document.createElement("p");
                p.innerHTML = http.responseText;
                var firstChild = res.firstChild;
                res.insertBefore(p, firstChild);
                displayColor(p);
            }
        }
        http.open("get", "http://numbersapi.com/" + value);
        http.send();
    }


    function displayColor(p) {
        console.log(input.value)
        if (input.value % 2 === 0) {
            p.style.color = 'green';
        } else if (input.value % 2 === 1) {
            p.style.color = 'red';
        }
    }
})();