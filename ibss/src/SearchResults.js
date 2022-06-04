import React, { useState } from "react";
import products from "./productData.js";
import { Container, Header } from "semantic-ui-react";
import ProductView from "./ProductView.js";

const matches = {};

export default function SearchResults() {
  //will take search input and render results based on that input
  let [prodList, showResults] = useState(matches);
  console.log(prodList);

  function findResults() {
    let searchValue = document.querySelector(".prompt").value;
    let results = [];
    console.log(prodList);

    products.map((item) => {
      if (Array.isArray(item.tags)) {
        return item.tags.forEach((tag) => {
          if (tag === searchValue || tag.includes(searchValue)) {
            results.push(item);
            let oldState = prodList;
            oldState = { ...results };
            showResults(oldState);
          }
        });
      }
    });
  }

  return (
    <Container className="search-results">
      <div id="search-bar" className="ui icon input">
        <input
          className="prompt"
          type="text"
          onChange={findResults}
          placeholder="Search products..."
        />
        <i className="search icon"></i>
      </div>
      <Header as="h2">Search Results</Header>
      <ProductView products={prodList} />
    </Container>
  );
}
