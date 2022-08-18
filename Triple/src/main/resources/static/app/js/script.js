
const allDropdown = document.querySelectorAll('#sidebar .side-dropdown');

allDropdown.forEach(item => {
    const a = item.parentElement.querySelector('a:first-child');
    a.addEventListener('click', function (e) {
        e.preventDefault();

        if(!this.classList.contains('active')) {
            allDropdown.forEach(i=> {
                const aLink = i.parentElement.querySelector('a:first-child');

                aLink.classList.remove('active');
                i.classList.remove('show');
            })
        }

        this.classList.toggle('active');
        item.classList.toggle('show');
    })
})

const allProgress = document.querySelectorAll('main .card .progress');
allProgress.forEach(item=> {
    item.style.setProperty('--value', item.dataset.value)
})

function optionChange() {
    let korea = ['서울', '서귀포','제주','부산','인천','강릉', '속초', '평창','경주','여수','가평'];
    let japan = ['도쿄', '오사카', '교토', '나라', '나고야', '삿포로','후쿠오카']
    let china = ['상하이', '베이징', '홍통', '칭다오', '광저우', '항저우']
    let southEast = ['방콕','호치민시티','싱가포르','푸켓', '다낭','발리','보라카이','세부','하노이']
    let guam = ['투몬, 타무닝']
    let v = $('#country_select').val();
    let o;
    if (v == '대한민국') {
        o = korea;
    }else if ( v == '일본'){
        o = japan;
    }else if ( v == '중국'){
        o = china;
    }else if(v == '동남아'){
        o = southEast ;
    }else if(v == '괌'){
        o = guam;
    } else{
        o = [];
    }
    $('#city_select').empty();
    $('#city_select').append('<option></option>');
    for(let i = 0; i < o.length; i++){
        $('#city_select').append('<option value=' + o[i] +'>'+ o[i]+'</option>')
    }

}

