const form = document.querySelector('form');
const inputs = document.querySelectorAll('input');
const inputList = Array.from(inputs);
const submitButton = document.querySelector('.formButton');

function removeError(error) {
    error.style.visibility = "hidden";
}

function showError(error) {
    error.style.visibility = "visible"
}

function checkIsValid(input) {
    const error = input.nextElementSibling
    if (input.validity.valid) {
        removeError(error);
    } else {
        showError(error)
    }
}


function hasInvalidInput() {
    inputList.some(input => {
        return !input.validity.valid;
    })
}

function enableSubmitButton() {
    submitButton.disabled = false;
}

function disableSubmitButton() {
    submitButton.disabled = true;

}

function toggleSubmitButton() {
    if (hasInvalidInput()) {
        disableSubmitButton();
    } else {
        enableSubmitButton();
    }
}



function enableValidation() {
    toggleSubmitButton();
    inputs.forEach(input => {
        input.addEventListener('input', (evt) => {
            evt.preventDefault();
            checkIsValid(input);
            toggleSubmitButton();
        });
    })
}

enableValidation();