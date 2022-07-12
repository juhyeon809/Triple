
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
	window.open("roomPop.html","팝업 테스트","width=400, height=300, top=10, left=10");
}