$(function (){

    $(document).on('click', '#sendit', function () {
        const idCheck = RegExp(/[a-zA-Z0-9]{6,20}$/);
        const pwCheck = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
        const nameCheck = RegExp(/^[가-힣]+$/);
        const hpCheck = RegExp(/^\d{3}-\d{3,4}-\d{4}$/);
        const emailCheck = RegExp(/^[a-zA-Z0-9\.\-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z0-9]+/);

        if (!nameCheck.test($('#nickname').val())) {
            alert('닉네임은 한글로 입력하세요');
            $('#nickname').val('');
            $('#nickname').focus();
            return false;
        }

        if (!pwCheck.test($('#userpw').val())) {
            alert('비밀번호를 형식에 맞게 입력하세요');
            $('#userpw').val('');
            $('#userpw').focus();
            return false;
        }

        if ($('#userpw').val() != $('#userpw_re').val()) {
            alert('비밀번호가 서로 다릅니다');
            $('#userpw').val('');
            $('#userpw_re').val('');
            $('#userpw').focus();
            return false;
        }


        if (!hpCheck.test($('#hp').val())) {
            alert('휴대폰 형식에 맞게 입력하세요(010-0000-0000)');
            $('#hp').val('');
            $('#hp').focus();
            return false;
        }

        if (!idCheck.test($('#userid').val())) {
            alert('아이디를 형식에 맞게 입력하세요');
            $('#userid').val('');
            $('#userid').focus();
            return false;
        }

        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                idx: $('#idx').val(),
                nickname: $('#nickname').val(),
                userpw: $('#userpw').val(),
                hp: $('#hp').val(),
                zipcode: $('#sample6_postcode').val(),
                address1: $('#sample6_address').val(),
                address2: $('#sample6_detailAddress').val(),
                address3: $('#sample6_extraAddress').val(),
                tossAgree: 'Y'
            }
        }

        $.ajax({
            url: '/api/user',
            type: 'PUT',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('수정성공!');
                sessionStorage.setItem('nickname', $('#nickname').val())
                sessionStorage.setItem('userpw', $('#userpw').val())
                location.href = '/Triple/mypage/settings';
            },
            error: function () {
                alert('수정실패!');
                location.reload();
            }
        })

    })

})



