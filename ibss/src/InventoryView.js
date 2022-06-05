import React from "react";
import { Container, List, Image, Card, Item, Icon } from "semantic-ui-react";
import products from "./productData.js";

export default class InventoryView extends React.Component {
  constructor(props) {
    super(props);

    this.inventory = products.map((prod) => {
      let availability;
      if (prod.available) {
        availability = "true";
      } else {
        availability = "false";
      }

      const listItem = (
        <Item id="inventory-items">
          <Item.Meta verticalAlign="middle">
            <Item.Image size="tiny" src={prod.img} />
            <br />
            <br />
            <Item.Meta verticalAlign="middle">
              <b>Item Name:</b>
              <p>{prod.name}</p>
              <b>Serial:</b> <p>{prod.serial}</p>
              <b>Price:</b>
              <p>{prod.price}</p>
              <b>Item description:</b>
              <p>{prod.description}</p>
            </Item.Meta>
          </Item.Meta>
        </Item>
      );
      return listItem;
    });
  }

  render() {
    return (
      <Container id="inventory-management">
        <Item.Group id="inventory">{this.inventory}</Item.Group>
        <Container id="inventory-toggling"></Container>
      </Container>
    );
  }
}
