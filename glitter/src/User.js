import React from "react";

export default class User extends React.Component {
  constructor(props) {
    super(props);
    console.log(props);
  }

  render() {
    return (
      <div className="profile-image-container">
        <img className="profile-image" src="" alt="this user pic isn't real" />

        <div className="profile-information">
          <p className="profile-username"> </p>
          <p className="profile-location"> </p>
          <p className="profile-birthday"> </p>
        </div>
      </div>
    );
  }
}
