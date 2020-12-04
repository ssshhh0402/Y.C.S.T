const panels = document.querySelectorAll(".panel");
panels.forEach(panel => {
    panel.addEventListener('click', () => {
        console.log(panel.classList);
        if(panel.classList.value == 'panel active'){
            removeActiveClass();
        }else{
            removeActiveClass();
            panel.classList.add('active')
        }
    })
})

function removeActiveClass(){
    panels.forEach(panel => {
        panel.classList.remove('active');
    })

}