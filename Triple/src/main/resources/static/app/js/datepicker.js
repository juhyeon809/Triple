let disabledDays = [];

$(document).ready(function(){

    let jsonData = {"roomId" : $('#roomId').val()}

    $.ajax({
        type: 'POST',
        url: '/api/roomReservation/check',
        data: JSON.stringify(jsonData),
        contentType: 'application/json',
        success: function(data){
            if(data) {
                console.log("함수실행")
                console.log(data)
                let list = data.list;
                for(let i=0; i<list.length; i++){
                    disabledDays.push(list[i]);
                }

            }else{
                alert("전송된 값 없음")
            }
        },
        error:function(fragment){
            console.log("에러 발생")
            console.log(fragment)

        }
    });

    $(function() {
        //input을 datepicker로 선언
        $("#datepicker1,#datepicker2").datepicker({
            dateFormat: 'yy-mm-dd' //달력 날짜 형태
            ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
            ,changeYear: true //option값 년 선택 가능
            ,changeMonth: true //option값  월 선택 가능
            ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
            ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
            ,buttonText: "선택" //버튼 호버 텍스트
            ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
            ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
            ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
            ,minDate: "+1d" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
            ,maxDate: "+1y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
            ,beforeShowDay: disableAllTheseDays
        });
        //초기값을 오늘 날짜로 설정해줘야 합니다.
        $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
    });
    function disableAllTheseDays(date){
        console.log(disabledDays)
        let m = date.getMonth()+1;
        let d= date.getDate();
        let y = date.getFullYear();
        if(m<10){
            m = '0'+m
        }
        if(d < 10){
            d = '0'+d
        }
        console.log(y+'년'+m+'월'+d+'일');
        for(let i = 0; i < disabledDays.length; i++){
            if($.inArray(y + '-' + m + '-' + d, disabledDays) != -1){
                return [false];
            }
        }
        return [true];
    }
});





