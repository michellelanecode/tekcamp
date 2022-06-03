import React from "react";
import Header from "./Header.js";
import ProductView from "./ProductView.js";
import products from "./productData.js";
import MenuView from "./Menu.js";

export default class MainView extends React.Component {
  render() {
    return (
      <div id="main-container" className="one column ui stackable grid">
        <div className="column">
          <Header />
          <main>
            <div id="product-container" className="column">
              <MenuView />
              <ProductView products={products} />
            </div>
          </main>
        </div>
      </div>
    );
  }
}
