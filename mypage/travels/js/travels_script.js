function next_btn(){
    const title = document.getElementById('travels_tit');
    const content= document.getElementById('traverls_cont');

    if(title.value==''){
        alert('제목을 입력해주세요');
        title.focus();
        return false;
    }else if(content.value==''){
        alert('내용을 입력해 주세요');
        content.focus();
        return false;
    }
    alert('등록되었습니다');
    document.location.href="travels_done.html";
    return true;
}
