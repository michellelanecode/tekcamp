import React, { useState } from "react";
import products from "./productData.js";

import { Container, Header, Button, Icon } from "semantic-ui-react";
import ProductCard from "./ProductCard.js";
import SearchList from "./SearchList.js";
const matches = [];

export default function SearchResults(props) {
  //will take search input and render results based on that input

  let [prodList, showResults] = useState(matches);

  let randomNumber = Math.floor(Math.random() * products.length);

  let randomSelection = products[randomNumber];

  function findResults() {
    let searchValue = document.querySelector(".prompt").value;

    if (searchValue.length > 0) {
      updateResults(searchValue);
    } else {
      showResults(matches);
    }
  }

  function updateResults(searchValue) {
    let results = [];
    products.map((item) => {
      return item.tags.forEach((tag) => {
        if (tag === searchValue) {
          results.push(item);
          let oldState = prodList;
          oldState = results;
          showResults(oldState);
          console.log(prodList);
        }
      });
    });
  }

  function getItems() {
    if (prodList.length === 0) {
      return (
        <Container className="not-found">
          <Header>No Results Found</Header>Maybe you'll be interested in:
          <ProductCard info={randomSelection} />
        </Container>
      );
    } else {
      return <SearchList items={prodList} />;
    }
  }

  return (
    <Container className="search-list">
      <div id="search-bar" className="ui icon input">
        <input
          className="prompt"
          type="text"
          onChange={findResults}
          placeholder="Search products..."
        />
        <Button icon onClick={getItems}>
          <Icon name="search" />
        </Button>
      </div>
      <Header className="results-header" as="h2">
        Search Results:
      </Header>
      <Container className="search-results">{getItems()}</Container>
    </Container>
  );
}
