import React from "react";
import { Container } from "semantic-ui-react";

import ProductCard from "./ProductCard.js";
export default function ProductView() {
  let state = {
    products: window.products,
    productOpened: null,
    show: true,
    modal: null,
  };

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
