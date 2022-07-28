// const container = document.querySelector('.item_list'), 
// slides = document.querySelectorAll("div#slide > a"), 
// slidecounter = slides.length;
// let currentIndex = 0;

// var lele = 0;
// var i = 0;
// function moveleft(){
//     if(i < slidecounter - 1){
//         lele += 100;
//         i++;
//         container.style.transition = '.3s'
//         setTimeout('moveleft()', 3000);
//     }else{
//         container.style.left = "-" + lele + "%";
//     }
//     moveleft();
// }
// console.log(container);


// function move(){
//     var curIndex = 0;
//     setInterval(function(){
//         container.style.transition = '0.3s';
//         container.style.transform = "translate3d(-" + 200 * (curIndex + 1) + "px, 0px, 0px)";

//         curIndex++;

//         if(curIndex === 8){
//             curIndex = -1;
//         }

//     }, 1000);

//     document.addEventListener("DPMContentLoaded", function(){
//         move();
//     });
// }