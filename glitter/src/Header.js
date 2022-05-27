import React from "react";

export default class Header extends React.Component {
  render() {
    return (
      <header className="header">
        <h1 className="header-title">
          <i className="circular users icon"> </i>{" "}
        </h1>
        Welcome to Glitter{" "}
      </header>
    );
  }
}
