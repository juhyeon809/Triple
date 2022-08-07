/*체크된 회원 데이터 삭제*/
$(document).on('click', '#sendit', function (){
    let cnt = $("input[name='manager']:checked").length;
    let arr = new Array();
    $("input[name='manager']:checked").each(function() {
        arr.push($(this).attr('userid'));
    });
    if(cnt == 0){
        alert("선택된 글이 없습니다.");
    }
    else{
        $.ajax = {
            type: "POST",
            url: "/api/admin",
            data: JSON.stringify(jsonData),
            dataType:"json",
            contentType: 'application/json',
            success: function(jsonData){
                if(jsonData != 1) {
                    alert("삭제 실패 (확인요망)");
                }
                else{
                    alert("삭제되었습니다.");
                }
            },
            error: function(){alert("서버통신 오류");}
        };
    }
});