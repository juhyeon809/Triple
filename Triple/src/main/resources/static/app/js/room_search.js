$(function(){
    $(document).on('click', '#search', function(){

        let cf = '';
        const query = 'input[name="cf"]:checked';
        const selectedEls = document.querySelectorAll(query);
        selectedEls.forEach((el) => {
            cf += el.value + ',';
        })
        let type = '';
        const query2 = 'input[name="type"]:checked';
        const selectedType = document.querySelectorAll(query2);
        selectedType.forEach((el) => {
            type += el.value + ',';
        })
        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                type: type,
                rank: $('#rank').val(),
                reviewCount : $('#reviewCount').val(),
                leastPrice : $('#leastPrice').val(),
                maxPrice : $('#maxPrice').val(),
                cf : cf
            }
        }


        $.ajax({
            type: 'POST',
            url: '/api/room/search',
            data: JSON.stringify(jsonData),
            contentType: 'application/json',
            success: function (data){
                if(data) {
                    console.log("함수실행")
                    $("#roomListContent").replaceWith(data);
                }else{
                    alert("전송된 값 없음")
                }
            },
            error:function(fragment){
                console.log("에러 발생")
                $("#roomListContent").replaceWith(fragment);
            }
        });


    })
});