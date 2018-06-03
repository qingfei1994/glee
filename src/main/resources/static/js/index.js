$().ready(function(){

    $("form[name=indexForm]").submit(function(event){
        var username = $("input[name='username']").val();
        if(isBlank(username)) {
            showAlert("username should not be empty");
            event.preventDefault();
        }

    });

});