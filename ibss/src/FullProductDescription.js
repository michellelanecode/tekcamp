import React from "react";
import { Link } from "react-router-dom";
import { useLocation } from "react-router-dom";
import {
  Container,
  Header,
  Image,
  Icon,
  Button,
  Breadcrumb,
  Input,
  Message,
  Dropdown,
} from "semantic-ui-react";

import products from "./productData.js";

export default function FullProductDescription() {
  const location = useLocation();
  const product = location.state.info;
  const dropdownOptions = [];
  let dropDown = "";
  function generateDropDownOptions(scentList) {
    scentList.forEach((scent) => {
      let scentOption = {};
      scentOption = { key: null, text: scent, value: null };
      dropdownOptions.push(scentOption);
    });
    dropDown = (
      <Dropdown
        id="options"
        fluid
        multiple
        search
        selection
        options={dropdownOptions}
      />
    );
  }

  if (product.scents) {
    generateDropDownOptions(product.scents);
  }

  let stockAvailability;
  if (product.available && product.qty >= 10) {
    stockAvailability = <b className="inStock">In Stock!</b>;
  } else if (!product.available) {
    stockAvailability = <b className="outOfStock">Out of Stock</b>;
  } else if (product.available && product.qty < 10) {
    product.limited = true;
    stockAvailability = <b className="limitedStock">Limited Stock!</b>;
  }

  function add() {
    let quantity = parseInt(document.getElementById("prod-quantity").value);
    const error = document.getElementById("error-message");
    if (quantity < product.qty) {
      error.classList.add("hidden");
      quantity++;
      document.getElementById("prod-quantity").value = quantity;
    } else {
      error.classList.remove("hidden");
      return;
    }
  }

  function minus() {
    let quantity = parseInt(document.getElementById("prod-quantity").value);
    const error = document.getElementById("error-message");

    if (quantity >= 1) {
      error.classList.add("hidden");
      quantity--;
      document.getElementById("prod-quantity").value = quantity;
    } else {
      error.classList.remove("hidden");
    }
  }

  return (
    <Container className="fullprod-button" text>
      <Breadcrumb>
        <Breadcrumb.Section link>
          <Link to="/">
            <Button id="back-button">Back</Button>
          </Link>
        </Breadcrumb.Section>
      </Breadcrumb>
      <Image src={product.img} size="large" />
      <Header>{product.name}</Header> <p>{product.price}</p>
      <p>{stockAvailability}</p>
      <p>{product.description}</p>
      {dropDown}
      <Message className="" id="error-message" floating>
        Invalid Quantity Selected!
      </Message>
      <Container id="fullprod-button">
        <Input type="number" id="prod-quantity" value={0}></Input>
        <Button.Group id="prod-increment">
          <Button icon="plus" onClick={add} />
          <Button icon="minus" onClick={minus} />
        </Button.Group>
      </Container>
      <Button as="div" labelPosition="right">
        <Button color="blue">
          <Button.Content>
            <Icon name="shop" />
            Add to cart
          </Button.Content>
        </Button>
      </Button>
    </Container>
  );
}
