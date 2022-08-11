$(function () {
    $(document).on('click', '#sendit_modify', function (){
        const regform = document.getElementsByName('regForm');


        if(!$('#faqCategory option:selected').val()) {
            alert("카테고리를 선택해주세요");
            regform.faqCategory.focus();
            return false;
        }

        let jsonData = {
            transaction_time: new Date(),
            resultCode: "ok",
            description: "ok",
            data: {
                idx: $('#idx').val(),
                adminuserId: $('#adminuserId').val(),
                adminuserName: $('#adminuserName').val(),
                faqCategory: $('#faqCategory option:selected').val(),
                title: $('#title').val(),
                content: $('#weditor1').val()
            }
        }
        $.ajax({
            url: '/api/admin/faq',
            type: "PUT",
            data: JSON.stringify(jsonData),
            dataType: 'json',
            contentType: 'application/json',
            success: function(){
                alert("수정했습니다");
                location.href = "/Triple/admin/faqList";
            },
            error: function(){
                alert('수정실패 (확인요망)');
                location.reload();
            }
        });
    });
});