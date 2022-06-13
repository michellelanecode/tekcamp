const navItems = document.querySelectorAll('.header__nav-item');
const navLinks = document.querySelectorAll('.header-nav__link')
const hobbies = document.querySelectorAll('.hobbies__list-item')


function playSound(soundurl) {
    new Audio(soundurl).play()
}


navItems.forEach((navItem) => {
    navItem.addEventListener('mouseenter', (evt) => {
        evt.preventDefault()
        playSound('images/Bing.mp3');
    });
    navItem.addEventListener('click', (evt) => {
        evt.preventDefault()
        setTimeout(function() {
            window.location.href = `../${evt.target.textContent}.html`
        }, 1000);
        playSound('images/03 - Power Up.mp3');
    });

});

navLinks.forEach((navLink) => {
    navLink.addEventListener('click', (evt) => {
        evt.preventDefault()
        setTimeout(function() {
            window.location.href = `../${evt.target.textContent}.html`
        }, 1000);
        playSound('images/03 - Power Up.mp3');
    });
});

hobbies.forEach((hobby) => {
    hobby.addEventListener('mouseenter', (evt) => {
        evt.preventDefault()
        playSound('images/Bing.mp3');
    });
});