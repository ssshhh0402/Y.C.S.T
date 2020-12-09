const openB = document.getElementById("open");
const closeB = document.getElementById("close");
const container = document.querySelector(".container");
openB.addEventListener('click', () => {
    container.classList.add("show-nav");
})

closeB.addEventListener('click', () => {
    container.classList.remove("show-nav");
})