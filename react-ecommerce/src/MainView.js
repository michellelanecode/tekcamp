import React from "react";
import Header from "./Header.js";
export default class MainView extends React.Component {
  render() {
    return (
      <div id="main-container" className="one column ui stackable grid">
        <div className="column">
          <Header />

          <div className="column"></div>
        </div>
      </div>
    );
  }
}
