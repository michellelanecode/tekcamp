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

  postComment(element, comment) {
    return element.appendChild(comment);
  }

  getComments(id, commentsEl, msgEl) {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get(`https://dummyapi.io/data/v1/post/${id}/comment`, {
        headers: {
          "app-id": apiKey,
        },
      })
      .then((res) => {
        return this.createComment(commentsEl, msgEl, res.data.data);
      });
  }

  createMessageBlock(messages) {
    messages.forEach((msg) => {
      const msgTemplate = document
        .getElementById("post")
        .content.cloneNode(true);
      const msgUserPic = msgTemplate.querySelector("img");
      const likeMsg = document.createElement("p");
      const msgLikes = `${msg.likes} likes`;
      likeMsg.textContent = msgLikes;
      msgTemplate.querySelector(".like").appendChild(likeMsg);
      const msgUserName = msgTemplate.querySelector(".user");
      msgUserPic.src = msg.owner.picture;
      msgUserName.textContent = `${msg.owner.firstName} ${msg.owner.lastName}`;
      msgTemplate.getElementById("extra").textContent = msg.text;
      const image = document.createElement("img");
      image.classList.add("ui");
      image.classList.add("small");
      image.classList.add("image");
      const link = document.createElement("a");
      image.src = msg.image;
      link.appendChild(image);
      msgTemplate.getElementById("images").appendChild(link);
      const commentSection = msgTemplate.getElementById("commentSection");
      this.getComments(
        msg.id,
        commentSection,
        msgTemplate.querySelector(".meta")
      );
      const reply = msgTemplate.querySelector(".reply");
      reply.addEventListener("click", (evt) => {
        evt.preventDefault();
        console.log("clicked", evt.target);
      });
      const likeButton = msgTemplate.getElementById("like");
      likeButton.addEventListener("click", (evt) => {
        evt.preventDefault();
        msg.likes++;
      });
      return this.renderMessage(msgTemplate);
    });
  }

  createComment(element, msgEl, info) {
    const commentCount = msgEl.querySelector(".commentCount");
    if (info.length === 0) {
      commentCount.textContent = `0 comments`;
      return;
    } else {
      info.forEach((com) => {
        const comment = document
          .getElementById("newComment")
          .content.cloneNode(true);
        commentCount.textContent = `${info.length} comments`;
        comment.querySelector(".avatarimg").src = com.owner.picture;
        comment.querySelector(
          ".author"
        ).textContent = `${com.owner.firstName} ${com.owner.lastName}`;
        comment.querySelector(".text").textContent = com.message;
        return this.postComment(element, comment);
      });
    }
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
      <div className=" column">
        <section id="feed" className="ui feed"></section>
      </div>
    );
  }
}
