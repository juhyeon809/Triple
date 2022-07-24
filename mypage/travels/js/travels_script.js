
function chkbox(){
    const lbox= document.getElementById('chkbox');

    if(lbox.checked==0){
        alert('여행을 선택해주세요');
        return false;
    }
    document.location.href="travels_write2.html";
    return true;
}

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


function filechoice(){
    oncilk=document.all.file.click();
}


/* 여행기 글 보기*/
function openList(){
    if(document.getElementById('more_btn').style.display=='block'){
        document.getElementById('more_btn').style.display='none';
        document.getElementById('more').textContent='더보기';
    }else{
        document.getElementById('more_btn').style.display='block';
        document.getElementById('more').textContent='더보기';
    }
}
/*공유*/
function share_btn(){
    const share_btn=document.getElementById('share_btn');
    if(share_btn.click){
        alert('링크가 복사되었습니다');
    }
}
/*삭제 */
function delete_btn(){
    const de_btn=document.getElementById('delete_btn');

    if(de_btn.click){
        alert('삭제되었습니다');
    }
}

/*댓글입력*/ 
function resendit(){
    const commend = document.getElementById('commend');

    if(commend.value==''){
        alert('댓글을 입력해주세요');
        commend.focus();
        return false;
    }
    alert('등록되었습니다');
    return true;
}

