import React from "react";
import { Menu, Icon } from "semantic-ui-react";

export default class MenuView extends React.Component {
  render() {
    return (
      <Menu>
        <a className="active item">Home</a>
        <a className="item">
          <Icon name="cart" />
        </a>
        <Menu.Menu position="right">
          <div className=" ui transparent icon input ">
            <input className="prompt" type="text" placeholder="Search..." />
            <i className="search link icon"></i>
          </div>
        </Menu.Menu>
      </Menu>
    );
  }
}
