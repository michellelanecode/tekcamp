import React from "react";
import { Card, Icon, Image } from "semantic-ui-react";
import { Link } from "react-router-dom";

export default class ProductView extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      products: props.products,
      productOpened: null,
      show: true,
      modal: null,
    };
    this.productList = this.state.products.map((prod) => {
      return this.createProductCard(prod);
    });
  }

  createProductCard(info) {
    let stockAvailability;
    if (info.available && info.qty >= 10) {
      stockAvailability = <b className="inStock">In Stock!</b>;
    } else if (!info.available) {
      stockAvailability = <b className="outOfStock">Out of Stock</b>;
    } else if (info.available && info.qty < 10) {
      info.limited = true;
      stockAvailability = <b className="limitedStock">Limited Stock!</b>;
    }

    const card = (
      <Card>
        <Link to="/fullProd">
          <Image className="product-image" src={info.img} />
        </Link>
        <Card.Content>
          <Card.Header>{info.name}</Card.Header>
          {info.price} <p> {stockAvailability} </p>
          <Card.Meta>{info.description}</Card.Meta>
        </Card.Content>
        <Card.Content extra>
          <span className="right floated"> IBSS &copy; </span>
          <a>
            <Icon className="cart" name="cart" />
          </a>
          <span className="product-quantity">
            {" "}
            Amount Available: {info.qty}{" "}
          </span>
        </Card.Content>
      </Card>
    );
    return card;
  }

  render() {
    return (
      <div id="products" className="ui link cards">
        {this.productList}
      </div>
    );
  }
}
