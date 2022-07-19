/*리뷰 글쓰기*/
function redone(){
    const redone= document.getElementById('review_cont');

    if(redone.value==''){
        alert('리뷰를 작성해주세요');
        commend.val();
        commend.focus();
        return false;
    }
    alert('등록되었습니다');
    document.location.href="review_done.html";
    return true;
}
function filechoice(){
    oncilk=document.all.file.click();
}


/* 리뷰 글 보기*/
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

