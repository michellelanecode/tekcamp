import React from "react";
import { List, Image, Container, Segment, Header } from "semantic-ui-react";
import products from "./productData.js";
import cart from "./Cart.js";
import Subtotal from "./Subtotal.js";
import ProductCard from "./ProductCard.js";
export default class CartView extends React.Component {
  state = { total: 0 };
  itemTotal = 0;
  cartItems = cart.map((item) => {
    return this.createCartItem(item);
  });

  randomNumber = Math.floor(Math.random() * products.length);

  randomSelection = products[this.randomNumber];

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
          <Header as="h2">Checkout:</Header>
          <Subtotal />
        </Container>
      </Container>
    );
  }
}
