import React from "react";
import { NavLink } from "react-router-dom";
import { Menu, Icon } from "semantic-ui-react";

export default class MenuView extends React.Component {
  render() {
    return (
      <Menu>
        <NavLink to="/">
          <a className="item">Home</a>
        </NavLink>
        <NavLink to="/staffLogin">
          <a className="item">Staff login</a>
        </NavLink>
        <NavLink to="/cartView">
          <a className="item">
            {" "}
            <Icon name="cart" />
          </a>
        </NavLink>
        <NavLink to="/searchResults">
          <a className="item">
            <i class="icon search" />
          </a>
        </NavLink>
      </Menu>
    );
  }
}
