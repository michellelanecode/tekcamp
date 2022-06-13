import React from "react";
import axios from "axios";
import User from "./User.js";
export default class ProfileView extends React.Component {
  state = {
    firstName: "Adina",
    lastName: "Barbosa",
    location: "Recife, CearÃ¡, Brazil",
    picture: "https://randomuser.me/api/portraits/med/women/28.jpg",
    gender: "female",
  };

  getUser() {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cc", {
        headers: {
          "app-id": apiKey,
        },
      })
      .then((res) => {
        this.setState((state) => {
          state.user = res.data;
        });
      });
  }

  componentDidMount() {
    this.getUser();
  }

  render() {
    return (
      <div id="profile-view" className="five wide column">
        <User user={this.state} />
      </div>
    );
  }
}
