function isBlank(string) {
    if(string.replace(/(^\s*)|(\s*$)/g,"").length==0) {
        return true;
    }
    return false;
}
function refresh(url,timeout) {
    if(timeout>0) {
        setTimeout(function(){window.location.assign(url)},timeout);
    } else {
        window.location.assign(url);
    }
}
function showAlert(message) {
    $('.toast').html(message);
    $('.toast').addClass("show");
    setTimeout(function(){$('.toast').removeClass("show");},3000)
}

function follow(friendId) {
    $.post("/follow/save",{
        "followIdentity.followerId":userId,
        "followIdentity.friendId":friendId

    },function(data,status){
        if(data.success==0) {
            showAlert("You have successfully followed a friend.")
            refresh(window.location.href,3000);
        } else {
            showAlert("Something went wrong,please try again");
        }

    })

}