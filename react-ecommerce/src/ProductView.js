import React from "react";

export default class ProductView extends React.Component {
  constructor(props) {
    super(props);

    this.products = props.products;
    this.state = { products: this.products };
    this.productList = this.state.products.map((prod) => {
      let stockAvailability;
      if (prod.available) {
        stockAvailability = <b className="inStock">In Stock!</b>;
      } else {
        stockAvailability = <b className="outOfStock">Out of Stock</b>;
      }

      return (
        <div className="card">
          <div className="prod-image image">
            <img className="product-image" src={prod.img} />
          </div>
          <div className="content product-content">
            <div className="header product-name">{prod.name}</div>
            {prod.price} <p> {stockAvailability} </p>
            <div className="description product-description">
              {prod.description}
            </div>
          </div>
          <div className="extra content">
            <span className="right floated"> IBSS &copy; </span>
            <i className="cart plus icon"></i>
            <span className="product-quantity">
              {" "}
              Amount Available: {prod.qty}{" "}
            </span>
          </div>
        </div>
      );
    });
  }

  render() {
    return (
      <div id="products" className="ui link cards">
        {this.productList}
      </div>
    );
  }
}
