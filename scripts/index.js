const popup = document.querySelector('.popup');
const photoPopup = document.querySelector('.popup__image-photo');
const imagePopup = document.querySelector('.popup__image');
const photoTitle = document.querySelector('.popup__image-text');
const images = document.querySelectorAll('.card__image');
const closeButton = document.querySelector(".popup__close");
const audio = document.querySelector('.clickAudio');

console.log(audio);


images.forEach((pic) => {
    pic.addEventListener("click", (evt) => {
        const obj = { name: evt.target.alt, link: evt.target.src };
        openImagePopup(obj)
    })
})


const openImagePopup = function(photoInfo) {
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
    closeOpenedPopup();
});





// galleryButton.addEventListener("click", (evt) => {
//     evt.preventDefault();
//     openPopup(gallery)
// });

// contactButton.addEventListener("click", (evt) => {
//     evt.preventDefault();
//     console.log(contact)
//     openPopup(contact)
// });