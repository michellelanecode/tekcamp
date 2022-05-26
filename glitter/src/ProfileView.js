import React from "react";

export default class ProfileView extends React.Component {
    constructor() {
        super();
        this.state = {
            user: "test",
            location: "test location",
            pronouns: "she/they",
            image: '../images/2289_SkVNQSBGQU1PIDEwMjgtMTE0-removebg-preview.png'
        };
    }

    render() {
        return ( <
            div className = "five wide column" >
            <
            img className = "profile-image"
            src = { this.state.image }
            alt = "this user pic isn't real" /
            >
            <
            div className = "profile-information" >
            <
            p className = "profile-username" > { this.state.location } < /p> <
            p className = "profile-location" > { this.state.user } < /p> <
            p className = "profile-birthday" > { this.state.pronouns } < /p> < /
            div > { " " } <
            /div>
        );
    }
}