import React from "react";
import { Form, Button, Container } from "semantic-ui-react";

import ConfirmationPage from "./ConfirmationPage.js";
export default class CheckoutPage extends React.Component {
  state = {};

  getUser() {
    let inputs = Array.from(document.querySelectorAll("input"));
    let values = [];

    inputs.forEach((input) => {
      values.push(input.value);
    });
    this.guest = {
      first: values[0],
      last: values[1],
      address: values[2],
      phone: values[3],
    };

    this.setState(this.guest);
  }

  toggleConfirmation(element) {
    element.classList.toggle("confirmation-section");
  }

  render() {
    return (
      <Container>
        <Form
          className="checkout-form"
          fluid
          onSubmit={(evt) => {
            this.getUser();
            this.toggleConfirmation(
              document.querySelector(".confirmation-page")
            );
          }}
        >
          <Form.Group unstackable widths={2}>
            <Form.Input label="First name" placeholder="First name" required />
            <Form.Input label="Last name" placeholder="Last name" required />
          </Form.Group>
          <Form.Group widths={2}>
            <Form.Input label="Address" placeholder="Address" required />
            <Form.Input label="Phone" placeholder="Phone" required />
          </Form.Group>
          <Form.Checkbox label="I agree to the Terms and Conditions" required />
          <Button type="submit">Submit</Button>
        </Form>

        <Container className="confirmation-section confirmation-page">
          <ConfirmationPage user={this.state} />
        </Container>
      </Container>
    );
  }
}
