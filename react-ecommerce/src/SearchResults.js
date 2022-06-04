import React from "react";
import products from "./productData.js";
import { Container, Header } from "semantic-ui-react";
import ProductView from "./ProductView.js";
export default class SearchResults extends React.Component {
  //will take search input and render results based on that input
  // constructor(props) {
  //   super(props);
  // }
  query = "set";
  state = { query: this.query, results: [] };

  searchProducts() {
    let results = [];
    products.map((item) => {
      if (Array.isArray(item.tags)) {
        item.tags.forEach((tag) => {
          if (tag === this.query) {
            results.push(item);
          }
        });
      }
    });

    return results;
  }

  updateResults() {
    this.setState((state) => {
      state.results = this.searchProducts();
    });
  }

  render() {
    if (1 === 1) {
      return (
        <Container className="search-results">
          <Header as="h2">Search Results</Header>{" "}
          <p>There are no items that match your query!</p>{" "}
        </Container>
      );
    }
    return <Container className="results"></Container>;
  }
}
