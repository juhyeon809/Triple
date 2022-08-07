const search = document.querySelector('#search')
const searchbox = document.querySelector('#searchbox')
let isshow = true;
function hideshow(){
    if(isshow){
        searchbox.style.display = "none";
        isshow = false;
    }else{
        searchbox.style.display = "block";
        isshow = true;
    }

}
let hide = true;
function change(){
    if(hide){
        $('.title_kor').css({"display":"block", "text-decoration": "underline", "color":"#425052"});
        $('.title_global').css({"color":"#b6b6b6", "text-decoration": "none"});
        $('.cityList_kor').css({"display":"block"})
        $('.cityList_global').css({"display":"none"})
        $('.global').css({"display":"none"})
    }
}
function change2(){
    if(hide){
        $('.title_global').css({"display":"block", "text-decoration": "underline", "color":"#425052"});
        $('.title_kor').css({"color":"#b6b6b6", "text-decoration": "none"});
        $('.global').css({"display":"block"})
        $('.cityList_kor').css({"display":"none"})
        $('.cityList_global').css({"display":"block"})

        $('.seoul').css({"display":"none"})
        $('.busan').css({"display":"none"})
        $('.jeju').css({"display":"none"})
        $('.chungcheong').css({"display":"none"})
        $('.gyeongsang').css({"display":"none"})
        $('.incheon').css({"display":"none"})
        $('.jeolla').css({"display":"none"})
        $('.gyeonggi').css({"display":"none"})
        $('.gangwon').css({"display":"none"})
        hide = true;
    }
}
function seoul(){
    $('.kor1').on('click', function(){
        $('.seoul').css({"display":"block"})
    })
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})


}
function busan(){
    $('.kor2').on('click', function(){
        $('.busan').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function jeju(){
    $('.kor3').on('click', function(){
        $('.jeju').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function gangwon(){
    $('.kor4').on('click', function(){
        $('.gangwon').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function gyeonggi(){
    $('.kor5').on('click', function(){
        $('.gyeonggi').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function incheon(){
    $('.kor6').on('click', function(){
        $('.incheon').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function gyeongsang(){
    $('.kor7').on('click', function(){
        $('.gyeongsang').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function chungcheong(){
    $('.kor8').on('click', function(){
        $('.chungcheong').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.jeolla').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})
}
function jeolla(){
    $('.kor9').on('click', function(){
        $('.jeolla').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.busan').css({"display":"none"})
    $('.jeju').css({"display":"none"})
    $('.chungcheong').css({"display":"none"})
    $('.gyeongsang').css({"display":"none"})
    $('.incheon').css({"display":"none"})
    $('.gyeonggi').css({"display":"none"})
    $('.gangwon').css({"display":"none"})
    $('.global').css({"display":"none"})
}

function statusChange( statusItem ){
    const strText = $(statusItem).text();
    // strText 에 전체 문자열이 입력된다.
    $('.search').val(strText)
}
            