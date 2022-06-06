import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Container, Form, Button, Header, Segment } from "semantic-ui-react";
import products from "./productData.js";
import InventoryItem from "./InventoryItem.js";
const info = products[0];
export default function InventoryView() {
  let [items, setState] = useState(window.products);

  let inventory = window.products.map((prod) => {
    return <InventoryItem item={prod} />;
  });

  function handleSubmit(target) {
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
    let newProducts = items;
    items.push(newState);
    console.log(items);
    window.products = newProducts;
    setState(newState);
  }

  function addItemToInvetory(info) {}

  function test() {
    console.log("working");
  }

  return (
    <Container id="inventory-management">
      <Container className="inventory-backButton">
        <Link to="/">
          <Button content="View All Products"></Button>
        </Link>
      </Container>
      <br />
      <br />
      {inventory}
      <Container id="inventory-toggling">
        <Header as="h2">Add to Inventory</Header>
        <Form
          onSubmit={(evt) => {
            handleSubmit(evt.target);
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

          <Form.Button
            onClick={(evt) => {
              handleSubmit(evt.target);
            }}
          >
            Submit
          </Form.Button>
        </Form>
      </Container>
    </Container>
  );
}
