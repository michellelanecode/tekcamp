import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useLocation } from "react-router-dom";
import {
  Container,
  Header,
  Icon,
  Button,
  Input,
  Message,
  Item,
  Label,
} from "semantic-ui-react";

export default function FullProductDescription() {
  const location = useLocation();
  const product = location.state.info;
  let dropDown = [];
  let [fullProd, updateProd] = useState(product);

  function generateDropDownOptions() {
    dropDown = (
      <select class="ui dropdown">
        <option value="">Scent</option>
        <option class="item">"Sage"</option>
        <option class="item">Patchouli</option>
        <option class="item">Palo Santo</option>
        <option class="item">Wizard</option>
        <option class="item">Raspberry</option>
        <option class="item">Dragon's Blood</option>
        <option class="item">April Showers</option>
      </select>
    );
  }

  if (product.scents) {
    generateDropDownOptions();
  }

  if (product.options) {
    dropDown = (
      <select class="ui dropdown">
        <option value="">Options</option>
        <option class="item">Milk and Honey</option>
        <option class="item">The Sun and Her Flowers</option>
      </select>
    );
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

  function checkAvailability(prod) {
    if (prod.qty === 0) {
      prod.available = false;
      document.querySelector(".buy-button").setAttribute("disabled");
    }
    if (prod.qty < 10 && prod.qty > 0) {
      prod.limited = true;
    }

    updateProd(prod);
    console.log(fullProd);
  }

  function updateProductQty(bought) {
    window.products.forEach((prod) => {
      for (let key in prod) {
        if (prod[key] === product.name) {
          prod.qty = product.qty -= bought;
          checkAvailability(prod);
        }
      }
    });
  }

  function handleCart() {
    let bought = document.getElementById("prod-quantity").value;

    if (product.qty === 0) {
      return;
    }
    let cartItem = {};
    cartItem.qty = bought;
    cartItem.img = product.img;
    cartItem.name = product.name;
    cartItem.price = product.price;
    cartItem.description = product.description;

    if (!dropDown) {
      cartItem.option = document.querySelector(".dropdown").value;
    }

    window.cart.push(cartItem);
    updateProductQty(bought);
  }

  return (
    <Container text>
      <Item id="fullprod">
        {" "}
        <Link to="/">
          <Button
            content="Back to All Products"
            icon="left arrow"
            labelPosition="left"
          />
        </Link>
        <br />
        <Container>
          <Item.Image src={product.img} size="medium" />
          <Item.Image src={product.alternateView} size="medium" />
        </Container>
        <Header>{product.name}</Header> <Item.Meta>{product.price}</Item.Meta>
        <p>{stockAvailability}</p>
        <p>{product.description}</p>
        <Button as="div" labelPosition="right" class="fullprod-availability">
          <Label as="a" basic color="blue">
            Amount Available: {product.qty}{" "}
          </Label>
        </Button>
        {dropDown}
        <Message
          hidden
          error
          header="Invalid Quantity"
          content="Please select a valid quantity."
          id="error-message"
          floating
        />
        <Container id="fullprod-button">
          <Input type="number" id="prod-quantity" value={0}></Input>
          <Button.Group id="prod-increment">
            <Button icon="plus" onClick={add} />
            <Button icon="minus" onClick={minus} />
          </Button.Group>

          <Button
            className="buy-button"
            as="div"
            labelPosition="right"
            onClick={handleCart}
          >
            <Button color="blue">
              <Button.Content>
                <Icon name="shop" />
                Add to cart
              </Button.Content>
            </Button>
          </Button>
        </Container>
        <Message>
          <Message.Header>Serial:</Message.Header>
          <p> {product.serial}</p>
          <br />
          <Message.Header>Tags:</Message.Header>
          <p>{"[" + [...product.tags] + "]"}</p>
        </Message>
      </Item>
    </Container>
  );
}
