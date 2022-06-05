import React, { useState } from "react";
import products from "./productData.js";

import { Container, Header, Button, Icon } from "semantic-ui-react";
import SearchList from "./SearchList.js";
const matches = products;

export default function SearchResults(props) {
  //will take search input and render results based on that input

  let [prodList, showResults] = useState(matches);

  function findResults() {
    let searchValue = document.querySelector(".prompt").value;
    let results = [];
    products.map((item) => {
      if (Array.isArray(item.tags)) {
        return item.tags.forEach((tag) => {
          if (tag === searchValue || tag.includes(searchValue)) {
            results.push(item);
            let oldState = prodList;
            oldState = results;
            showResults(oldState);
            console.log(prodList);
          }
        });
      }
    });
  }

  function getItems() {
    return <SearchList items={prodList} />;
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
      <Header as="h2">Search Results</Header>
      <Container className="search-results">{getItems()}</Container>
    </Container>
  );
}
