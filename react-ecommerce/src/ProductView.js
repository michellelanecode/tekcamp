import React from "react";
import products from "./productData.js";
export default class ProductView extends React.Component {
  state = products;

  renderProducts() {
    console.log(this.state);
  }

  createProduct() {}

  componentDidMount() {
    this.renderProducts();
  }
  render() {
    return <div className="column"></div>;
  }
}
