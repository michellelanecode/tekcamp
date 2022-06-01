import React from "react";
import SearchResults from "./SearchResults.js";
export default class SearchView extends React.Component {
  render() {
    return (
      <div className="ui search">
        <input
          className="prompt"
          type="text"
          placeholder="Search for products..."
        ></input>
        <SearchResults />
      </div>
    );
  }
}
