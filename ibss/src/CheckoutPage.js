import React from "react";
import { Form, Button, Container, Header } from "semantic-ui-react";
import { Link } from "react-router-dom";
import ConfirmationPage from "./ConfirmationPage.js";
window.guestInfo = {
  first: "Test",
  last: "User",
  address: "111 Test Lane, Apt 102, Orlando, FL 34747",
  phone: "888 - 555 - 5545",
  creditcard: "5478236589657854",
  cvv: 999,
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
      creditcard: values[4],
      cvv: values[5],
    };
    window.guestInfo = guest;
  }

  toggleConfirmation(element) {
    element.classList.toggle("confirmation-section");
  }

  render() {
    return (
      <Container className="checkout-container">
        <Header className="checkout-header">Checkout As Guest:</Header>
        <Form className="checkout-form" fluid>
          <Form.Group unstackable widths={2}>
            <Form.Input
              label="First name"
              placeholder="First name"
              value={window.guestInfo.first}
              required
            />
            <Form.Input
              label="Last name"
              placeholder="Last name"
              value={window.guestInfo.last}
              required
            />
          </Form.Group>
          <Form.Group widths={2}>
            <Form.Input
              label="Address"
              placeholder="Address"
              value={window.guestInfo.address}
              required
            />
            <Form.Input
              label="Phone"
              placeholder="Phone"
              value={window.guestInfo.phone}
              required
              onChange={(evt) => {
                this.getUser();
                this.toggleConfirmation(
                  document.querySelector(".confirmation-page")
                );
              }}
            />
          </Form.Group>

          <Form.Group unstackable widths={2}>
            <Form.Input
              label="Credit Card"
              value={window.guestInfo.creditcard}
              type="number"
              required
            />
            <Form.Input
              width={4}
              label="Security Code"
              placeholder="CVV"
              value="345"
              type="number"
              required
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
