$(document).on('click', '#guide_a', function (){
    $('#guide1_table').hide();
    $('#guide2_table').show();
    $('#tour_table').hide();
    $('#restaurant_table').hide();
});

$(document).on('click', '#tour_a', function (){
    $('#guide1_table').hide();
    $('#guide2_table').hide();
    $('#tour_table').show();
    $('#restaurant_table').hide();
});
$(document).on('click', '#restaurant_a', function (){
    $('#guide1_table').hide();
    $('#guide2_table').hide();
    $('#tour_table').hide();
    $('#restaurant_table').show();
});