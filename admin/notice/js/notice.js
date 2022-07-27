function notice(){
    const notice= document.getElementById('no_list');
    const title=document.getElementById('title');


    if(notice.value==''){
        alert('분류를 선택해주세요');
        return false;
    }
    if(title.value==''){
        alert('타이틀명을 입력해주세요');
        return false;
    }
    return true;
}
