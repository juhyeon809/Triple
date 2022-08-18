$(document).ready(function(){
    $(".icon4").click(function(){
        $("#airpop").addClass("show");
    })
})

$('#both').on('click',function (){
    $('#both').css({"backgroundColor":"#468cd3", "color":"#fff"})
    $('#one_way').css({"backgroundColor":"#deeeff", "color":"#468cd3"})
    $('#one_way:hover').css({"backgroundColor":"#b2d2f2", "color":"#468cd3"})
})
$('#one_way').on('click',function (){
    $('#one_way').css({"backgroundColor":"#468cd3", "color":"#fff"})
    $('#both').css({"backgroundColor":"#deeeff", "color":"#468cd3"})
    $('#both:hover').css({"backgroundColor":"#b2d2f2", "color":"#468cd3"})
})

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

//날짜설정박스
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

//날짜입력시 값 변경, 버튼클릭시 창닫힘
let datepicker1 = document.querySelector('#datepicker1');
let datepicker2 = document.querySelector('#datepicker2');
let inInput3 = document.querySelector('.click3');
let inInput4 = document.querySelector('.click4');


$(document).ready(function(){
    $(".dateclose").click(function(){
        inInput3.innerText = datepicker1.value;
        inInput4.innerText = datepicker2.value;
        $(".hidebox1-4").css({"display":"none"})
    })
})



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

$(function() {

    $(document).on('click', '#both', function (){
        $('#datepicker').hide();
        $('#datepicker1').show();
        $('#datepicker2').show();
        $('#search1').show();
        $('#search2').hide();
    })

    $(document).on('click', '#one_way', function (){

        $('#datepicker').show();
        $('#datepicker1').hide();
        $('#datepicker2').hide();
        $('#search2').show();
        $('#search1').hide();
    })

    //직항 수화물버튼클릭시 색상변경
    let direct = document.querySelector(".direct");
    direct.addEventListener('click',function(){
        direct.classList.toggle("color");
    });
    let luggage = document.querySelector(".luggage");
    luggage.addEventListener('click', function(){
        luggage.classList.toggle("color");
    })


    $(document).on('click', '#search2', function () {


        if(!$('#departure').val()){
            alert("출발공항을 입력해주세요")
            return false;
        }
        if(!$('#landing').val()){
            alert("도착공항을 입력해주세요")
            return false;
        }
        if(!$('#datepicker').val()){
            alert("가는 날짜를 입력해주세요")
            return false;
        }

        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                departureAirport: $('#departure').val(),
                landingAirport: $('#landing').val(),
                departureDate: $('#datepicker').val(),
            }
        }

        $.post({
            url: '/api/airTicket/search',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('검색성공!');
            },
            error: function () {
                alert('조회하고자하는 정보가 없습니다');
                location.reload();
            }

        })

    });

});

