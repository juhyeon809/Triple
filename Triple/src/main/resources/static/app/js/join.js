console.log("join.js 작동중");

//약관동의 체크박스 전체 선택
$(".checkbox_group").on("click", "#check_all", function(){
    $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
});

//약관동의 체크박스 개별 선택
$(".checkbox_group").on("click", ".normal", function(){
    var is_checked = true;

        $(".checkbox_group .normal").each(function(){
            is_checked = is_checked && $(this).is(":checked");
        });

        $("#check_all").prop("checked", is_checked);
});

$(function(){
    $(document).on('click', '#email', function (){
        $('#email').attr("check_result","fail");
        $('#email_ok').hide();
        $('#email_duplicate').hide();
        $('#check_need').show();
        alert('이메일 중복체크를 다시 해주세요');
    })
})

$(function() {
    $(document).on('click', '#emailCheck', function () {

    let email = $('#email').val();

    $.ajax({

        url: '/api/user/emailCheck',
        type: 'post',
        data: {email : email},
        success:function (cnt){
            console.log("검사 성공");
            if(cnt != 1){
                alert("사용가능한 이메일입니다.")
                $('#email_ok').show();
                $('#email_duplicate').hide();
                $('#check_need').hide();
                $('#email').attr("check_result","success");
            }else{
                alert("중복된 이메일입니다.")
                $('#email_ok').hide();
                $('#email_duplicate').show();
                $('#check_need').hide();
                $('#email').attr("check_result","fail");
            }
        },
        error:function(){
            console.log("검사실패");
            alert("이메일을 입력해주세요")
        }

        });
    });
});

$(function() {
    $(document).on('click', '#sendit', function () {

        const email = document.getElementById('email');
        const userpw = document.getElementById('userpw');
        const userpw_re = document.getElementById('userpw_re');
        const nickname = document.getElementById('nickname');
        const hp = document.getElementById('hp');


        //정규식 표현
        const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/;
        const expPwText = /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/;
        const expNicknameText = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{2,10}$/;
        const expNameText = /[가-힣]+$/;
        const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;

        //아무것도 입력하지 않았을 때 입력 안내 문자 출력하는 함수
        if (!$('#email').val()) {
            alert('이메일을 입력하세요');
            email.focus();
            return false;
        }

        /*
            이메일 입력 양식 체크
            1. 모든 글자는 문자 또는 숫자 또는 특수문자중 - 또는 .만 허용
            2. @는 꼭 들어가야 함
            3. 형식은 문자@문자.문자 이어야 함
        */

        if (!expEmailText.test(email.value)) {
            alert('이메일 형식을 확인하세요');
            email.focus();
            return false;
        }


        /*
        비밀번호 규칙
        1. 비밀번호를 입력하지 않았다면 '비밀번호를 입력하세요' 출력
        2. 비밀번호의 길이가 4자 미만, 20자 초과라면 '비밀번호는 4자 이상, 20자 이하로 입력하세요' 출력
        3. 비밀번호와 비밀번호 확인의 값이 다르다면 '비밀번호와 비밀번호 확인의 값이 다릅니다' 출력
        */
        if (!$('#userpw').val()) {
            alert('비밀번호를 입력하세요');
            userpw.focus();
            return false;
        }
        //비밀번호 형식 불일치
        if (!expPwText.test(userpw.value)) {
            alert('비밀번호는 영문,숫자,특수문자(!@#$%^&*?_~만 허용)를 사용하여 6~16자까지, 영문은 대소문자를 구분합니다.');
            userpw.focus();
            return false;
        }
        //비밀번호와 비밀번호 확인 값 불일치
        if ($('#userpw').val() != $('#userpw_re').val()) {
            alert('비밀번호를 확인해주세요');
            userpw_re.focus();
            return false;
        }

        // 닉네임 형식 확인
        if (!expNicknameText.test(nickname.value)) {
            alert('닉네임은 한글, 영문, 숫자만 가능하며 3-10자리까지 가능합니다');
            nickname.focus();
            return false;
        }
        /*
            휴대폰 번호 입력 방식 체크
            1. 000-0000-0000 하이픈을 3자리 3~4자리 4자리 형식으로 넣어져야 함
            2. 하이픈을 제외한 모든 글자는 숫자여야 함
        */
        if (!expHpText.test(hp.value)) {
            alert('휴대폰번호 형식을 확인하세요\n하이픈(-)을 포함해야 합니다');
            hp.focus();
            return false;
        }

        if($('#email').attr("check_result") == "fail"){
            alert('이메일 중복확인을 해주세요');
            email.focus();
            return false;
        }



        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                email: $('#email').val(),
                userpw: $('#userpw').val(),
                nickname: $('#nickname').val(),
                countryCode: $('#countryCode').val(),
                hp: $('#hp').val(),
                zipcode: $('#zipcode').val(),
                address1: $('#address1').val(),
                address2: $('#address2').val(),
                address3: $('#address3').val(),
                tosAgree: 'Y'
            }
        }

        $.post({
            url: '/api/user',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('등록성공!');
                location.href = '/Triple/login';
            },
            error: function () {
                alert('등록실패!');
                location.reload();
            }

        });
    });
});




