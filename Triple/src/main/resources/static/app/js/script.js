
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


// /*상품등록*/
// function divplus(){
// 	const parent = document.getElementById('plusbox')
// 	const originItem = document.getElementById('plusbox')
// 	parent.appendChild(originItem.cloneNode(true));
// }

// function showPopup(){
// 	let popupX = (window.screen.width/2)-(400/2);
// 	let popupY = (window.screen.height/2) - (300/2);
// 	window.open("roomPop.html","팝업 테스트","width=400, height=300, top="+popupY+ ", left="+popupX+",screenX="+popupX+",screenY="+popupY);
// }

// function showPopup1(){
// 	let popupX = (window.screen.width/2)-(400/2);
// 	let popupY = (window.screen.height/2) - (300/2);
// 	window.open("pop-internet.html","팝업 테스트","width=400, height=300, top="+popupY+ ", left="+popupX+",screenX="+popupX+",screenY="+popupY);
// }
