import React from "react";
import products from "./productData.js";
import { Link } from "react-router-dom";
import { Container, Header, Card, Image, Icon } from "semantic-ui-react";
import ProductView from "./ProductView.js";

let initialState = { isLoading: false, results: [], value: "" };
const source = products;

export default class SearchResults extends React.Component {
  //will take search input and render results based on that input
  constructor(props) {
    super(props);
    console.log(products);
    this.state = { results: [] };
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

  showResults() {
    let searchValue = document.querySelector(".prompt").value;
    let resultArea = document.querySelector(".search-results");
    let found = [];
    products.map((item) => {
      if (Array.isArray(item.tags)) {
        return item.tags.forEach((tag) => {
          if (tag === searchValue || tag.includes(searchValue)) {
            found.push(item);
          }
        });
      }
    });
    if (found.length === 0) {
      return (
        <p className="search-result-empty">
          There are no items that match your query!
        </p>
      );
    } else {
      let prod = this.createProductCard(item);
      resultArea.appendChild(prod);
    }
  }

  render() {
    // if (this.state.results.length === 0) {
    return (
      <Container className="search-results">
        <div id="search-bar" className="ui icon input">
          <input
            className="prompt"
            onChange={this.showResults}
            type="text"
            placeholder="Search products..."
          />
          <i className="search icon"></i>
        </div>
        <Header as="h2">Search Results</Header>{" "}
      </Container>
    );
    // }
    // return (
    //   <Container className="results">
    //     <ProductView products={this.state.results} />
    //   </Container>
    // );
  }
}
