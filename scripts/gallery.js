const popup = document.querySelector('.popup');
const photoPopup = document.querySelector('.popup__image-photo');
const imagePopup = document.querySelector('.popup__image');
const photoTitle = document.querySelector('.popup__image-text');
const images = document.querySelectorAll('.card__image');
const closeButton = document.querySelector(".popup__close");
const navItems = document.querySelectorAll('.header__nav-item');
const navLinks = document.querySelectorAll('.header-nav__link')


images.forEach((pic) => {
    pic.addEventListener("click", (evt) => {
        const obj = { name: evt.target.alt, link: evt.target.src };
        openImagePopup(obj)
    })
})


function playSound(soundurl) {
    new Audio(soundurl).play()
}


function openImagePopup(photoInfo) {
    photoTitle.textContent = photoInfo.name;
    photoPopup.src = photoInfo.link;
    photoPopup.alt = photoInfo.name;
    openPopup(imagePopup);
}


function closeOpenedPopup() {
    const openedPopups = document.querySelectorAll(".popup__active");
    openedPopups.forEach((openedPopup) => closePopup(openedPopup));
}


function closePopupWithEscape(evt) {
    if (evt.key === "Escape") {
        closeOpenedPopup();
    }
}

function closePopup(popupElement) {
    popupElement.classList.remove("popup__active");
    popup.classList.remove("popup__active");
    document.removeEventListener("keydown", closePopupWithEscape);
}

function openPopup(popupElement) {
    popupElement.classList.add("popup__active");
    popup.classList.add("popup__active");
    document.addEventListener("keydown", closePopupWithEscape);
}


closeButton.addEventListener("click", function(event) {
    playSound("images/Enter & Back.mp3");
    closeOpenedPopup();
});

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

images.forEach(image => {
    image.addEventListener('mouseenter', (evt) => {
        playSound('images/Eshop.mp3');
    })

})