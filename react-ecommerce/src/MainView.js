import React from "react";
import Header from "./Header.js";
import ProductView from "./ProductView.js";
export default class MainView extends React.Component {
  render() {
    return (
      <div id="main-container" className="one column ui stackable grid">
        <div className="column">
          <Header />
          <div id="product-container" className="column">
            <ProductView />
          </div>
        </div>
      </div>
    );
  }
}
