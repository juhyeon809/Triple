
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
        section2.style.display = "block";
        isshow2 = true;
    } 
}
//날짜설정박스 수정하기

// let section2 = document.querySelector(".hidebox1-3")
// let isshow2 = true;
// function hideshow2(){
//     if(isshow2){
//     section2.style.display = "none";
//         isshow2 = false;
//     }else{
//         section1.style.display = "none";
//         section2.style.display = "block";
//         isshow2 = true;
//     } 
// }

//인원및 좌석등급
let section4 = document.querySelector(".hidebox1-4")
let isshow4 = true;
function hideshow4(){
    if(isshow4){
    section4.style.display = "none";
        isshow4 = false;
    }else{
        section1.style.display = "none";
        section2.style.display = "none";
        // section3.style.display = "none";
        section4.style.display = "block";
        isshow4 = true;
    } 
}
//인원추가버튼
function count(type)  {
    // 결과를 표시할 element
    const resultElement = document.querySelector(".result");
   
    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
   
    // 더하기/빼기
    if(type === 'plus') {
      number = parseInt(number) + 1;
    }else if(type === 'minus')  {
      number = parseInt(number) - 1;
    }
   
    // 결과 출력
    resultElement.innerText = number;
  }
 
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
