import React from "react";
import axios from "axios";
import User from "./User.js";
export default class ProfileView extends React.Component {
  state = { user: "" };

  componentDidMount() {
    this.getUser();
  }

  updateUser(userInfo) {
    this.setState((state) => {
      state.user = userInfo;
    });
  }

  async getUser() {
    const apiKey = "628fa168f8a8b8aecbe96686";
    const response = await axios.get(
      "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb",
      {
        headers: {
          "app-id": apiKey,
        },
      }
    );

    this.updateUser(response.data);
  }

  render() {
    return (
      <div className="five wide column">
        <User user={this.state} />
      </div>
    );
  }
}
