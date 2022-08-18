

function sendit(){
    //순서대로 스크립트 작성할것!!
    const nameCheck = RegExp(/[가-힣]+$/);
    const phCheck = RegExp(/^\d{3}\d{3,4}\d{4}$/);
    const emailCheck = RegExp(/^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/);
    const EmergencyPh = RegExp(/^\d{2,3}\d{3,4}\d{4}$/);
    const lastname = RegExp(/[A-Za-z]/);
    const firstname = RegExp(/[A-Za-z]/);
    const birth = RegExp(/^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/);
    const ph_choice = RegExp(/^\d{2,3}\d{3,4}\d{4}$/);
    const passportNum = RegExp(/[a-zA-Z]{1}[0-9a-zA-Z]{2}[0-9]{7}/);
    const passportNum1 = RegExp(/[a-zA-Z]{1}|[a-zA-Z]{2}\d{8}/);
    const passportDate =  RegExp(/\d{4}\d{2}\d{2}/);






    if(!lastname.test($('#lastname').val())){
        alert('영문 성을 입력해주세요');
        $('#lastname').val('');
        $('#lastname').focus();
        return false
    }
    if(!firstname.test($('#firstname').val())){
        alert('영문이름을 입력해주세요');
        $('#firstname').val('');
        $('#firstname').focus();
        return false
    }
    if(!nameCheck.test($('#name').val())){
        alert('이름 형식을 확인하세요!\n한글만 입력가능합니다');
        $('#name').focus();
        return false
    }


    if(!birth.test($('#birth').val())){
        alert('생년월일을 형식에 맞게 입력하세요');
        $('#birth').val('');
        $('#birth').focus();
        return false
    }
    let gender = false
    for(let i=0; i<$("input:checkbox[name='gender']").length; i++){
        if($("input:checkbox[name='gender']").eq(1).is(":checked")==true){
            gender = true
            break
        }
        if(!gender){
            alert('성별을 체크해주세요')
            return false
        }
    }
    //국적
    
    if(!$('#nationality option:selected').val()) {
        alert("국적을 선택해주세요");
    }

    
    if(!passportNum1.test($('#passportNum').val())){
        alert('여권번호를 다시 확인해주세요');
        $('#passportNum').val('');
        $('#passportNum').focus();
        return false
    }

    //여권만료일
    if(!passportDate.test($('#passportDate').val())){
        alert('여권 만료일을 다시 확인해주세요');
        $('#passportDate').val('');
        $('#passportDate').focus();
        return false
    }
    

    //여권 발행국
    if(!$('#passportCountry > option:selected').val()) {
        alert("여권 발행국을 선택해주세요");
    }

    let notice = false
    for(let i=0; i<$("input:checkbox[name='check']").length; i++){
        if($("input:checkbox[name='check']").eq(i).is(":checked")==true){
            notice = true
            break
        }
        if(!notice){
            alert('운임규정을 읽고 체크해주세요')
            return false
        }
    }


}

function credit() {

    const master = RegExp(/^([51|52|53|54|55]{2})([0-9]{14})$/);
    const cardDate = RegExp(/^((0[1-9])|(1[0-2]))\/(\d{2})$/);
    const cardPw = RegExp(/[d{2}]/);
    const Birth = RegExp(/^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/);

    if (!master.test($('#cardNum').val())) {
        alert('카드 번호를 확인해주세요');
        $('cardNum').val('');
        $('#cardNum').focus();
        return false
    }
    if (!cardDate.test($('#cardDate').val())) {
        alert('카드 유효기간을 확인해주세요');
        $('#cardDate').val('');
        $('#cardDate').focus();
        return false
    }
    if (!cardPw.test($('#cardPw').val())) {
        alert('카드 비밀번호 앞자리를 확인해주세요');
        $('#cardPw').val('');
        $('#cardPw').focus();
        return false
    }
    if (!Birth.test($('#cardBirth').val())) {
        alert('카드 소유주의 생년월일을 확인해주세요');
        $('#cardBirth').val('');
        $('#cardBirth').focus();
        return false
    }

    if ($('#check1').is(":checked") == false) {
        alert('결제규정을 읽고 체크해주세요');
    }



    return true;
}