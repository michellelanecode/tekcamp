import React from "react";
import { Card, Icon, Image, Modal, Header, Button } from "semantic-ui-react";
import ProductModal from "./ProductModal";
// import ProductModal from "./ProductModal.js";
export default class ProductView extends React.Component {
  constructor(props) {
    super(props);
    this.products = props.products;
    this.state = {
      products: this.products,
      productOpened: null,
      show: false,
    };
    this.productList = this.state.products.map((prod) => {
      return this.createProductCard(prod);
    });
    this.modal = (
      <Modal trigger={this.props.productOpened} open={this.state.show}>
        <Modal.Header>Select a Photo</Modal.Header>
        <Modal.Content image>
          <Image size="medium" src="/images/avatar/large/rachel.png" wrapped />
          <Modal.Description>
            <Header>Default Profile Image</Header>
            <p>
              We've found the following gravatar image associated with your
              e-mail address.
            </p>
            <p>Is it okay to use this photo?</p>
          </Modal.Description>
        </Modal.Content>
        <Modal.Actions>
          <Button
            content="Yep, that's me"
            labelPosition="right"
            icon="checkmark"
            onClick={this.showModal}
            positive
          />
        </Modal.Actions>
      </Modal>
    );
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
        <Image
          className="product-image"
          src={info.img}
          onClick={(evt) => {
            this.showModal(evt.target);
          }}
        />
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

  showModal(prod) {
    this.setState({ productOpened: prod, show: !this.state.show });
    console.log(this.state.show);
  }

  render() {
    return (
      <div id="products" className="ui link cards">
        <ProductModal
          show={this.state.show}
          modal={this.modal}
          prod={this.productOpened}
        />
        {this.productList}
      </div>
    );
  }
}
