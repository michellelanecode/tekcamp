const form = document.querySelector('form');
const inputs = document.querySelectorAll('input');
const inputList = Array.from(inputs);

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

function enableSubmitButton(button) {
    button.disabled = false;

}

function disableSubmitButton(button) {
    button.disabled = true;

}

function toggleSubmitButton(button) {
    if (this.hasInvalidInput()) {
        disableSubmitButton();
    } else {
        enableSubmitButton();
    }
}

inputs.forEach(input => {
    input.addEventListener('input', (evt) => {
        checkIsValid(input);
    })
})

function enableValidation() {
    toggleSubmitButton();

}