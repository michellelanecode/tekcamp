import React from "react";

import {
  List,
  Image,
  Container,
  Segment,
  Header,
  Button,
  Message,
  Icon,
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

  removeItem(element) {
    window.cart.forEach((prod) => {
      window.products.forEach((item) => {
        if (item.name === element.querySelector(".item-name").textContent) {
          item.qty += Number(prod.qty);
          if (item.qty > 10) {
            item.available = true;
            item.limited = false;
          } else if (item.qty < 10 && item.qty > 0) {
            item.limited = true;
            item.available = true;
          }
        }
      });

      if (prod.img === element.querySelector("img").src) {
        window.cart.splice(window.cart.indexOf(prod));
      }
    });
    element.remove();
    this.setState({ total: 0 });
  }

  createCartItem(purchase) {
    console.log(purchase);
    let option;
    if (purchase.option) {
      option = purchase.option;
    }
    return (
      <List.Item className="purchases">
        {" "}
        <Icon
          className="window close outline"
          onClick={(evt) => {
            this.removeItem(evt.target.parentNode);
          }}
        />
        <Image avatar src={purchase.img} />
        <List.Content>
          <List.Header as="a" className="item-name">
            {purchase.name} / {purchase.option}
          </List.Header>
          <List.Header>Purchase Price: {purchase.price}</List.Header>
          <List.Header>Order Qty: {purchase.qty}</List.Header>

          <List.Description></List.Description>
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
