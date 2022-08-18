console.log("reserve.js 작동중")

$(document).ready(function() {



    // let inquiryList = new Vue({
    //     el: "#inquiryList",
    //     data: {
    //         inquiryList:{}
    //     }
    // });

    // $.get("/api/inquiry/list", function(response){
    //     console.log("함수 작동");
    //     inquiryList.inquiryList = response.data;
    //     return inquiryList;
    // })

})


$(function (){

    $('.accordion .content').eq(0).show()
    $('.accordion .title').click(function(){
        $(this).siblings('.accordion .content').slideUp()
        $(this).next().stop().slideToggle(300)
        $(this).toggleClass('active')
        $(this).siblings('.accordion .title').removeClass('active')
    })




    $(document).on('click', '#sendit', function () {
        const typeCategory = document.getElementById('typeCategory');
        const title = document.getElementById('title');
        const content = document.getElementById('content')
        const box = document.getElementsByName('box');

        const expCategoryText = /[항공|숙소|투어티켓|]/;


        if (typeCategory.value == '') {
            alert('카테고리를 입력해주세요');
            typeCategory.focus();
            return false;
        }

        if (!expCategoryText.test(typeCategory.value)) {
            alert('항공, 숙소, 투어티켓중 한가지를 골라 적어주세요')
            typeCategory.focus();
            return false;
        }

        if (title.value == '') {
            alert('제목을 입력해주세요');
            title.focus();
            return false;
        }

        let count = 0;

        for (let i in box) {
            if (box[i].checked) {
                count++;
            }
        }

        if (count === 0) {
            alert('개인정보 수집 및 활용에 동의해주세요');
            return false;
        }


        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                typeCategory: $('#typeCategory').val(),
                title: $('#title').val(),
                content: $('#content').val(),
                filename: $('#filename').val(),
                userId: $('#idx').val(),
                infoAgree:'Y'
            }
        }

        $.post({
            url: '/api/inquiry',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('등록성공!');
                location.href = '/Triple/inquiryList';
            },
            error: function () {
                alert('등록실패!');
                location.reload();
            }
        })

    })



})
function cancel1(){
    if(!confirm("정말 취소하시겠습니까?\n취소하시려면 확인을 눌러주세요.")){
        location.href='';
    }else{
        alert("취소되었습니다")
        location.reload();
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
// }

// function sendit(){
//     const category = document.getElementById('category');
//     const title = document.getElementById('title');
//     const box = document.getElementsByName('box');
//
//
//
//     const expCategoryText = /[항공|숙소|투어티켓|]/;
//
//
//     if(category.value == ''){
//         alert('카테고리를 입력해주세요');
//         category.focus();
//         return false;
//     }
//
//     if(!expCategoryText.test(category.value)){
//         alert('항공, 숙소, 투어티켓중 한가지를 골라 적어주세요')
//         category.focus();
//         return false;
//     }
//
//     if(title.value == ''){
//         alert('제목을 입력해주세요');
//         title.focus();
//         return false;
//     }
//
//     let count = 0;
//
//     for(let i in box){
//         if(box[i].checked){
//             count++;
//         }
//     }
//
//     if(count === 0){
//         alert('개인정보 수집 및 활용에 동의해주세요');
//         return false;
//     }
//     alert('접수되었습니다');
//     return true;
//

