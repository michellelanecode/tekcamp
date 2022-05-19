const sections = document.querySelectorAll('.question-section');

sections.forEach((section) => {
    section.addEventListener("click", function(evt) {
        evt.preventDefault();
        section.classList.toggle('bold');
        section.nextElementSibling.classList.toggle('hidden');
    })
})