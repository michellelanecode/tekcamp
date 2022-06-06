import React from "react";
import { useNavigate } from "react-router-dom";
import {
  Container,
  Message,
  Header,
  Button,
  Segment,
  Dimmer,
  Loader,
} from "semantic-ui-react";
import Subtotal from "./Subtotal.js";

export default function ConfirmationPage() {
  let guestInfo = window.guestInfo;
  let navigate = useNavigate();
  function clearCart() {
    let loadingView = document.querySelector(".loading-page");
    window.cart = [];

    loadingView.classList.add("active");

    setTimeout(() => {
      navigate("/");
    }, 3000);
  }

  return (
    <Segment className="confirmation-page">
      <Dimmer className="loading-page">
        <Loader size="large">Loading</Loader>
      </Dimmer>
      <Container>
        <Button
          content="Back to All Products"
          icon="left arrow"
          labelPosition="left"
          onClick={clearCart}
        />
      </Container>
      <Container>
        <Message>
          <Header>
            {" "}
            Thank you for your purchase! We have received your order!{" "}
          </Header>
          <Subtotal />
        </Message>
      </Container>
      <Container>
        <Message>Will be delivered to:</Message>
        <Message.Content className="confirmation-description">
          <Header>
            {guestInfo.first} {guestInfo.last}
          </Header>
          <p>{guestInfo.address}</p>
          <p>{guestInfo.phone}</p>
        </Message.Content>
      </Container>
    </Segment>
  );
}
