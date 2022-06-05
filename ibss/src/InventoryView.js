import React from "react";
import { Container, Form, Item, Icon, Header } from "semantic-ui-react";
import products from "./productData.js";

const info = products[0];
export default class InventoryView extends React.Component {
  constructor() {
    super();
    this.state = info;

    this.inventory = products.map((prod) => {
      let availability, limited;
      if (prod.available) {
        availability = "Yes";
      } else {
        availability = "Yes";
      }
      if (prod.limited) {
        limited = "Limited Stock";
      } else {
        limited = "In Stock";
      }

      const listItem = (
        <Container className="inventory-items">
          <Icon
            className="window close outline"
            onClick={(evt) => {
              this.test(evt.target);
            }}
          />
          <br />
          <Container className="inventory-description">
            <Item.Meta>
              <h3>{prod.name}</h3>
              <p>
                <b>Price:</b> {prod.price}
              </p>
              <p>
                <b>Qty:</b> {prod.qty}{" "}
              </p>
              <p>
                <b>Availability:</b> {availability}
              </p>
            </Item.Meta>

            <Item className="inventory-item-info">
              <p>
                <b>Stock Limitations:</b> {limited}
              </p>
              <p>
                <b>Serial No:</b> {prod.serial}
              </p>
              <b>Current Item Description:</b> {prod.description}
              <p>
                <b>Product Tags:</b>
                {"[" + [...prod.tags] + "]"}
              </p>
              <br />
              <b>Product Images:</b> <br />
              <Item.Image src={prod.img} size="tiny" />{" "}
              <Item.Image src={prod.alternateView} size="tiny" />{" "}
            </Item>
          </Container>
        </Container>
      );
      return listItem;
    });
  }

  handleSubmit = (target) => {
    let values = [];
    let limited = false;
    const inputs = Array.from(document.querySelectorAll("input"));
    inputs.forEach((input) => {
      values.push(input.value);
    });
    if (values[3] < 10) {
      limited = true;
    }
    const newState = {
      img: values[0],
      alternateView: values[1],
      name: values[2],
      qty: values[3],
      limited: limited,
      description: values[7],
      serial: values[6],
      price: values[4],
      tags: [...values[5]],
      available: true,
    };
    let newProducts = products;
    newProducts.push(newState);
    products = newProducts;
    this.setState(newState);
  };

  addItemToInvetory(info) {}

  test() {
    console.log("working");
  }

  render() {
    return (
      <Container id="inventory-management">
        {this.inventory}
        <Container id="inventory-toggling">
          <Header as="h2">Add to Inventory</Header>
          <Form
            onSubmit={(evt) => {
              this.handleSubmit();
            }}
          >
            <Form.Input
              required
              width={6}
              type="url"
              className="input-main-img"
              label="item main image (url only)"
              placeholder="url"
            />
            <Form.Input
              required
              width={6}
              type="url"
              className="input-alt-img"
              label="item second image (url only)"
              placeholder="url"
            />
            <Form.Input
              required
              width={6}
              className="input-item-name"
              label="item name"
              placeholder="name"
            />
            <Form.Input
              required
              width={6}
              className="input-item-qty"
              type="number"
              label="item qty"
              placeholder="0"
            />
            <Form.Input
              required
              className="input-item-price"
              width={6}
              label="item price in USD"
              placeholder="$"
            />
            <Form.Input
              required
              className="input-item-tags"
              width={6}
              label="item tags (seperate with comma)"
              placeholder="tag, tag"
            />
            <Form.Input
              className="input-item-serial"
              required
              width={6}
              type="number"
              label="item serial"
              placeholder="serial"
            />

            <Form.TextArea
              label="Product Description"
              placeholder="Product Description..."
            />

            <Form.Button>Submit</Form.Button>
          </Form>
        </Container>
      </Container>
    );
  }
}
