import React, { useState } from "react";
import {
  Container,
  Header,
  Button,
  Form,
  Image,
  Segment,
  Dimmer,
  Loader,
  Input,
  Message,
} from "semantic-ui-react";
import { Link, useLocation, useNavigate } from "react-router-dom";
export default function ItemUpdate() {
  const props = useLocation().state;
  const navigate = useNavigate();
  let [updatedProd, updater] = useState({
    mainImg: "",
    altImg: "",
    newname: "",
    newqty: "",
    newprice: "",
    newTags: "",
    newSerial: "",
    newdescription: "",
  });

  function removeError() {
    let errormsg = document.querySelector(".login-error");
    let successmsg = document.querySelector(".login-success");
    errormsg.classList.add("hidden");
    successmsg.classList.remove("hidden");
  }

  function validateSubmit() {
    removeError();
    findItem();
  }

  function findItem() {
    window.products.forEach((item) => {
      if (item.name === props.name) {
        updateInventory(item);
      }
    });
  }

  function updateInventory(product) {
    let loadingView = document.querySelector(".loading-page");

    let newProduct = {};

    newProduct.img = updatedProd.mainImg;
    newProduct.alternateView = updatedProd.altImg;
    newProduct.name = updatedProd.newname;
    newProduct.qty = updatedProd.newqty;
    newProduct.price = updatedProd.newprice;
    newProduct.tags = updatedProd.newTags;
    newProduct.serial = updatedProd.newSerial;
    newProduct.description = updatedProd.newdescription;

    if (updatedProd.newqty === 0) {
      newProduct.available = false;
    } else {
      newProduct.available = true;
    }
    if (updatedProd.newqty < 10) {
      newProduct.limited = true;
    } else {
      newProduct.limited = false;
    }

    window.products.splice(window.products.indexOf(product), 1);

    window.products.push(newProduct);
    updater(newProduct);
    setTimeout(() => {
      loadingView.classList.add("active");
      navigate("/inventory");
    }, 3000);
  }

  return (
    <Segment className="confirmation-page">
      <Dimmer className="loading-page">
        <Loader size="large">Loading</Loader>
      </Dimmer>
      <Container className="inventory-single-item">
        <Link to="/inventory">
          <Button
            content="Back to inventory"
            icon="left arrow"
            labelPosition="left"
          />
        </Link>
        <Header as="h2" className="inventory-item-update">
          Inventory Item Information
        </Header>
        <Container className="single-item-photo">
          <Image src={props.img} size="small" />
          <Image src={props.alternateView} size="small" />
        </Container>
        <Message
          className="login-error error "
          header="Invalid Information"
          content="Please Make Sure All Fields Are Valid"
        />
        <Message
          success
          className="login-success success hidden"
          header="Success"
          content="Success! You are being redirected to inventory page."
        />
        <Form>
          <Input
            required
            width={16}
            type="url"
            onChange={(evt) => {
              updatedProd.mainImg = evt.target.value;
            }}
            id="input-main-img"
            label="item main image url"
          />
          <Input
            required
            width={16}
            type="url"
            onChange={(evt) => {
              updatedProd.altImg = evt.target.value;
            }}
            id="input-alt-img"
            label="item second image url"
          />
          <Input
            required
            width={16}
            onChange={(evt) => {
              updatedProd.newname = evt.target.value;
            }}
            id="input-item-name"
            label="item name"
          />
          <Input
            required
            width={16}
            onChange={(evt) => {
              updatedProd.newqty = evt.target.value;
            }}
            id="input-item-qty"
            type="number"
            label="item qty"
          />
          <Input
            required
            id="input-item-price"
            width={16}
            onChange={(evt) => {
              updatedProd.newprice = evt.target.value;
            }}
            label="item price in USD"
          />
          <Input
            required
            id="input-item-tags"
            width={16}
            onChange={(evt) => {
              updatedProd.newTags = evt.target.value.split(",");
            }}
            label="item tags"
          />
          <Input
            id="input-item-serial"
            required
            width={16}
            onChange={(evt) => {
              updatedProd.newSerial = evt.target.value;
            }}
            type="number"
            label="item serial"
          />

          <Form.TextArea
            label="Product Description"
            onChange={(evt) => {
              updatedProd.newdescription = evt.target.value;
            }}
          />

          <Form.Button onClick={validateSubmit}>Submit</Form.Button>
        </Form>
      </Container>
    </Segment>
  );
}
