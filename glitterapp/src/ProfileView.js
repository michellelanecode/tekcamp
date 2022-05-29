import React from "react";
import axios from "axios";
import User from "./User.js";
export default class ProfileView extends React.Component {
  constructor(props) {
    super(props);
    this.state = { user: {} };
  }

  updateUser(userInfo) {
    this.setState((state) => {
      state.user = userInfo;
    });
  }

  componentDidMount() {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb", {
        headers: {
          "app-id": apiKey,
        },
      })
      .then((res) => {
        this.updateUser(res.data);
      });
  }

  render() {
    return (
      <div className="five wide column">
        <User userInfo={this.state} />
      </div>
    );
  }
}
