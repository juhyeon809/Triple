$(function(){
    const expUserpw = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);

    $("#delete").click(() => {
        const userpw = document.getElementById('userpw');
        const userpw_re = document.getElementById('userpw_re');

        if(userpw.value == ''){
            alert('비밀번호를 입력하세요')
            userpw.focus();
            return false;
        }
        if(!expUserpw.test(userpw.value)){
            alert('비밀번호 형식을 확인해주세요');
            userpw.focus();
            return false;
        }
        if(userpw_re.value == ''){
            alert('비밀번호 확인을 입력하세요')
            userpw_re.focus();
            return false;
        }
        if(userpw.value != userpw_re.value){
            alert('비밀번호가 맞지 않습니다. 다시 확인해주세요');
            userpw_re.focus();
            return false;
        }
        $.ajax({
            url: '/api/admin',
            method: "DELETE",
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function(){
                alert('삭제했습니다');
                location.href= '/Triple/adminList';
            },
            error: function(){
                alert('삭제실패 (확인요망)');
                location.reload();
            }
        })
    })

});