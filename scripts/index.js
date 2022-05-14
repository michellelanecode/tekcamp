const navItems = document.querySelectorAll('.header__nav-item');
const navLinks = document.querySelectorAll('.header-nav__link')



function playSound(soundurl) {
    new Audio(soundurl).play()
}


navItems.forEach((navItem) => {
    navItem.addEventListener('mouseenter', (evt) => {
        playSound('images/Bing.mp3');
    });
});

navLinks.forEach((navLink) => {
    navLink.addEventListener('click', (evt) => {
        setTimeout(function() {
            window.location.href = `../${evt.target.textContent}.html`
        }, 1000);
        playSound('images/03 - Power Up.mp3');
    });
});