function airline(){
    const kor = RegExp(/[가-힣]+$/);
    const eng = RegExp(/[a-zA-Z]/);

    if(!kor.test($('.kor').val())){
        alert('한글만 입력해주세요');
        $('.kor').focus();
        return false
    }
    if(!eng.test($('.eng').val())){
        alert('영어만 입력해주세요');
        $('.eng').focus();
        return false
    }
    return true;
}

function destination(){
    const airport = RegExp(/[a-zA-Z가-힣]/);
    const code = RegExp(/[a-zA-Z]/);

        if(!airport.test($('.name').val())){
            alert('공항명을 입력해주세요')
        $('.name').focus();
        return false;
        }
        if(!code.test($('.code').val())){
            alert('공항코드을 입력해주세요')
        $('.code  ').focus();
        return false;
        }
    return true;
}

function aircraft(){
    const name = RegExp(/[a-zA-Z가-힣]/);
    const seatNum = RegExp( /^[0-9]+$/)

    if(!$('#airlineName option:selected').val()) {
        alert("항공사명을 선택해주세요");
        return false
    }
    if(!name.test($('.name').val())){
        alert('항공기명을 입력해주세요')
        $('.name').focus();
        return false
    }
    if(!$('#comp option:selected').val()) {
        alert("제조회사를 선택해주세요");
        return false
    }
    if(!seatNum.test($('.vip').val())){
        alert('vip좌석 수를 입력해주세요')
        $('.vip').focus();
        return false
    }
    if(!seatNum.test($('.family').val())){
        alert('패밀리좌석 수를 입력해주세요')
        $('.family').focus();
        return false
    }
    if(!seatNum.test($('.special').val())){
        alert('특가좌석 수를 입력해주세요')
        $('.special').focus();
        return false
    }
    if(!seatNum.test($('.premium').val())){
        alert('프리미엄좌석 수를 입력해주세요')
        $('.premium').focus();
        return false
    }
    if(!seatNum.test($('.economy').val())){
        alert('일반좌석 수를 입력해주세요')
        $('.economy').focus();
        return false
    }
    if(!seatNum.test($('.total').val())){
        alert('총 좌석 수를 입력해주세요')
        $('.total').focus();
        return false
    }
    return true;
}