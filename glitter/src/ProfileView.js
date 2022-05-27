import React from "react";
import axios from 'axios';

export default class ProfileView extends React.Component {
    constructor() {
        super();
        this.state = {
            user: "test",
            location: "test location",
            pronouns: "she/they",
            image: '../images/2289_SkVNQSBGQU1PIDEwMjgtMTE0-removebg-preview.png'
        };

        this.loadUserInfo();
    }


    loadUserInfo() {
        const apiKey = '628fa168f8a8b8aecbe96686';
        axios.get('https://dummyapi.io/data/v1/user?page=1&limit=10', {
            headers: {
                'app-id': apiKey,
            }
        })
    }

    render() {
        return ( <
            div className = "five wide column" >
            <
            div className = 'profile-image-container' > <
            img className = "profile-image"
            src = { this.state.image }
            alt = "this user pic isn't real" /
            >
            <
            /div> <
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