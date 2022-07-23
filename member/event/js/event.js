let txt1 = document.querySelector(".divTit1");
let txt2 = document.querySelector(".divTit2");
let txt3 = document.querySelector(".divTit3");
let txt4 = document.querySelector(".divTit4");
txt1.addEventListener('click',function(){
    txt1.classList.toggle('color');
    txt2.classList.remove("color");
    txt3.classList.remove("color");
    txt4.classList.remove("color");
});

txt2.addEventListener('click',function(){
    txt2.classList.toggle("color");
    txt1.classList.remove("color");
    txt3.classList.remove("color");
    txt4.classList.remove("color");
});

txt3.addEventListener('click',function(){
    txt3.classList.toggle("color");
    txt1.classList.remove("color");
    txt2.classList.remove("color");
    txt4.classList.remove("color");
});

txt4.addEventListener('click',function(){
    txt4.classList.toggle("color");
    txt1.classList.remove("color");
    txt2.classList.remove("color");
    txt3.classList.remove("color");
});