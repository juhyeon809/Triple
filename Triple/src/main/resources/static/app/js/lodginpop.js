
    const search = document.querySelector('#search')
    const searchbox = document.querySelector('#searchbox')
    const city = document.querySelectorAll('.city')
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
}
}
    function change2(){
    if(hide){
    $('.title_global').css({"display":"block", "text-decoration": "underline", "color":"#425052"});
    $('.title_kor').css({"color":"#b6b6b6", "text-decoration": "none"});
    $('.cityList_kor').css({"display":"block"})
    $('.cityList_global').css({"display":"none"})
    hide = true;
}
}
    function seoul(){
    $('.kor1').on('click', function(){
        $('.seoul').css({"display":"block"})
    })
    $('.busan').css({"display":"none"})

}
    function busan(){
    $('.kor2').on('click', function(){
        $('.busan').css({"display":"block"})
    })
    $('.seoul').css({"display":"none"})
    $('.jeju').css({"display":"none"})
}


    function statusChange( statusItem ){
    const strText = $(statusItem).text();
    // strText 에 전체 문자열이 입력된다.
    $('.search').val(strText)
}

