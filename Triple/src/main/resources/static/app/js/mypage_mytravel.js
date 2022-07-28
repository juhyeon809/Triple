function sendit(){
        const rename = document.getElementById('rename');
        const expreName=( /^[가-힣a-zA-Z0-9/_/\s]+$/);
        if(!expreName.test(rename.value)){
                alert('이름을 형식에 맞게 입력해주세요');
                rename.focus();
                return false;
        }
        document.location.href="my_travel_main.html";
        alert('수정되었습니다');
        return true;
}
