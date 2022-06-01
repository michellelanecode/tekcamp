import React from "react";
import logo from "./images/icons8-spiritual-64.png";

export default class Header extends React.Component {
  render() {
    return (
      <header id="header">
        <h1 className="ui header">
          <div className="content header-content">
            <img className="icon" src={logo} />
            Inner Beauty Shop
            <div className="sub header subtitle">
              Be beautiful inside and out
            </div>
          </div>
        </h1>
      </header>
    );
  }
}
