const prev = document.getElementById("prev");
const next = document.getElementById("next");
const circles = document.querySelectorAll(".circle");
const progress = document.getElementById("progress");
var now = 1;

prev.addEventListener('click', () => {
    now -= 1;
    if (now < 1){
        now = 1;
    }
    checking();
});

next.addEventListener('click', () => {
    now += 1;
    if(now > circles.length){
        now = circles.length;
    }
    checking();
})

function checking(){
    circles.forEach((circle, idx) => {
        if(idx < now){
            circle.classList.add('active');
        }else{
            circle.classList.remove('active');
        }
    const actives = document.querySelectorAll(".active");
    progress.style.width = ((actives.length-1) / (circles.length - 1) * 100)  + "%"
    if(now == 1){
        prev.disabled = true;
    }else if(now == circles.length){
        next.disabled = true;
    }else{
        prev.disabled = false;
        next.disabled = false;
    }
})
}

