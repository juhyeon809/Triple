$(document).ready(function(){

    // let logoSelect = new Vue({
    //     el:'#logo_select',
    //     data: {
    //         jinair:true
    //     },
    //     methods : {
    //
    //     }
    // });


    let airTicketList = new Vue({
        el: "#airTicketList",
        data: {
            airTicketList:{}
        }
    });



        $.get("/api/airTicket/list", function(response){
            console.log("함수 작동");
            airTicketList.airTicketList = response.data;


            return airTicketList;
        });



});


/* 항공예약검색 팝업 */





