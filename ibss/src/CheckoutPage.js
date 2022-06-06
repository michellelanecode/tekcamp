import React from "react";
import { Form, Button, Container, Header } from "semantic-ui-react";
import { Link } from "react-router-dom";
import ConfirmationPage from "./ConfirmationPage.js";
window.guestInfo = {
  first: "firstname",
  last: "lastname",
  address: "test",
  phone: 666 - 666 - 666,
};
export default class CheckoutPage extends React.Component {
  getUser() {
    let inputs = Array.from(document.querySelectorAll("input"));
    let values = [];

    inputs.forEach((input) => {
      values.push(input.value);
    });
    let guest = {
      first: values[0],
      last: values[1],
      address: values[2],
      phone: values[3],
    };
    window.guestInfo = guest;
  }

  toggleConfirmation(element) {
    element.classList.toggle("confirmation-section");
  }

  render() {
    return (
      <Container>
        <Header>Hello Guest!</Header>
        <Form className="checkout-form" fluid>
          <Form.Group unstackable widths={2}>
            <Form.Input label="First name" placeholder="First name" required />
            <Form.Input label="Last name" placeholder="Last name" required />
          </Form.Group>
          <Form.Group widths={2}>
            <Form.Input label="Address" placeholder="Address" required />
            <Form.Input
              label="Phone"
              placeholder="Phone"
              required
              onChange={(evt) => {
                this.getUser();
                this.toggleConfirmation(
                  document.querySelector(".confirmation-page")
                );
              }}
            />
          </Form.Group>
          <Form.Checkbox label="I agree to the Terms and Conditions" required />
          <Link to="/confirmation" state={this.guest}>
            <Button type="submit">Submit</Button>
          </Link>
        </Form>
      </Container>
    );
  }
}
