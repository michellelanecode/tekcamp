import React from "react";
import products from "./productData.js";
export default class ProductView extends React.Component {
  state = products;

  renderProducts(product) {
    const productSection = document.getElementById("products");
    productSection.appendChild(product);
  }

  createProduct(productInfo) {
    const prodCardTemplate = document
      .getElementById("card")
      .content.cloneNode(true);
    prodCardTemplate.querySelector(".product-image").src = productInfo.img;
    prodCardTemplate.querySelector(".product-name").textContent =
      productInfo.name;
    prodCardTemplate.querySelector(".product-description").textContent =
      productInfo.description;
    prodCardTemplate.querySelector(".product-quantity").textContent =
      "Qty: " + productInfo.qty;
    console.log(prodCardTemplate.querySelector(".product-image"));
    return prodCardTemplate;
  }

  displayProducts() {
    this.state.products.forEach((prod) => {
      const newProduct = this.createProduct(prod);
      this.renderProducts(newProduct);
    });
  }

  componentDidMount() {
    this.displayProducts();
  }

  render() {
    return <div id="products" className="ui link cards"></div>;
  }
}
