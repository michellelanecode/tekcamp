import React from "react";
import { Container } from "semantic-ui-react";

import ProductCard from "./ProductCard.js";
export default class ProductView extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      products: { ...props.products },
      productOpened: null,
      show: true,
      modal: null,
    };

    this.productList = Object.values(this.state.products).map((prod) => {
      return this.createProductCard(prod);
    });
  }

  createProductCard(info) {
    return <ProductCard info={info} />;
  }

  render() {
    return (
      <Container id="products" className="ui link cards">
        {this.productList}
      </Container>
    );
  }
}
