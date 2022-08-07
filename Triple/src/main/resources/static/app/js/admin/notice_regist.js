$(function () {

    $(document).on('click', '#sendit', function (){
        const title = document.getElementById('title');
        const regform = document.getElementsByName('regform');
        const content = document.getElementById('weditor1');

        if(!$('#noticeType option:selected').val()) {
            alert("카테고리를 선택해주세요");
            regform.noticeType.focus();
            return false;
        }

        if(title.value == ''){
            alert('제목을 입력하세요')
            title.focus();
            return false;
        }

        if(content.value == ''){
            alert('내용을 입력하세요')
            content.focus();
            return false;
        }

        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                noticeType: $('#noticeType option:selected').val(),
                title: $('#title').val(),
                content: $('#content').val(),
                uploadPath: $('#uploadPath').val(),
                fileName: $('#fileName').val()
            }
        }

        $.post({
            url: '/api/admin/notice',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
                alert('등록되었습니다.');
                location.href = "/Triple/admin/noticeList";
            },
            error: function () {
                alert('등록실패 (확인요망)');
                location.reload();
            }

        });
    });
});