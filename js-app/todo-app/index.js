let names = [];

var div = document.getElementById("ui");
var ul = document.createElement("ul");
div.innerHTML = '<br />Data from text field';
div.appendChild(ul);
ul.style.listStyleType = 'none';

window.onload = init();

function init(){   
    if(localStorage.getItem("name")){
        names = JSON.parse(localStorage.getItem("name"));
    }
    showNamesFromLocalStorage(names);
}

function saveName(e){
    e.preventDefault();

    var name = document.getElementById("text").value;
    console.log("inside script "+name);
    displayName(name);
    names.push({
        name: name,
        date: getDate()
    });
    showNamesFromLocalStorage(names);
    storeName(names);
}

function getDate(){
    var newDate = new Date();
    var year = newDate.getFullYear();
    var date = newDate.getDate();
    var month = newDate.getMonth();
    var hours = newDate.getHours();
    var minutes = newDate.getMinutes();
    var seconds = newDate.getSeconds();
    var element = name+" "+date+"/"+month+"/"+year+" "+hours+":"+minutes+":"+seconds;
    return element;
}

function displayName(name){
    var li = document.createElement("li");
    ul.appendChild(li);  
    li.innerHTML = name+getDate();
}

function storeName(names){
    localStorage.setItem("name", JSON.stringify(names));
    console.log(names)
}

function retrieveNames(){
    return JSON.parse(localStorage.getItem("name"));
}

function showNamesFromLocalStorage(names){
    var div = document.getElementById("localStorage");
    div.innerHTML = '<br />Data from Local storage';
    var ul = document.createElement("ul");
    div.appendChild(ul);

   
    names.forEach(element => {
        console.log(element);
        var li = document.createElement("li");
        var button = document.createElement("button");
        button.addEventListener('click', confirmSelection);
        button.innerHTML = 'x'
        button.setAttribute("id", element.date)
        button.style.marginLeft = '25px';
        button.style.color="red";
        ul.appendChild(li);
        li.innerHTML = element.name+"  "+element.date;
        li.appendChild(button);
    });
   
}

function confirmSelection(e){
    e.preventDefault();
   if(confirm("really want to delete?")){
       removeItem(e);
       console.log("deleted")
   }
   console.log("not deleted");
}

function removeItem(e){
        var objects = [];

        var dateID = e.target.getAttribute("id");
        console.log("date ID"+dateID);
    
        names = retrieveNames();
        const updatedNames = names.filter(element => {
            if(element.date !== dateID){
                console.log("Element "+element.date)
                return true;
            }
        });
        storeName(updatedNames);
        e.target.parentElement.style.display = 'none';
}

