import React from "react";
import axios from "axios";
import User from "./User.js";
export default class ProfileView extends React.Component {
  constructor() {
    super();
    this.state = {};

    this.getUserInfo();
  }

  updateUser(userInfo) {
    this.setState(userInfo.data);
  }

  getUserInfo() {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb", {
        headers: {
          "app-id": apiKey,
        },
      })
      .then((data) => {
        this.updateUser(data);
        console.log(this.state);
      });
  }

  render() {
    return (
      <div className="five wide column">
        <User />
      </div>
    );
  }
}
