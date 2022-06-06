import React, { useLocation } from "react";
import { Link } from "react-router-dom";
import { Container, Message, Header, Button } from "semantic-ui-react";
import Subtotal from "./Subtotal.js";

export default function ConfirmationPage() {
  // let location = useLocation();
  let guestInfo = window.guestInfo;

  return (
    <Container className="confirmation-page">
      <Container>
        <Link to="/">
          <Button
            content="Back to All Products"
            icon="left arrow"
            labelPosition="left"
          />
        </Link>
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
    </Container>
  );
}
