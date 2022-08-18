'use strict'

function sendit(){

    const name = document.getElementById('name');
    const hp = document.getElementById('hp');
    const email = document.getElementById('email');
    const lastName = document.getElementById('lastName');
    const firstName = document.getElementById('firstName');
    const birth = document.getElementById('birth');
    const gender = document.getElementsByName('box');



    const expNameText = /^[가-힣|a-z|A-Z|]+$/;
    const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
    const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/;
    const expLastNameText = /^[가-힣|a-z|A-Z|]+$/;
    const expFirstNameText = /^[가-힣|a-z|A-Z|]+$/;
    const expBirthText = /^[0-9]{8}/;


    if(name.value == ''){
        alert('이름을 입력해주세요');
        name.focus();
        return false;
    }

    if(!expNameText.test(name.value)){
        alert('이름은 한글 또는 영어로 입력해주세요')
        name.focus();
        return false;
    }

    if(hp.value == ''){
        alert('휴대전화번호를 입력해주세요');
        hp.focus();
        return false;
    }

    if(!expHpText.test(hp.value)){
        alert('휴대전화번호 형식을 확인해주세요\n하이픈(-)을 포함해야 합니다');
        hp.focus();
        return false;
    }

    if(email.value == ''){
        alert('이메일을 입력해주세요');
        email.focus();
        return false;
    }

    if(!expEmailText.test(email.value)){
        alert('이메일 형식을 확인해주세요')
        email.focus();
        return false;
    }

    if(lastName.value == ''){
        alert('대표 투숙자 성을 입력해주세요');
        lastName.focus();
        return false;
    }

    if(!expLastNameText.test(lastName.value)){
        alert('성은 한글 또는 영어로 입력해주세요');
        lastName.focus();
        return false;
    }

    if(firstName.value == ''){
        alert('대표 투숙자 이름을 입력해주세요');
        firstName.focus();
        return false;
    }

    if(!expFirstNameText.test(firstName.value)){
        alert('이름은 한글 또는 영어로 입력해주세요');
        firstName.focus();
        return false;
    }

    if(birth.value == ''){
        alert('생년월일을 입력해주세요');
        birth.focus();
        return false;
    }

    if(!expBirthText.test(birth.value)){
        alert('생년월일을 8자리로 입력해주세요')
        birth.focus();
        return false;
    }

    let count = 0;

    for(let i in gender){
        if(gender[i].checked){
            count++;
        }
    }

    if(count === 0){
        alert('성별을 선택해주세요');
        return false;
    }

    return true;
}

function oneClick(chk){
    const gender = document.getElementsByName("box");
    gender.forEach((cb) => {
        cb.checked = false;
    })

    chk.checked = true;
}

