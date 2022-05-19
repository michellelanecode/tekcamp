const sections = document.querySelectorAll('.question-section');

sections.forEach((section) => {
    section.addEventListener("click", function(evt) {
        evt.preventDefault();
        section.style.fontWeight = 900;
        section.nextElementSibling.classList.toggle('hidden');
    })
})