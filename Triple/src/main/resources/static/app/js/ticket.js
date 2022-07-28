function sendit(){
    const nameCheck = RegExp(/[가-힣]+$/);
    const emailCheck = RegExp(/^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/);
    const phCheck = RegExp(/^\d{3}-\d{3,4}-\d{4}$/);
    const lastname = RegExp(/[A-Za-z]/);
    const firstname = RegExp(/[A-Za-z]/);
    const birth = RegExp(/\d{4}\d{2}\d{2}/);
    const kakao = RegExp(/[a-zA-z0-9]/);
    const hotel = RegExp(/[a-zA-Z가-힣]/);


    if(!nameCheck.test($('#nameKor').val())){ 
        alert('이름 형식을 확인하세요!\n한글만 입력가능합니다');
        $('#nameKor').focus();
        return false 
    }

    if(!emailCheck.test($('#bookerEmail').val())){
        alert('이메일을 형식에 맞게 입력하세요');
        $('#bookerEmail').val('');
        $('#bookerEmail').focus();
        return false
    }

    if(!phCheck.test($('#bookerPhone').val())){
        alert('휴대폰번호 형식을 확인하세요');
        $('#bookerPhone').focus();
        return false;
    }
    if(!phCheck.test($('#reservationPhone').val())){
        alert('휴대폰번호 형식을 확인하세요');
        $('#reservationPhone').focus();
        return false;
    }
    if(!lastname.test($('#engLastname').val())){
        alert('영문 성을 입력해주세요');
        $('#engLastname').val('');
        $('#engLastname').focus();
        return false
    }
    if(!firstname.test($('#engFirstname').val())){
        alert('영문이름을 입력해주세요');
        $('#engFirstname').val('');
        $('#engFirstname').focus();
        return false
    }
    if(!birth.test($('#rBirth').val())){
        alert('생년월일을 형식에 맞게 입력하세요');
        $('#rBirth').val('');
        $('#rBirth').focus();
        return false
    }
    if(!kakao.test($('#kakao').val())){
        alert('카카오톡 아이디를 입력해주세요');
        $('#kakao').val('');
        $('#kakao').focus();
        return false
    }

    if(!hotel.test($('#hotel').val())){
        alert('호텔이름을 입력해주세요');
        $('#hotel').val('');
        $('#hotel').focus();
        return false
    }
    if(!lastname.test($('#traveler-eng-lastname').val())){
        alert('영문성을 입력해주세요');
        $('#traveler-eng-lastname').val('');
        $('#traveler-eng-lastname').focus();
        return false
    }

    if(!firstname.test($('#traveler-eng-firstname').val())){
        alert('영문이름을 입력해주세요');
        $('#traveler-eng-firstname').val('');
        $('#traveler-eng-firstname').focus();
        return false
    }
    let notice = false
    for(let i=0; i<$("input:checkbox[name='agree']").length; i++){
        if($("input:checkbox[name='agree']").eq(i).is(":checked")==true){
            notice = true
            break
        }
        if(!notice){
            alert('이용규정 및 개인정보 동의서를 모두 읽고 체크해주세요')
            return false
        }
    }

}

