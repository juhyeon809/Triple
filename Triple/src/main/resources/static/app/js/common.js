

$(function() {
    $(document)
    {
        console.log(sessionStorage.length);
        if (sessionStorage.getItem("email") == null) {
            $('#login_join').show();
            $('#logout_mypage').hide();
        } else {
            $('#login_join').hide();
            $('#logout_mypage').show();
        }
    }
});

