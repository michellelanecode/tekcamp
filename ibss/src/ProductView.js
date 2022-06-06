import React from "react";
import { Container, Message } from "semantic-ui-react";

import ProductCard from "./ProductCard.js";
export default function ProductView() {
  if (window.products.length === 0) {
    return (
      <Message.Header>
        {" "}
        We are all out of products! Please visit us later!{" "}
      </Message.Header>
    );
  }
  let productList = window.products.map((prod) => {
    return createProductCard(prod);
  });

  function createProductCard(info) {
    return <ProductCard info={info} />;
  }

  return (
    <Container id="products" className="ui link cards">
      {productList}
    </Container>
  );
}
