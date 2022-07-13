function sendit(){
    const email = document.getElementById('email');
    const userpw = document.getElementById('userpw');

    //정규식 표현
    const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/;
    const expPwText = /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/;

    //아무것도 입력하지 않았을 때 입력 안내 문자 출력하는 함수
    if(email.value == ''){
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

    if(!expEmailText.test(email.value)){
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
    if(userpw.value == ''){
        alert('비밀번호를 입력하세요');
        userpw.focus();
        return false;
    }
    //비밀번호 형식 불일치
    if(!expPwText.test(userpw.value)){
        alert('비밀번호는 영문,숫자,특수문자(!@#$%^&*?_~만 허용)를 사용하여 6~16자까지, 영문은 대소문자를 구분합니다.');
        userpw.focus();
        return false;
    }
    return true;
}