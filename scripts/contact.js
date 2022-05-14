navLinks.forEach((navLink) => {
    navLink.addEventListener('click', (evt) => {
        setTimeout(function() {
            window.location.href = `../${evt.target.textContent}.html`
        }, 1000);
        playSound('images/03 - Power Up.mp3');
    });
});