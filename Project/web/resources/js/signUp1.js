
$(function () {
    $('#uname').blur=myFunc;
    function myFunc() {
        var newUserName = $('#uname').val();
        var customer={userName:newUserName};
        $.post('signUpServlet',{customer:JSON.stringify(customer)},dataProcess,"json")

    }
    function dataProcess(data) {
        var note= $('<p>').text(data.userName+"user Name is not available");
        $('#space').append(note);
    }

});