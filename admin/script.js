
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


/*상품등록*/
function divplus(){
	const parent = document.getElementById('bottombox')
	const originItem = document.getElementById('btn')
	parent.appendChild(originItem.cloneNode(true));
} 

function showPopup(){
	let popupX = (window.screen.width/2)-(400/2);
	let popupY = (window.screen.height/2) - (300/2);
	window.open("roomPop.html","팝업 테스트","width=400, height=300, top="+popupY+ ", left="+popupX+",screenX="+popupX+",screenY="+popupY);
}

let URLSearch = new URLSearchParams(location.search);
let name = URLSearch.get('name');
// url 파라미터중에 글씨가 굵어질 a태그의 번호를 detail로 지정
let detail = URLSearch.get('detail');

// 페이지 진입시 바로 css 적용시켜야 되므로 함수로 만들어주기(매개변수로 show될 ul 태그와 글씨가 굵어질 a태그의 번호 받기)
function checkPage(name, detail){
    let box = document.getElementById(name);
    let page = document.getElementById(name+detail);
    // 해당 ul 태그 show
    box.classList.remove('hide');
    // 해당 a 태그 배경색상 변경
    page.style.backgroundColor = 'red';
}
function showDetail(btn){
    // span 태그 클릭시 해당 클래스값을 id값으로 가지고 있는 ul태그를 show
    let index = btn.classList[0];
    // show될 ul태그가 span 태그 안이 아닌 옆에(형제) 있으므로 nextElementSibling으로 찾아주고
    let next = btn.nextElementSibling;
    // show 또는 hide 시켜주기(toggle 사용)
    next.classList.toggle('hide');
}

checkPage(name, detail);