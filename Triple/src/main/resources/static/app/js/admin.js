/* air */
function productAir(){

    const img=document.getElementById('logo_img');
    const docategory= document.getElementById('DOcategory');
    const airline = document.getElementById('airline');
    const plane_name= document.getElementById('plane_name');

    const flytime = document.querySelector('.flytime');
    const arrive= document.querySelector('.arrive');
    const exhd=RegExp(/^[A-Za-z0-9]+$/);
    const go_time=document.querySelector('.go_time');
    const arr_time= document.querySelector('.arr_time');



    if(img.value==''){
        alert("로고 파일을 선택해주세요");
        img.focus();
        return false;
    }
    if(docategory.value==''){
        alert('국내/국외를 선택해주세요');
        docategory.focus();
        return false;
    }
    if(go_time.value==''){
        alert('출발 시간을 선택해주세요');
        go_time.focus();
        return false;
    }
    if(arr_time.value==''){
        alert('도착 시간을 선택해주세요');
        arr_time.focus();
        return false;
    }
    if(flytime.value == ''){
        alert('비행시간을 입력해주세요');
        flytime.focus();
        return false
    }

    if(arrive.value == ''){
        alert('도착지를 입력해주세요');
        arrive.focus();
        return false
    }

    if(airline.value==''){
        alert('항공사를 선택해주세요');
        airline.focus();
        return false;
    }
    if(plane_name.value==''){
        alert('항공기를 선택해주세요');
        plane_name.focus();
        return false;
    }
    //가격
    if($('#Eadult').val()==''){
        alert('성인좌석가격을 입력해주세요');
        $('#Eadult').focus();
        return false;
    }
    if($('#Einfant').val()==''){
        alert('소아좌석가격을 입력해주세요');
        $('#Einfant').focus();
        return false;
    }

    if($('#Echild').val()==''){
        alert('유아좌석 가격을 입력해주세요');
        $('#Echild').focus();
        return false;
    }
    if($('#Padult').val()==''){
        alert('성인좌석 가격을 입력해주세요');
        $('#Padult').focus();
        return false;
    }
    if($('#Pinfant').val()==''){
        alert('소아좌석가격을 입력해주세요');
        $('#Pinfant').focus();
        return false;
    }

    if($('#Pchild').val()==''){
        alert('유아좌석 가격을 입력해주세요');
        $('#Pchild').focus();
        return false;
    }
    if($('#Badult').val()==''){
        alert('성인좌석 가격을 입력해주세요');
        $('#Badult').focus();
        return false;
    }
    if($('#Binfant').val()==''){
        alert('소아좌석가격을 입력해주세요');
        $('#Binfant').focus();
        return false;
    }

    if($('#Bchild').val()==''){
        alert('유아좌석 가격을 입력해주세요');
        $('#Bchild').focus();
        return false;
    }
    if($('#Fadult').val()==''){
        alert('성인좌석 가격을 입력해주세요');
        $('#Fadult').focus();
        return false;
    }
    if($('#Finfant').val()==''){
        alert('소아좌석가격을 입력해주세요');
        $('#Finfant').focus();
        return false;
    }

    if($('#Fchild').val()==''){
        alert('유아좌석 가격을 입력해주세요');
        $('#Fchild').focus();
        return false;
    }



    return true;
}

/*packge*/
function productPackge(){
    const concategory=document.querySelector('.concategory');
    const pro_name=document.querySelector('.pro_name');
    const pro_img= document.getElementById('pro_img');

    if(concategory.value=='') {
        alert("나라를 선택해주세요");
        $('.Concategory').focus();
        return false
    }
    if(pro_name.value == ''){
        alert('상품명을 입력해주세요');
        pro_name.focus();
        return false
    }
    if(pro_img.value==''){
        alert('파일을 선택해주세요');
        pro_img.focus();
        return false;
    }

    //키워드
    // var isKCheck=false;
    // var arrKeyword=document.getElementsByName("keywordchk");
    // for(var i=0; i<arrKeyword.length; i++){
    //     if(arrKeyword[i].checked == true){
    //         isKCheck=true;
    //         break;
    //     }
    // }
    // if(!isKCheck){
    //     alert('키워드를 선택해주세요');
    //     return false;
    // }
    //상품가격
    return true
}

/*room */

function productRoom(){

    const rocategory= document.querySelector('.Rcategory');
    const tcategory = document.querySelector('.Tcategory');
    const pcategory= document.querySelector('.Pcategory');
    const spcategory= document.querySelector('.SPcategory');
    const viewcategory= document.querySelector('.Viewcategory');
    const rpcategory= document.querySelector('.RPcategory');
    const bcategory= document.querySelector('.Bcategory');

    const roomname = document.querySelector('.formbox_ul_text');
    const roomimg=document.getElementById('room_img');

    const check_in=document.getElementById('check_in');
    const check_out= document.getElementById('check_out');

    if(rocategory.value==''){
        alert('상품분류를 선택해주세요');
        rocategory.focus();
        return false;
    }
    if(tcategory.value==''){
        alert('도시를 선택해주세요');
        tcategory.focus();
        return false;
    }
    if(roomname.value == ''){
        alert('객실명을 입력해주세요');
        roomname.focus();
        return false
    }
    if(roomimg.value==''){
        alert('객실 사진을 등록해주세요');
        roomimg.focus();
        return false;
    }
    //객실옵션
    if(pcategory.value==''){
        alert('인원을 선택해주세요');
        pcategory.focus();
        return false;
    }else if(spcategory.value==''){
        alert('옵션을 선택해주세요');
        spcategory.focus();
        return false;
    } else if(viewcategory.value==''){
        alert('뷰를 선택해주세요');
        viewcategory.focus();
        return false;
    }else if(rpcategory.value==''){
        alert('사이즈/인원을 선택해주세요');
        rpcategory.focus();
        return false;
    }else if(bcategory.value==''){
        alert('침대 개수를 선택해주세요');
        bcategory.focus();
        return false;
    }
    //편의시설

    var isCf=false;
    var arrCf=document.getElementsByName("cf");
    for(var i=0; i<arrCf.length; i++){
        if(arrCf[i].checked == true){
            isCf=true;
            break;
        }
    }
    if(!isCf){
        alert('편의시설을 선택해주세요');
        return false;
    }

    //체크인체크아웃 시간
    if(check_in.value==''){
        alert('체크인 시간을 선택해주세요');
        check_in.focus();
        return false;
    }else if(check_out.value==''){
        alert('체크아웃 시간을 선택해주세요');
        check_out.focus();
        return false;
    }
    const exPrice=RegExp( /\B(?=(\d{3})+(?!\d))/g, ',');
    if(!exPrice.test($('.seat_type_input').val())){
        alert('가격을 형식에 맞게 입력해주세요');
        $('.seat_type_input').focus();
        return false
    }

    return true;
}

/*ticket */

function productTicket(){
    const docategory= document.querySelector('.DOcategory');
    const tacategory= document.querySelector('.TAcategory');
    const pro_name=document.getElementById('pro_name');
    const pro_img= document.getElementById('pro_img');


    if(docategory.value==''){
        alert('상품분류를 선택해주세요');
        docategory.focus();
        return false;
    }



    if(tacategory.value==''){
        alert('투어/액티비티중 선택해주세요');
        tacategory.focus()
        return false;
    }
    if(pro_name.value == ''){
        alert('상품명을 입력해주세요');
        pro_name.focus();
        return false;
    }
    if(pro_img.value==''){
        alert('파일을 선택해주세요');
        return false;
    }
    var isKCheck=false;
    var arrKeyword=document.getElementsByName("keywordchk");
    for(var i=0; i<arrKeyword.length; i++){
        if(arrKeyword[i].checked == true){
            isKCheck=true;
            break;
        }
    }

    const exPrice=RegExp( /\B(?=(\d{3})+(?!\d))/g, ',');
    if(!exPrice.test($('.item_price_input').val())){
        alert('가격을 형식에 맞게 입력해주세요');
        $('.item_price_input').focus();
        return false
    }

    return true;

}

function noticeRegister(){
    const notice= document.querySelector('.no_list');
    const title=document.querySelector('.title');


    if(notice.value==''){
        alert('분류를 선택해주세요');
        return false;
    }
    if(title.value==''){
        alert('타이틀명을 입력해주세요');
        return false;
    }
    return true;
}


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

// function aircraft(){
//     const name = RegExp(/[a-zA-Z가-힣0-9\-]/);
//     const seatNum = RegExp( /^[0-9]+$/)
//
//     if(!$('#airlineName').val()) {
//         alert("항공사명을 선택해주세요");
//         $('#airlineName').focus();
//         return false
//     }
//     // if($('.name').val() == ''){
//     //     alert('항공기명을 입력해주세요')
//     //     $('.name').focus();
//     //     return false
//     // }
//     if(!name.test($('.aircraftName').val())){
//         alert('항공기명을 입력해주세요')
//         $('.aircraftName').focus();
//         return false
//     }
//     // if(!$('#comp').val()) {
//     //     alert("제조회사를 선택해주세요");
//     //     $('#comp').focus();
//     //     return false
//     // }
//     if($('.vip').val() == ''){
//         alert('VIP석 수를 입력해주세요')
//         $('.cevipnter').focus();
//         return false
//     }
//     if(!seatNum.test($('.vip').val())){
//         alert('숫자만 입력해주세요')
//         $('.vip').focus();
//         return false
//     }
//     if($('.family').val() == ''){
//         alert('패밀리석 수를 입력해주세요')
//         $('.family').focus();
//         return false
//     }
//     if(!seatNum.test($('.family').val())){
//         alert('숫자만 입력해주세요')
//         $('.family').focus();
//         return false
//     }
//     if($('.special').val() == ''){
//         alert('특가석 수를 입력해주세요')
//         $('.special').focus();
//         return false
//     }
//     if(!seatNum.test($('.special').val())){
//         alert('특가좌석 수를 입력해주세요')
//         $('.special').focus();
//         return false
//     }
//     if($('.premium').val() == ''){
//         alert('프리미엄석 수를 입력해주세요')
//         $('.premium').focus();
//         return false
//     }
//     if(!seatNum.test($('.premium').val())){
//         alert('숫자만 입력해주세요')
//         $('.premium').focus();
//         return false
//     }
//     if($('.economy').val() == ''){
//         alert('일반석 수를 입력해주세요')
//         $('.economy').focus();
//         return false
//     }
//     if(!seatNum.test($('.economy').val())){
//         alert('숫자만 입력해주세요')
//         $('.economy').focus();
//         return false
//     }
//     if($('.total').val() == ''){
//         alert('총 좌석수를 입력해주세요')
//         $('.total').focus();
//         return false
//     }
//     if(!seatNum.test($('.total').val())){
//         alert('숫자만 입력해주세요')
//         $('.total').focus();
//         return false
//     }
//
//
//     return true;
// }
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

/* 관리자 등록 */
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




