import React from "react";
import { Container, Message, Header } from "semantic-ui-react";
import Subtotal from "./Subtotal.js";

export default class ConfirmationPage extends React.Component {
  constructor(props) {
    super(props);
    this.user = props.user;
    console.log(props.user);
  }
  render() {
    return (
      <Container className="confirmation-page">
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
          <Message.Content>{this.user.name}</Message.Content>
        </Container>
      </Container>
    );
  }
}
