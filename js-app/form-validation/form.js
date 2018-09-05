var checkEmail = function(e){
    var email = document.getElementById('form');
    console.log("inside checkemail")
    email.addEventListener("input", function(event){
        if(email.validity.typeMismatch){
            email.setCustomValidity("I expect an email with @ and .")
        } else{
            email.setCustomValidity("")
        }
    })
}