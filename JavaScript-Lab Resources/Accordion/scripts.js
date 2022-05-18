const sections = document.querySelectorAll('.question-section');

sections.forEach((section) => {
    section.addEventListener("click", function(evt) {
        evt.preventDefault();
        section.nextElementSibling.classList.toggle('hidden');
    })
})