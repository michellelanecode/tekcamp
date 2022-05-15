const socialIcons = document.querySelectorAll('.social-link');
const navLinks = document.querySelectorAll('.header-nav__link')
const navItems = document.querySelectorAll('.header__nav-item');

function playSound(soundurl) {
    new Audio(soundurl).play()
}

window.onload = playSound('images/17 - Coin Heaven.mp3');

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

socialIcons.forEach((icon) => {
    icon.addEventListener("mouseenter", (evt) => {
        playSound('images/Bing.mp3');
    });
})