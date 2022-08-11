$(function () {
    //회원등록 정규식
    const expUserid = RegExp(/[a-zA-Z0-9]/);
    const expUserpw = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
    const expName = RegExp(/[가-힣]/);
    const expHp = RegExp(/^\d{3}-\d{3,4}-\d{4}$/);
    const expEmail = RegExp(/^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/);

    $(document).on('click', '#idCheck', function () {

        let userid = $('#userid').val();


        if(userid.value == ''){
            alert('아이디를 입력하세요')
            userid.focus();
            return false;
        }
        if(!expUserid.test(userid.value)){
            alert('아이디를 다시 확인해주세요');
            id.focus();
            return false;
        }

        $.ajax({

            url: '/api/admin/adminIdCheck',
            type: 'post',
            data: {userid : userid},
            success:function(cnt){
                console.log("중복검사 진행");
                if(cnt != 1){
                    alert("사용가능한 아이디입니다.")
                    $('#userid').attr("check_result","success");
                }else{
                    alert("중복된 아이디입니다.")
                    $('#userid').attr("check_result","fail");
                    return false;
                }
            },
            error:function(){
                console.log("검사실패");
                alert("중복된 아이디이거나 형식이 맞지 않습니다. 다시 입력해주세요.");
            }

        });
    });

    $(document).on('click', '#sendit', function (){
        const userid = document.getElementById('userid');
        const regform = document.getElementsByName('regform');
        const userpw = document.getElementById('userpw');
        const userpw_re = document.getElementById('userpw_re');
        const email = document.getElementById('email');
        const name = document.getElementById('name');
        const hp = document.getElementById('hp');

        if(userid.value == ''){
            alert('아이디를 입력하세요')
            userid.focus();
            return false;
        }

        if(name.value == ''){
            alert('이름을 입력하세요')
            name.focus();
            return false;
        }
        if(!expName.test(name.value)){
            alert('이름을 다시 확인해주세요');
            name.focus();
            return false
        }
        if(hp.value == ''){
            alert('연락처를 입력하세요')
            hp.focus();
            return false;
        }
        if(!expHp.test(hp.value)){
            alert('연락처를 다시 확인해주세요');
            hp.focus();
            return false;
        }

        if(email.value == ''){
            alert('이메일을 입력하세요')
            email.focus();
            return false;
        }

        if(!expEmail.test(email.value)){
            alert('이메일을 다시 확인해주세요');
            email.focus();
            return false;
        }

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
        if(userpw.value != userpw_re.value){
            alert('비밀번호가 맞지 않습니다. 다시 확인해주세요');
            userpw_re.focus();
            return false;
        }

        if(!$('#department option:selected').val()){
            alert("부서를 선택해주세요");
            regform.department.focus();
            return false;
        }


        if(!$('#position option:selected').val()) {
            alert("직함을 선택해주세요");
            regform.position.focus();
            return false;
        }

        if($('#userid').attr("check_result") == "fail"){
            alert('아이디 중복확인을 해주세요');
            userid.focus();
            return false;
        }


        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                userid: $('#userid').val(),
                name: $('#name').val(),
                hp: $('#hp').val(),
                email: $('#email').val(),
                userpw: $('#userpw').val(),
                department: $('#department option:selected').val(),
                position: $('#position option:selected').val()
            }
        }

        $.post({
            url: '/api/admin',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('등록되었습니다.');
                location.href = "/Triple/adminList";
            },
            error: function () {
                alert('등록실패 (확인요망)');
                location.reload();
            }

        });


    });
});