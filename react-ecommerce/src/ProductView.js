import React from "react";
import { Card, Icon, Image } from "semantic-ui-react";
export default class ProductView extends React.Component {
  constructor(props) {
    super(props);
    this.products = props.products;
    this.state = { products: this.products, productOpen: false };
    this.productList = this.state.products.map((prod) => {
      let stockAvailability;
      if (prod.available) {
        stockAvailability = <b className="inStock">In Stock!</b>;
      } else {
        stockAvailability = <b className="outOfStock">Out of Stock</b>;
      }

      return (
        <Card>
          <Image
            className="product-image"
            src={prod.img}
            onClick={this.showFullProduct.bind(prod)}
          />
          <Card.Content>
            <Card.Header>{prod.name}</Card.Header>
            {prod.price} <p> {stockAvailability} </p>
            <Card.Meta>{prod.description}</Card.Meta>
          </Card.Content>
          <Card.Content extra>
            <span className="right floated"> IBSS &copy; </span>
            <a>
              <Icon class="cart" name="cart" />
            </a>
            <span className="product-quantity">
              {" "}
              Amount Available: {prod.qty}{" "}
            </span>
          </Card.Content>
        </Card>
      );
    });
  }

  showFullProduct() {
    console.log();
    // return (
    // <Modal onClose={this.setState}
    //   )
  }

  render() {
    return (
      <div id="products" className="ui link cards">
        {this.productList}
      </div>
    );
  }
}
