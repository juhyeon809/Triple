function airline(){
    const kor = RegExp(/[가-힣]+$/);
    const eng = RegExp(/[a-zA-Z]/);
    
    if($('.kor').val() == ''){
        alert('항공사명을 입력해주세요')
        $('.kor').focus();
        return false
    }
    if(!kor.test($('.kor').val())){
        alert('한글만 입력해주세요');
        $('.kor').val('');
        $('.kor').focus();
        return false
    }
    if($('.eng').val() == ''){
        alert('항공사 영문을 입력해주세요')
        $('.eng').focus();
        return false
    }
    if(!eng.test($('.eng').val())){
        alert('영어만 입력해주세요');
        $('.eng').val('');
        $('.eng').focus();
        return false
    }
    if($('.premium').val() == ''){
        alert('항공사 코드를 입력해주세요')
        $('.premium').focus();
        return false
    }
    if(!$('#route option:selected').val()) {
        alert("운항노선을 선택해주세요");
        $('#route').focus();
        return false
    }
    
    if($('.center').val() == ''){
        alert('고객센터 번호를 입력해주세요')
        $('.center').focus();
        return false
    }
    return true;
}

function destination(){
    const airport = RegExp(/[a-zA-Z가-힣]/);
    const code = RegExp(/[a-zA-Z]/);

        if($('.portname').val() == ''){
            alert('공항명을 입력해주세요')
            $('.portname').focus();
            return false
        }
        if(!airport.test($('.portname').val())){
            alert('공항명을 확인해주세요')
            $('.portname').val('');
            $('.portname').focus();
            return false;
        }
        if($('.code').val() == ''){
            alert('공항코드을 입력해주세요')
            $('.code').focus();
            return false
        }
        if(!code.test($('.code').val())){
            alert('공항코드을 확인해주세요')
        $('.code').focus();
        return false;
        }
        if($('.country').val() == ''){
            alert('나라를 입력해주세요')
            $('.country').focus();
            return false
        }
        if($('.textBox').val() == ''){
            alert('도시를 입력해주세요')
            $('.textBox').focus();
            return false
        }
    return true;
}

function aircraft(){
    const name = RegExp(/[a-zA-Z가-힣0-9\-]/);
    const seatNum = RegExp( /^[0-9]+$/)

    if(!$('#airlineName option:selected').val()) {
        alert("항공사명을 선택해주세요");
        $('#airlineName').focus();
        return false
    }
    // if($('.name').val() == ''){
    //     alert('항공기명을 입력해주세요')
    //     $('.name').focus();
    //     return false
    // }
    if(!name.test($('.aircraftName').val())){
        alert('항공기명을 입력해주세요')
        $('.aircraftName').focus();
        return false
    }
    if(!$('#comp option:selected').val()) {
        alert("제조회사를 선택해주세요");
        $('#comp').focus();
        return false
    }
    if($('.vip').val() == ''){
        alert('VIP석 수를 입력해주세요')
        $('.cevipnter').focus();
        return false
    }
    if(!seatNum.test($('.vip').val())){
        alert('숫자만 입력해주세요')
        $('.vip').focus();
        return false
    }
    if($('.family').val() == ''){
        alert('패밀리석 수를 입력해주세요')
        $('.family').focus();
        return false
    }
    if(!seatNum.test($('.family').val())){
        alert('숫자만 입력해주세요')
        $('.family').focus();
        return false
    }
    if($('.special').val() == ''){
        alert('특가석 수를 입력해주세요')
        $('.special').focus();
        return false
    }
    if(!seatNum.test($('.special').val())){
        alert('특가좌석 수를 입력해주세요')
        $('.special').focus();
        return false
    }
    if($('.premium').val() == ''){
        alert('프리미엄석 수를 입력해주세요')
        $('.premium').focus();
        return false
    }
    if(!seatNum.test($('.premium').val())){
        alert('숫자만 입력해주세요')
        $('.premium').focus();
        return false
    }
    if($('.economy').val() == ''){
        alert('일반석 수를 입력해주세요')
        $('.economy').focus();
        return false
    }
    if(!seatNum.test($('.economy').val())){
        alert('숫자만 입력해주세요')
        $('.economy').focus();
        return false
    }
    if($('.total').val() == ''){
        alert('총 좌석수를 입력해주세요')
        $('.total').focus();
        return false
    }
    if(!seatNum.test($('.total').val())){
        alert('숫자만 입력해주세요')
        $('.total').focus();
        return false
    }


    return true;
}
function magazineRegister(){
    const title = document.querySelector('#title');
    const place = document.querySelector('#place');
    const tag = document.querySelector('#tag');

    const hashTag = RegExp(/#[a-zA-Z가-힣0-9]/);
    const file =  "\\.(bmp|gif|jpg|jpeg|png)$";
    const fileImg = document.form.img.value;
    const shortcuts = document.form.shortcuts.value;
    const sights = document.form.sights.value;


    if(!$('#Mcategory > option:selected').val()) {
        alert("분류를 선택해주세요");
        $('#Mcategory').focus();
        return false
    }

    if(title.value == ''){
        alert('제목을 입력해주세요');
        title.focus();
        return false
    }
    if(tag.value == ''){
        alert('해시태그를 입력해주세요');
        tag.focus();
        return false
    }
    if(!hashTag.test(tag.value)){
        alert('#을 붙여서 작성해주세요')
        tag.focus();
        return false;
    }
    if(!(new RegExp(file,"i")).test(fileImg)){
        alert("썸네일 파일을 선택하여 주세요");
        return false;
    }
    if(!(new RegExp(file,"i")).test(shortcuts)){
        alert("바로가기 이미지 파일을 선택하여 주세요");
        return false;
    }
    if(place.value == ''){
        alert('장소명을 입력해주세요');
        place.focus();
        return false
    }
    
    if(!(new RegExp(file,"i")).test(sights)){
        alert("명소 파일을 선택하여 주세요");
        return false;
    }
    return true
}


function eventRegister(){
        
        if(!$('#eventCategory > option:selected').val()) {
            alert("이벤트 분류를 선택해주세요");
            $('#eventCategory').focus();
            return false;
        }
        if($('.tit').val() == ''){
            alert('타이틀명을 입력해주세요');
            $('.tit').focus();
            return false
        }
        return true;
    }
function adminRegister(){
        const id = document.querySelector('.admin_register_adminid_content');
        const pw = document.querySelector('.admin_register_adminpw_content');
        const pwCheck = document.querySelector('.admin_register_adminpwre_content');
        const ph = document.querySelector('.admin_register_hp_content');
        const email = document.querySelector('.admin_register_email_content');
        const name = document.querySelector('.admin_register_name_content');


        const expid = RegExp(/[a-zA-Z0-9]/);
        const exppw = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
        const expname = RegExp(/[가-힣]/);
        const expph = RegExp(/^\d{3}-\d{3,4}-\d{4}$/);
        const expemail = RegExp(/^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/);

        if(id.value == ''){
            alert('아이디를 입력하세요')
            id.focus();
            return false;
        }
        if(!expid.test(id.value)){
            alert('아이디를 다시 확인해주세요');
            id.focus();
            return false
        }
        if(pw.value == ''){
            alert('비밀번호를 입력하세요')
            pw.focus();
            return false;
        }
        if(!exppw.test(pw.value)){
            alert('비밀번호를 확인해주세요');
            pw.focus();
            return false
        }
        if(name.value == ''){
            alert('이름을 입력하세요')
            name.focus();
            return false;
        }
        if(!expname.test(name.value)){
            alert('이름을 다시 확인해주세요');
            name.focus();
            return false
        }
        if(pw.value != pwCheck.value){
            alert('비밀번호가 맞지 않습니다. 다시 확인해주세요');
            pwCheck.focus();
            return false
        }
        if(ph.value == ''){
            alert('연락처를 입력하세요')
            ph.focus();
            return false;
        }
        if(!expph.test(ph.value)){
            alert('연락처를 다시 확인해주세요');
            ph.focus();
            return false
        }

        if(!$('#admin_register_department_content option:selected').val()){
            alert("부서를 선택해주세요");
        }

        if(email.value == ''){
            alert('이메일을 입력하세요')
            email.focus();
            return false;
        }

        if(!expemail.test(email.value)){
            alert('이메일을 다시 확인해주세요');
            email.focus();
            return false
        }
        
        if(!$('#admin_register_title_content option:selected').val()) {
            alert("직함을 선택해주세요");
        }
        return true;
    }

function coupon(){
            
            if($('.name').val() == ''){
                alert('쿠폰 이름을 입력해주세요')
                $('.name').focus();
                return false 
            }
            if($('.code').val() == ''){
                alert('쿠폰 이름을 입력해주세요')
                $('.code').focus();
                return false 
            }
            if(!$('#couponDis > option:selected').val()) {
                alert("할인내용을 선택해주세요");
                return false 
            }
            return true;

        }

        function category(){
            if(!$('#faqCategory > option:selected').val()) {
                alert("분류를 선택해주세요");
                $('#faqCategory').focus();
                return false
            }
            return true;
        }
        function spotRestaurant(){
            const file =  "\\.(bmp|gif|jpg|jpeg|png)$";
            const fileImg = document.form.menu_img.value;
        
            if($('#placeName').val() == ''){
                alert('장소명을 입력해주세요')
                $('#placeName').focus();
                return false
            }
            if($('#place_name').val() == ''){
                alert('식당 타이틀을 입력해주세요')
                $('#place_title').focus();
                return false
            }
            if(!(new RegExp(file,"i")).test(fileImg)){
                alert("메뉴 이미지를 선택하여 주세요");
                return false;
            }
            if($('#menu_name').val() == ''){
                alert('메뉴 이름을 입력해주세요')
                $('#menu_name').focus();
                return false
            }
            if($('#menu_tit').val() == ''){
                alert('메뉴 설명을 입력해주세요')
                $('#menu_tit').focus();
                return false
            }
            if($('#menu_price').val() == ''){
                alert('메뉴 가격을 입력해주세요')
                $('#menu_price').focus();
                return false
            }
            if($('#Basic1').val() == ''){
                alert('가는방법을 입력해주세요')
                $('#Basic1').focus();
                return false
            }
            if($('#Basic2').val() == ''){
                alert('이용가능시간을 입력해주세요')
                $('#Basic2').focus();
                return false
            }
            if($('#Basic3').val() == ''){
                alert('이용팁을 입력해주세요')
                $('#Basic3').focus();
                return false
            }
            return true;
        }

function spotTour(){
    const file =  "\\.(bmp|gif|jpg|jpeg|png)$";
    const fileImg1 = document.form.pro_img1.value;
    const fileImg2 = document.form.pro_img2.value;
    const main1 = document.form.main_img1.value;

    if($('#placeName').val() == ''){
        alert('장소명을 입력해주세요')
        $('#placeName').focus();
        return false
    }
    if($('#place_name').val() == ''){
        alert('장소 타이틀을 입력해주세요')
        $('#place_title').focus();
        return false
    }
    if(!(new RegExp(file,"i")).test(fileImg1)){
        alert("장소 이미지를 선택하여 주세요");
        return false;
    }
    if($('#mini_name').val() == ''){
        alert('장소 미니 타이틀을 입력해주세요')
        $('#mini_name').focus();
        return false
    }
    if($('#weditor').val() == ''){
        alert('장소 설명을 입력해주세요')
        $('#menu_tit').focus();
        return false
    }
    if(!(new RegExp(file,"i")).test(main_img1)){
        alert("주요 볼거리 이미지를 선택하여 주세요");
        return false;
    }
    if($('#main_tit').val() == ''){
        alert('주요 볼거리 타이틀을 입력해주세요')
        $('#main_tit').focus();
        return false
    }
    if($('#main_name').val() == ''){
        alert('주요 볼거리 설명을 입력해주세요')
        $('#main_name').focus();
        return false
    }

    if($('#recommend').val() == ''){
        alert('권장 체류시간을 입력해주세요')
        $('#recommend').focus();
        return false
    }
    if($('#way').val() == ''){
        alert('가는방법을 입력해주세요')
        $('#way').focus();
        return false
    }
    if($('#time').val() == ''){
        alert('이용가능시간 입력해주세요')
        $('#time').focus();
        return false
    }
    if($('#pay').val() == ''){
        alert('이용료를 입력해주세요')
        $('#pay').focus();
        return false
    }
    return true;
}