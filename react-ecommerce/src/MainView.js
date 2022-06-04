import React from "react";
import { Container } from "semantic-ui-react";
import { Route, Routes } from "react-router-dom";
import Header from "./Header.js";
import ProductView from "./ProductView.js";
import MenuView from "./Menu.js";
import products from "./productData.js";
import FullProductDescription from "./FullProductDescription";
import CartView from "./CartView.js";
import StaffLogin from "./StaffLogin.js";
import InventoryView from "./InventoryView.js";
import SearchResults from "./SearchResults.js";
import ConfirmationPage from "./ConfirmationPage.js";
import CheckoutPage from "./CheckoutPage.js";

export default class MainView extends React.Component {
  render() {
    return (
      <Container id="main-container">
        <Container>
          <Header />
          <main>
            <Container id="product-container">
              <MenuView />
              <Routes>
                <Route
                  path="/"
                  exact
                  element={<ProductView products={products} />}
                />
                <Route
                  path="/fullProd"
                  exact
                  element={<FullProductDescription />}
                />
                <Route path="/cartView" exact element={<CartView />} />
                <Route path="/staffLogin" exact element={<StaffLogin />} />
                <Route
                  path="/inventoryView"
                  exact
                  element={<InventoryView inventory={products} />}
                />
                <Route path="/menu" exact element={<MenuView />} />
                <Route
                  path="/searchResults"
                  query="candle"
                  exact
                  element={<SearchResults />}
                />
                <Route path="/inventory" exact element={<InventoryView />} />
                <Route path="/stafflogin" exact element={<StaffLogin />} />
                <Route path="/checkoutPage" exact element={<CheckoutPage />} />
                <Route
                  path="/confirmation"
                  exact
                  element={<ConfirmationPage />}
                />
              </Routes>
            </Container>
          </main>
        </Container>
      </Container>
    );
  }
}
