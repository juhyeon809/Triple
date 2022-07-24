function sendit(){
    const idCheck = RegExp(/[a-zA-Z0-9]{6,20}$/);
    const pwCheck = RegExp(/[a-zA-Z0-9]{6,20}$/);
    const nameCheck = RegExp(/^[가-힣]+$/);
    const hpCheck = RegExp(/^\d{3}-\d{3,4}-\d{4}$/);
    const emailCheck = RegExp(/^[a-zA-Z0-9\.\-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z0-9]+/);

    if(!nameCheck.test($('#name').val())){
        alert('이름은 한글로 입력하세요');
        $('#name').val('');
        $('#name').focus();
        return false;
    }

    if(!pwCheck.test($('#userpw').val())){
        alert('비밀번호를 형식에 맞게 입력하세요');
        $('#userpw').val('');
        $('#userpw').focus();
        return false;
    }

    if($('#userpw').val() != $('#userpw_re').val()){
        alert('비밀번호가 서로 다릅니다');
        $('#userpw').val('');
        $('#userpw_re').val('');
        $('#userpw').focus();
        return false;
    }

    
    
    if(!hpCheck.test($('#hp').val())){
        alert('휴대폰 형식에 맞게 입력하세요(010-0000-0000)');
        $('#hp').val('');
        $('#hp').focus();
        return false;
    }

    if(!idCheck.test($('#userid').val())){
        alert('아이디를 형식에 맞게 입력하세요');
        $('#userid').val('');
        $('#userid').focus();
        return false;
    }


    return true;
}
