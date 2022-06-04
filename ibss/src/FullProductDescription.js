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
} from "semantic-ui-react";
import products from "./productData.js";

export default function FullProductDescription() {
  const location = useLocation();
  const product = location.state.info;

  let stockAvailability;
  if (product.available && product.qty >= 10) {
    stockAvailability = <b className="inStock">In Stock!</b>;
  } else if (!product.available) {
    stockAvailability = <b className="outOfStock">Out of Stock</b>;
  } else if (product.available && product.qty < 10) {
    product.limited = true;
    stockAvailability = <b className="limitedStock">Limited Stock!</b>;
  }

  function updateQuantity() {
    product.qty = 2;

    products.forEach((prod) => {
      prod.qty = product.qty;
    });
  }

  return (
    <Container className="fullprod-button" text>
      <Breadcrumb>
        <Breadcrumb.Section link>
          <Link to="/">
            <Button id="back-button" onClick={updateQuantity}>
              Back
            </Button>
          </Link>
        </Breadcrumb.Section>
      </Breadcrumb>
      <Image src={product.img} size="large" />
      <Header>{product.name}</Header> <p>{product.price}</p>
      <p>{stockAvailability}</p>
      <p>{product.description}</p>
      <Container id="fullprod-button">
        <Input id="prod-quantity" value={product.qty}></Input>
        <Button.Group id="prod-increment">
          <Button icon="plus" />
          <Button icon="minus" />
        </Button.Group>
        <Button as="div" labelPosition="right">
          <Button color="blue">
            <Button.Content>
              <Icon name="shop" />
              Add to cart
            </Button.Content>
          </Button>
        </Button>
      </Container>
    </Container>
  );
}
