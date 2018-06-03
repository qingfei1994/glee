$().ready(function(){
    $('.btn-post').click(function(){
        var message=$("textarea[name='message']").val();
        if(message.length>140) {
            showAlert("You can not post more than 140 characters.");
        } else if(isBlank(message)) {
            showAlert("Message should not be empty.")
        } else {
            $("textarea[name='message']").val("");
            $.post("/message/save",{
                "userId":userId,
                "content":message,
                "username":username
            },function(data,status){
                if(data.success==0) {
                    showAlert("Your message has been post successfully.")
                    refresh(window.location.href,3000);
                } else {
                    showAlert("Something went wrong.Please try again.")
                }
            })
        }
    });

});