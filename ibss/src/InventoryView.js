import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Container, Form, Button, Header } from "semantic-ui-react";

import InventoryItem from "./InventoryItem.js";

export default function InventoryView() {
  let [items, setState] = useState(window.products);

  let inventory = window.products.map((prod) => {
    return <InventoryItem item={prod} />;
  });

  function handleSubmit(target) {
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

    const newState = {
      img: values[0],
      alternateView: values[1],
      name: values[2],
      qty: values[3],
      limited: limited,
      description: values[7],
      serial: values[6],
      price: values[4],
      tags: values[5],
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
            handleSubmit(evt.target);
          }}
        >
          <Form.Input
            required
            width={6}
            type="url"
            className="input-main-img"
            label="item main image (url only)"
            value="https://images.unsplash.com/photo-1604304194650-3ba3cfa752fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
          />
          <Form.Input
            required
            width={6}
            type="url"
            className="input-alt-img"
            label="item second image (url only)"
            value="https://images.unsplash.com/photo-1616968488640-ebe4036fbe3f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
          />
          <Form.Input
            required
            width={6}
            className="input-item-name"
            label="item name"
            value="Assorted Fresh Herbs/Flowers Dried"
          />
          <Form.Input
            required
            width={6}
            className="input-item-qty"
            type="number"
            label="item qty"
            value="5"
          />
          <Form.Input
            required
            className="input-item-price"
            width={6}
            label="item price in USD"
            value="10.00"
          />
          <Form.Input
            required
            className="input-item-tags"
            width={6}
            label="item tags"
            value="`herbs dried flowers assorted`"
          />
          <Form.Input
            className="input-item-serial"
            required
            width={6}
            type="number"
            label="item serial"
            value="1346736384939"
          />

          <Form.TextArea
            label="Product Description"
            value="A bundle of dried/herbs to be used for spirtual cleaning and other needs"
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
