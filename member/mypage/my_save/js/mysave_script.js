/*메모나타내기*/ 
function memo_box(){
    if(document.getElementById('memo_box').style.display=='block'){
        document.getElementById('memo_box').style.display='none';
    }else{
        document.getElementById('memo_box').style.display='block';
    }
}
function rememo_box(){
    if(document.getElementById('rememo_box').style.display=='block'){
        document.getElementById('rememo_box').style.display='none';
    }else{
        document.getElementById('rememo_box').style.display='block';
    }
}


/*메모수정삭제*/ 
function memobtn2(){
    const memobtn2=document.getElementById('mbtn');
    if(memobtn2.click){
        alert('수정되었습니다');
    }
    
}

function memobtn3(){
    const memobtn3=document.getElementById('mbtn2');
    if(memobtn3.click){
        alert('삭제하시겠습니까?');
        alert('삭제되었습니다');
    }
}

