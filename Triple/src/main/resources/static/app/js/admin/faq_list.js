$(function () {
    $(document).on('click', '#sendit', function () {
        const regform = document.getElementById('regform');

        if (!$('#faqCategory option:selected').val()) {
            alert("카테고리를 선택해주세요");
            regform.faqCategory.focus();
            return false;
        }
        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                adminuserId: $('#adminuserId').val(),
                adminuserName: $('#adminuserName').val(),
                faqCategory: $('#faqCategory option:selected').val(),
                title: $('#title').val(),
                content: $('#weditor1').val()
            }
        }

        $.post({

            url: '/api/admin/faq',
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success:function(){
                alert('등록되었습니다.');
                location.href = "/Triple/admin/faqList";
            },
            error:function(){
                alert('등록실패 (확인요망)');
                location.reload();
            }

        });
    });
});