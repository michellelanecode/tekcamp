import React from "react";
import axios from "axios";

export default class MessagesView extends React.Component {
  constructor() {
    super();
    this.state = { messages: {} };
  }

  updateMessages(messages) {
    this.setState((state) => {
      state.messages = messages;
    });
  }

  renderMessage(msg) {
    const feed = document.getElementById("feed");
    feed.appendChild(msg);
  }

  createMessageBlock(messages) {
    messages.forEach((msg) => {
      const msgTemplate = document
        .getElementById("comments")
        .content.cloneNode(true);
      const msgUserPic = msgTemplate.querySelector("img");
      const msgLikes = `${msg.likes} likes`;
      msgTemplate.querySelector(".like").textContent = msgLikes;
      const msgUserName = msgTemplate.querySelector(".user");
      msgUserPic.src = msg.owner.picture;
      msgUserName.textContent = `${msg.owner.firstName} ${msg.owner.lastName}`;
      msgTemplate.querySelector(".summary").textContent = "posted:";
      msgTemplate.getElementById("extra").textContent = msg.text;
      const image = document.createElement("img");
      const link = document.createElement("a");
      image.src = msg.image;
      link.appendChild(image);
      msgTemplate.getElementById("images").appendChild = link;
      console.log(msgUserName);
      return this.renderMessage(msgTemplate);
    });
  }

  componentDidMount() {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get("https://dummyapi.io/data/v1/post", {
        headers: {
          "app-id": apiKey,
        },
      })
      .then((res) => {
        this.updateMessages(res.data);
        this.createMessageBlock(res.data.data);
      });
  }

  render() {
    return (
      <div className="ten wide column">
        <section id="feed" className="ui feed"></section>
      </div>
    );
  }
}
