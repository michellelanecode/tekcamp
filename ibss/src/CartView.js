import React from "react";

import {
  List,
  Image,
  Container,
  Segment,
  Header,
  Button,
  Message,
} from "semantic-ui-react";
import { Link } from "react-router-dom";

import Subtotal from "./Subtotal.js";
import ProductCard from "./ProductCard.js";

export default class CartView extends React.Component {
  state = { total: 0 };
  itemTotal = 0;
  cartItems = window.cart.map((item) => {
    return this.createCartItem(item);
  });

  randomNumber = Math.floor(Math.random() * window.products.length);

  randomSelection = window.products[this.randomNumber];

  createCartItem(purchase) {
    return (
      <List.Item className="purchases">
        <Image avatar src={purchase.img} />
        <List.Content>
          <List.Header as="a">{purchase.name}</List.Header>
          <List.Header>Purchase Price: {purchase.price}</List.Header>
          <List.Header>Order Qty: {purchase.qty}</List.Header>
          <List.Description>{purchase.decription}</List.Description>
        </List.Content>
      </List.Item>
    );
  }

  render() {
    return (
      <Container className="cart-view">
        <Container>
          <Link to="/">
            <Button
              content="Back to All Products"
              icon="left arrow"
              labelPosition="left"
            />
          </Link>
          <Header as="h2">Your Cart:</Header>
          <List>
            {this.cartItems}
            <hr />
            You May Also Like:
            <Segment className="suggestion">
              <ProductCard info={this.randomSelection} />
            </Segment>
          </List>
        </Container>{" "}
        <Container>
          <Header as="h2">Checkout Total</Header>
          <Message>Please note that price includes tax</Message>
          <Subtotal />
          <Link to="/checkoutPage">
            <Button
              content="Checkout"
              icon="right arrow"
              labelPosition="right"
            />
          </Link>
        </Container>
      </Container>
    );
  }
}
