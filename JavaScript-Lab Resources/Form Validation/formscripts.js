const form = document.querySelector('form');
const inputList = Array.from(inputs);
const submitButton = form.querySelector('button');

// function removeError(error) {
//     error.style.visibility = "hidden";
// }

// function showError(error) {
//     error.style.visibility = "visible"
// }

// function checkIsValid(input) {
//     const error = input.nextElementSibling
//     if (!input.validity.valid) {
//         showError(error);
//     } else {
//         removeError(error)
//     }
// }


// function hasInvalidInput() {
//     inputList.some(input => {
//         return !input.validity.valid
//     })
// }

// function enableSubmitButton() {
//     submitButton.disabled = "false";
// }

// function disableSubmitButton() {
//     submitButton.disabled = "true";

// }

// function toggleSubmitButton() {
//     if (hasInvalidInput()) {
//         disableSubmitButton();
//     } else {
//         enableSubmitButton();
//     }
// }

// function setEventListeners() {
//     inputs.forEach(input => {
//         input.addEventListener('input', (evt) => {
//             checkIsValid(input);
//             toggleSubmitButton();
//         });
//     })
// }

// function enableValidation() {
//     toggleSubmitButton();
//     setEventListeners();
// }

// enableValidation();

const settings = {
    formSelector: "#form",
    inputSelector: "input",
    submitButtonSelector: ".formButton",
    inputErrorClass: "small",
};

class FormValidator {
    constructor(settings, formElement) {
        this._form = formElement;
        this._inputSelector = settings.inputSelector;
        this._inactiveButtonClass = settings.inactiveButtonClass;
        this._inputErrorClass = settings.inputErrorClass;
        this._button = submitButton;
        this._inputList = inputList;
    }

    enableValidation() {
        this._toggleButtonState();
        this._form.addEventListener("submit", (evt) => {
            evt.preventDefault();
        });

        this._setEventListeners();
    }

    _setEventListeners() {
        this._inputList.forEach((input) => {
            input.addEventListener("input", (e) => {
                this._toggleError(input);
                this._toggleButtonState();
            });
        });
    }
    _showError(error) {
        error.style.visibility = "visible";

    }

    _hideError(error) {
        error.style.visibility = "hidden";
    }

    _toggleError(input) {
        const error = input.nextElementSibling
        if (!input.validity.valid) {
            this._showError(error);
        } else {
            this._hideError(error);
        }
    }

    _enableSubmitButton() {
        this._button.disabled = false;
        this._button.classList.remove(this._inactiveButtonClass);
    }

    _disableSubmitButton() {
        this._button.disabled = true;
        this._button.classList.add(this._inactiveButtonClass);
    }

    _hasInvalidInput() {
        return this._inputList.some((input) => {
            return !input.validity.valid;
        });
    }

    _toggleButtonState() {
        if (this._hasInvalidInput()) {
            this._disableSubmitButton();
        } else {
            this._enableSubmitButton();
        }
    }
}


const setupForm = new FormValidator(settings, form);
setupForm.enableValidation();