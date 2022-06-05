import React from "react";
import { Card, Icon, Image, Button, Label } from "semantic-ui-react";
import { Link } from "react-router-dom";
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
      <div id="products" className="ui link cards">
        {this.productList}
      </div>
    );
  }
}
