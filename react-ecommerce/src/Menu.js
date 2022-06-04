import React from "react";
import { Link } from "react-router-dom";
import { Menu, Icon } from "semantic-ui-react";

export default class MenuView extends React.Component {
  render() {
    return (
      <Menu>
        <Link to="/">
          <a className="item">Home</a>
        </Link>
        <Link to="/staffLogin">
          <a className="item">Staff login</a>
        </Link>
        <Link to="/cartView">
          <a className="item">
            {" "}
            <Icon name="cart" />
          </a>
        </Link>
        <Menu.Menu position="right">
          <div className=" ui transparent icon input ">
            <input
              className="prompt search-bar"
              type="text"
              placeholder="Search..."
            />
            <Link to="/searchResults">
              <i className="search link icon"></i>
            </Link>
          </div>
        </Menu.Menu>
      </Menu>
    );
  }
}
