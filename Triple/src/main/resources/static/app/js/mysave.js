console.log("reserve.js 작동중")

$(function (){

    $(document).on('click', '#sendit', function () {
        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                userId: $('#userId').val(),
                itemNum: $('#itemNum').val(),
                saveType: $('#saveType').val(),
                location: $('#location').val(),
                title: $('#title').val(),
                summary: $('#summary').val(),
                uploadPath: $('#uploadPath').val(),
                saveYn: 'Y'
            }
        }

        $.post({
            url: '/api/mysave',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('저장성공!');
                location.reload();
            },
            error: function () {
                alert('로그인 후 이용하세요!');
                location.href="/Triple/login";
            }
        })

    })
})
