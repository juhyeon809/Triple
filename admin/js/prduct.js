/*air*/
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
    var isKCheck=false;
    var arrKeyword=document.getElementsByName("keywordchk");
    for(var i=0; i<arrKeyword.length; i++){
        if(arrKeyword[i].checked == true){
            isKCheck=true;
            break;
        }
    }
    if(!isKCheck){
        alert('키워드를 선택해주세요');
        return false;
    }
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
