import React from "react";

export default class User extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="profile-image-container">
        <img
          className="profile-image"
          src={this.props.userInfo.user.picture}
          alt="this user pic isn't real"
        />

        <div className="profile-information">
          <p className="profile-username">
            {this.props.userInfo.user.firstName}{" "}
            {this.props.userInfo.user.lastName} and Gender
          </p>
          <p className="profile-location">Location</p>
        </div>
      </div>
    );
  }
}
