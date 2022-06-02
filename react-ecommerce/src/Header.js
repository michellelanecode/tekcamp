import React from "react";

export default class Header extends React.Component {
  render() {
    return (
      <header id="header">
        <h1 className="ui header">
          <div className="content header-content">
            <img
              className="icon"
              src="https://img.icons8.com/external-smashingstocks-mixed-smashing-stocks/344/external-spirituality-managerial-psychology-smashingstocks-mixed-smashing-stocks.png"
            />
            Inner Beauty Spiritual Shop
            <div className="sub header subtitle">
              Be beautiful inside and out
            </div>
          </div>
        </h1>
        <div className="main-icons">
          <i className="search icon"></i>
          <i className="shopping cart icon"></i>
        </div>
      </header>
    );
  }
}
