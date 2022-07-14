// function hideshow(obj){
//     let $target = (obj).parent(".hidebox1-1");
//     let $orther = $target.parent(".hidebox").find(".hidebox1-1").not($target);

//     if(!play){
//         play = true;
//         $orther.removeCloass("focus active").find(".boxlink1 a").removeCloass("on");
//         $orther.find(".hidebox").stop().slideUp(50);
//         $target.toggleClass("focus activ").find(".boxlink1 a").toggleClass("on");
//         if($orther(obj).parent(""))
//     }
// }
//     function hidebox(obj){
//         let $target;
//         if(obj) {
//             $target = $(obj).parent(".hidebox1-1");
//         }else{
//             $(".hidebox").each(function(){
//                 if($(this).hasClass("foucus")){
//                     $target=$(this);
//                 }
//             })
//         }
//         if($target){
//             $target.removeCloass("focus activ").find(".boxlink1 a").removeCloass("on");
//             $target.find(".hidebox1-1").stop().slideUp(50);
//         }
//     }

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

//닫기버튼
let closeBtn = document.querySelector(".close");

closeBtn.addEventListener('click', ()=>{
    section.style.display = "none";
    section1.style.display = "none"
    section2.style.display = "none";
    section4.style.display = "none";
})