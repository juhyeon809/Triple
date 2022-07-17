function sendit(){          
    //순서대로 스크립트 작성할것!!
    const nameCheck = RegExp(/[가-힣]+$/);
    const phCheck = RegExp(/^\d{3}\d{3,4}\d{4}$/);
    const emailCheck = RegExp(/^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/);
    const EmergencyPh = RegExp(/^\d{2,3}\d{3,4}\d{4}$/);
    const lastname = RegExp(/[A-Za-z]/);
    const firstname = RegExp(/[A-Za-z]/);
    const birth = RegExp(/\d{4}\d{2}\d{2}/);
    // const gender = document.getElementById('gender');
    const ph_choice = RegExp(/^\d{2,3}\d{3,4}\d{4}$/);
    const passportNum = RegExp(/[a-zA-Z]{1}[0-9a-zA-Z]{1}[0-9]{7}/);
    const passportDate =  RegExp(/\d{4}\d{2}\d{2}/);


    // const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/;
    // const expFirstName = /[A-Za-z]/;
    // const expLastName = /[A-Za-z]/;

    if(!nameCheck.test($('#name').val())){ 
        alert('이름 형식을 확인하세요!\n한글만 입력가능합니다');
        $('#name').focus();
        return false 
    }

    if(!phCheck.test($('#ph').val())){
        alert('휴대폰번호 형식을 확인하세요');
        $('#ph').focus();
        return false;
    }

    if(!emailCheck.test($('#email').val())){
        alert('이메일을 형식에 맞게 입력하세요');
        $('#email').val('');
        $('#email').focus();
        return false
    }
    if(!EmergencyPh.test($('#ph2').val())){
        alert('비상연락처를 형식에 맞게 입력하세요');
        $('#ph2').val('');
        $('#ph2').focus();
        return false
    }
    if($('#ph').val() == $('#ph2').val()){
        alert('비상연락처는 다른 번호로 입력해주세요')
        $('#ph2').focus()

        return false
    }
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
    

    if(!birth.test($('#birth').val())){
        alert('생년월일을 형식에 맞게 입력하세요');
        $('#birth').val('');
        $('#birth').focus();
        return false
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

    return true;
}

function card(){
    //https://www.habonyphp.com/2021/02/credit-card.html
    //BC, Visa, MasterCard, Discover, Amex, Diners Club, JCB 에 해당하는 카드
    // ^(?:(94[0-9]{14})|(4[0-9]{12}(?:[0-9]{3})?)|(5[1-5][0-9]{14})|(6(?:011|5[0-9]{2})[0-9]{12})|(3[47][0-9]{13})|(3(?:0[0-5]|[68][0-9])[0-9]{11})|((?:2131|1800|35[0-9]{3})[0-9]{11}))$

    //Visa, MasterCard, Discover, Amex, Diners Club/Carte Blanche 에 해당하는 카드
    //    ^(?:(?<Visa>4\d{3})|(?<Mastercard>5[1-5]\d{2})|(?<Discover>6011)|(?<DinersClub>(?:3[68]\d{2})|(?:30[0-5]\d))|(?<AmericanExpress>3[47]\d{2}))([ -]?)(?(DinersClub)(?:\d{6}\1\d{4})|(?(AmericanExpress)(?:\d{6}\1\d{5})|(?:\d{4}\1\d{4}\1\d{4})))$
    const master = RegExp(/^([51|52|53|54|55]{2})([0-9]{14})$/);

    if(!master.test($('#cardNum').val())){
        alert('영문 성을 입력해주세요');
        $('#cardnum').val('');
        $('#cardnum').focus();
        return false
    }
    return true;
}