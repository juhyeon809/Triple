$(function(){
    $("#delete").click(() => {

        $.ajax({
            url: '/api/guide',
            method: "DELETE",
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function(){
                alert('삭제했습니다');
                location.href= '/Triple/admin/spotList';
            },
            error: function(){
                alert('삭제실패 (확인요망)');
                location.reload();
            }
        })
    })

});