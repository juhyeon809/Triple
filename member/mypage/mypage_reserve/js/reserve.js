function cancel1(){
    let rtn;

    rtn = confirm("예약을 취소하시겠습니까?");

    if(rtn){
        alert('예약이 취소되었습니다');
    } else {
        
    }
}

function cancel2(){
    let rtn;

    rtn = confirm("예약을 취소하시겠습니까?");

    if(rtn){
        alert('예약이 취소되었습니다');
    } else {
        
    }
}


function sendit(){
    const category = document.getElementById('category');
    const title = document.getElementById('title');
    const box = document.getElementsByName('box');



    const expCategoryText = /[항공|숙소|투어티켓|]/;


    if(category.value == ''){
        alert('카테고리를 입력해주세요');
        category.focus();
        return false;
    }

    if(!expCategoryText.test(category.value)){
        alert('항공, 숙소, 투어티켓중 한가지를 골라 적어주세요')
        category.focus();
        return false;
    }

    if(title.value == ''){
        alert('제목을 입력해주세요');
        title.focus();
        return false;
    }

    let count = 0;

    for(let i in box){
        if(box[i].checked){
            count++;
        }
    }

    if(count === 0){
        alert('개인정보 수집 및 활용에 동의해주세요');
        return false;
    }
    alert('접수되었습니다');
    return true;
}

