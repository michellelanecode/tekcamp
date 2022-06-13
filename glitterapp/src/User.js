import React from "react";

export default class User extends React.Component {
  constructor(props) {
    super(props);
    console.log(props);
  }

  render() {
    return (
      <div className="profile-image-container">
        <img className="profile-image" src={this.props.user.picture} alt="" />

        <div className="profile-information">
          <p className="profile-username">
            {this.props.user.firstName} {this.props.user.lastName},{" "}
            {this.props.user.gender}
          </p>
          <p className="profile-location">{this.props.user.location}</p>
        </div>
      </div>
    );
  }
}
