/* 항공예약검색 팝업 */

$(document).ready(function(){
    $(".icon4").click(function(){
        $("#airpop").addClass("show");
    })
})



/* 왕복,편도버튼*/
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
        if(number <= 0){
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
        if(number <= 0){
            number = 0;
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
        if(number <= 0){
            number =0;
        }
    }
    // 결과 출력
    resultElement.innerText = number;
    }



    let personNum = document.querySelector('.personNum');
    let seatSr = document.querySelector('.seatSr');
    let seatCnt = document.querySelector('.seatCnt');
    function value(){
        let query = 'input[name="seat"]:checked';
        let values = document.querySelectorAll(query);

        if(query.value == 1){
            seatSr.innerHTML = query.value; 
        }else{
            seatSr.innerHTML = query.value;
            seatCnt.innerHTML = values.length-1;
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

//도시선택1 입력시 값 변경
let input = document.querySelector('#city1');
let inInput = document.querySelector('.click1');
input.addEventListener('keypress', function(key){
    if(key.keyCode == 13){
        inInput.innerText = input.value;
        section1.style.display = "none";
    }
})

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

//도시선택2 입력시 값 변경
let input2 = document.querySelector('#city2');
let inInput2 = document.querySelector('.click2');
input2.addEventListener('keypress', function(key){
    if(key.keyCode == 13){
        inInput2.innerText = input2.value;
        section2.style.display = "none";
    }
})

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
        section3.style.display = "block";
        section4.style.display = "none";
        isshow2 = true;
    } 
}

//날짜입력시 값 변경, 더블클릭시 창닫힘
let closebox = document.querySelector('.hidebox1-4');
let datepicker1 = document.querySelector('#datepicker1');
let datepicker2 = document.querySelector('#datepicker2');
let inInput3 = document.querySelector('.click3');
let inInput4 = document.querySelector('.click4');

closebox.addEventListener('dblclick', (event) => {
    inInput3.innerText = datepicker1.value;
    inInput4.innerText = datepicker2.value;
    section3.style.display = "none";
});


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






//직항 수화물버튼클릭시 색상변경
    let direct = document.querySelector(".direct");
    direct.addEventListener('click',function(){
        direct.classList.toggle("color");
});
    let luggage = document.querySelector(".luggage");
    luggage.addEventListener('click', function(){
        luggage.classList.toggle("color");
    })
    

//닫기버튼

$(document).ready(function(){
    $(".close").click(function(){
        $(".hidebox1-5").css({"display":"none"})
    })
})

