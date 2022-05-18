const form = document.querySelector('form');
const inputs = form.querySelectorAll('input')
const inputList = Array.from(inputs);
const submitButton = form.querySelector('button');

const settings = {
    formSelector: "#form",
    inputSelector: "input",
    submitButtonSelector: ".formButton",
    inputErrorClass: "small",
};

class FormValidator {
    constructor(settings, formElement) {
        this._form = formElement;
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
    }

    _disableSubmitButton() {
        this._button.disabled = true;
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