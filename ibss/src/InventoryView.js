import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Container, Form, Button, Header } from "semantic-ui-react";

import InventoryItem from "./InventoryItem.js";

export default function InventoryView() {
  let [items, setState] = useState(window.products);

  let inventory = window.products.map((prod) => {
    return <InventoryItem item={prod} />;
  });

  function createItem(target) {
    let values = [];
    let limited = false;
    let match = false;
    const inputs = Array.from(document.querySelectorAll("input"));
    inputs.forEach((input) => {
      values.push(input.value);
    });
    if (values[3] < 10) {
      limited = true;
    }
    let newTags = [];
    newTags.push(values[5]);
    const newState = {
      img: values[0],
      alternateView: values[1],
      name: values[2],
      qty: values[3],
      limited: limited,
      description: values[7],
      serial: values[6],
      price: values[4],
      tags: newTags,
      available: true,
    };
    window.products.forEach((prod) => {
      if (prod.name === newState.name) {
        match = true;
      }
    });
    if (!match) {
      inputs.forEach((input) => {
        input.value = "";
      });
      addItemToInvetory(newState);
    } else {
      return;
    }
    setState(newState);
  }

  function addItemToInvetory(info) {
    items = window.products;
    window.products.push(info);
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
            createItem(evt.target);
          }}
        >
          <Form.Input
            required
            width={6}
            type="url"
            className="input-main-img"
            label="item main image (url only)"
          />
          <Form.Input
            required
            width={6}
            type="url"
            className="input-alt-img"
            label="item second image (url only)"
          />
          <Form.Input
            required
            width={6}
            className="input-item-name"
            label="item name"
          />
          <Form.Input
            required
            width={6}
            className="input-item-qty"
            type="number"
            label="item qty"
          />
          <Form.Input
            required
            className="input-item-price"
            width={6}
            label="item price in USD"
          />
          <Form.Input
            required
            className="input-item-tags"
            width={6}
            label="item tags"
          />
          <Form.Input
            className="input-item-serial"
            required
            width={6}
            type="number"
            label="item serial"
          />

          <Form.TextArea
            label="Product Description"
            value="A bundle of dried/herbs to be used for spirtual cleaning and other needs"
          />

          <Form.Button>Submit</Form.Button>
        </Form>
      </Container>
    </Container>
  );
}
