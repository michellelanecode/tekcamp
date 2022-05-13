const popup = document.querySelector('.popup');
const gallery = document.getElementById("gallery");
const galleryButton = document.querySelector('.galleryButton')
const contact = document.getElementById("contact");
const contactButton = document.querySelector('.contactButton');

function closePopupWithEscape(event) {
    if (event.key === "Escape") {
        closeOpenedPopup();
    }
}

function closeOpenedPopup() {
    const openedPopups = document.querySelectorAll(".popup__container_active");
    openedPopups.forEach((openedPopup) => closePopup(openedPopup));
}


function closePopup(popupElement) {
    popupElement.classList.remove("popup__active");
    popup.classList.remove("popup__container_active");
    document.removeEventListener("keydown", closePopupWithEscape);
}

function openPopup(popupElement) {
    popupElement.classList.add("popup__active");
    popup.classList.add("popup__active");
    document.addEventListener("keydown", closePopupWithEscape);
}

function openImagePopup() {



}

galleryButton.addEventListener("click", (evt) => {
    evt.preventDefault();
    openPopup(gallery)
});

contactButton.addEventListener("click", (evt) => {
    evt.preventDefault();
    console.log(contact)
    openPopup(contact)
});

// const homeButton = document.querySelector(".homeButton");
// homeButton.addEventListener("click", (evt) => {
//     evt.preventDefault();
//     console.log(evt.target)
//     clearPage();
//     addNewBody(homeClone)
// });