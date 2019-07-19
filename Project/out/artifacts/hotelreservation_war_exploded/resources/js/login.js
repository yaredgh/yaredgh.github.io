"use strict"
window.onload = function () {
    document.getElementById("btn").onclick = loginFunction;
};

function loginFunction() {
    var u = $("#userName").val();
    var p = $("#password").val();
    var userObj = {userName:u, password:p};
    $.post('firstLogin', {user:JSON.stringify(userObj)}, myFunction, "json");
}

function myFunction(data) {
    if(data == "success"){
        $("#submitBtn").click();
    }else{
        var msgDiv = document.getElementById("warn");
        msgDiv.innerHTML = data;
        msgDiv.style.display = "block";
    }
}