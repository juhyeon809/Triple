/* 항공예약검색 팝업 */
// // 팝업 열기
// $(document).on("click", ".popUp", function (e){
// 	var target = $(this).attr("href");
// 	$(target).addClass("show");
//     // // $("html, body").css({"overflow" : "hidden", "height":"100%"})
//     // document.getElementsByTagName("body").style.overflow = "hidden";
// });
$(document).ready(function(){
    $(".icon4").click(function(){
        $("#airpop").addClass("show");
    })
})



// 외부영역 클릭 시 팝업 닫기
// $(document).mouseup(function (e){
// 	var LayerPopup = $(".airpop");
//     // $("html, body").css({"overflow" : "auto", "height":"auto"})
// 	if(LayerPopup.has(e.target).length === 0){
// 		LayerPopup.removeClass("show");
// 	}
// });

/* */
let round1 = document.querySelector(".round1");
let round2 = document.querySelector(".round2");
let changebox = document.querySelector(".oneway");
let roundbtn = document.querySelector(".flybtn1");
let onewaybtn = document.querySelector(".flybtn2");
let hide = true;
function change(){
    if(hide){
        round1.style.display = "block";
        round2.style.display = "block";
        roundbtn.style.backgroundColor = "#b2d2f2";
        onewaybtn.style.backgroundColor = "#deeeff";
        changebox.style.display = "none";
    }
}
function change2(){
    if(hide){
        roundbtn.style.backgroundColor = "#deeeff";
        onewaybtn.style.backgroundColor = "#b2d2f2";
        changebox.style.display = "block"
        round1.style.display = "none";
        round2.style.display = "none";
        changebox.style.width = "350px";
        hide = true;
    }
}





let section = document.querySelector(".hidebox1-1");
let isshow = true;
function hideshow(){
    if(isshow){
    section.style.display = "none";
    section1.style.display = "none";
        isshow = false;
    }else{
        section.style.display = "block";
        isshow = true;
    }
}
let section1 = document.querySelector(".hidebox1-2");
let isshow1 = true;
function hideshow1(){
    if(isshow1){
    section1.style.display = "none";
    
        isshow1 = false;
    }else{
        section1.style.display = "block";
        section2.style.display = "none";
        section3.style.display = "none";
        section4.style.display = "none";
        isshow1 = true;
    } 
}
let section2 = document.querySelector(".hidebox1-3")
let isshow2 = true;
function hideshow2(){
    if(isshow2){
    section2.style.display = "none";
        isshow2 = false;
    }else{
        section1.style.display = "none";
        section4.style.display = "none";
        section3.style.display = "none";
        section2.style.display = "block";
        isshow2 = true;
    } 
}
//날짜설정박스 수정하기

let section3 = document.querySelector(".hidebox1-4")
let isshow3 = true;
function hideshow3(){
    if(isshow3){
    section3.style.display = "none";
        isshow3 = false;
    }else{
        section1.style.display = "none";
        section2.style.display = "none";
        section4.style.display = "none";
        section3.style.display = "block";
        isshow2 = true;
    } 
}

//인원및 좌석등급
let section4 = document.querySelector(".hidebox1-5")
let isshow4 = true;
function hideshow4(){
    if(isshow4){
    section4.style.display = "none";
        isshow4 = false;
    }else{
        section1.style.display = "none";
        section2.style.display = "none";
        section3.style.display = "none";
        section4.style.display = "block";
        isshow4 = true;
    } 
}



//인원추가버튼
function count1(type)  {
    // 결과를 표시할 element
    const resultElement = document.querySelector(".result1");
    
    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
    
    // 더하기/빼기
    if(type === 'plus') {
        number = parseInt(number) + 1;
    }else if(type === 'minus')  {
        number = parseInt(number) - 1;
        if(number => 0){
            number =0;
        }
    }
    // 결과 출력
    resultElement.innerText = number;
    }




    //인원추가버튼
function count2(type)  {
    // 결과를 표시할 element
    const resultElement = document.querySelector(".result2");
    
    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
    
    // 더하기/빼기
    if(type === 'plus') {
        number = parseInt(number) + 1;
    }else if(type === 'minus')  {
        number = parseInt(number) - 1;
        if(number => 0){
            number =0;
        }
    }
    // 결과 출력
    resultElement.innerText = number;
    }





    //인원추가버튼
function count3(type)  {
    // 결과를 표시할 element
    const resultElement = document.querySelector(".result3");
    
    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
    
    // 더하기/빼기
    if(type === 'plus') {
        number = parseInt(number) + 1;
    }else if(type === 'minus')  {
        number = parseInt(number) - 1;
        if(number => 0){
            number =0;
        }
    }
    // 결과 출력
    resultElement.innerText = number;
    }


    let direct = document.querySelector(".direct");
    direct.addEventListener('click',function(){
        direct.classList.toggle("color");
});
    let luggage = document.querySelector(".luggage");
    luggage.addEventListener('click', function(){
        luggage.classList.toggle("color");
    })
    

//닫기버튼
let closeBtn = document.querySelector(".close");
closeBtn.addEventListener('click', ()=>{
    section.style.display = "none";
    section1.style.display = "none"
    section2.style.display = "none";
    section4.style.display = "none";
})

// /*상세요금보기 */
// let  boxshow = document.querySelector(".smallpayShow");
// let showBox = true;
// function paydetail(){
//         boxshow.style.display = "block";
//         showBox = true;
// }
// function payout(){
//     boxshow.style.display = "none";
//     showBox = false;
// }






//결제하기
