import React from "react";
import axios from "axios";

export default class MessagesView extends React.Component {
  constructor() {
    super();
    this.state = {
      messages: {},
      user: {
        firstName: "Adina",
        lastName: "Barbosa",
        location: "Recife, CearÃ¡, Brazil",
        picture: "https://randomuser.me/api/portraits/med/women/28.jpg",
        gender: "female",
      },
    };
  }

  updateMessages(messages) {
    this.setState((state) => {
      state.messages = messages;
    });
  }

  updateComments(msg, newMsg) {
    this.setState((state) => {
      state.messages[msg] = newMsg;
    });
  }

  renderMessage(msg) {
    const feed = document.getElementById("feed");
    feed.appendChild(msg);
  }

  postComments(element, comment) {
    return element.appendChild(comment);
  }

  postComment(value, el) {
    const newComment = this.createNewComment(
      value,
      el.nextElementSibling,
      el.querySelector(".commentCount")
    );
    el.nextElementSibling.appendChild(newComment);
  }

  getComments(msg, id, commentsEl, msgEl) {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get(`https://dummyapi.io/data/v1/post/${id}/comment`, {
        headers: {
          "app-id": apiKey,
        },
      })
      .then((res) => {
        return this.createComment(msg, commentsEl, msgEl, res.data.data);
      });
  }

  createNewComment(msg, commentSection, commentCount) {
    const comment = document
      .getElementById("newComment")
      .content.cloneNode(true);

    comment.querySelector(".avatarimg").src = this.state.user.picture;
    comment.querySelector(".author").textContent =
      this.state.user.firstName + " " + this.state.user.lastName;
    comment.querySelector(".text").textContent = msg;

    return comment;
  }

  createComment(msg, element, msgEl, info) {
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
        return this.postComments(element, comment);
      });
    }
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
        msg,
        msg.id,
        commentSection,
        msgTemplate.querySelector(".meta")
      );
      const reply = msgTemplate.querySelector(".reply");
      reply.addEventListener("click", (evt) => {
        evt.preventDefault();
        this.toggleReply(evt.target.nextElementSibling);
      });

      const submitButton = msgTemplate.querySelector(".submitButton");
      submitButton.addEventListener("click", (evt) => {
        evt.preventDefault();
        let value = evt.target.parentNode.querySelector("input").value;
        this.postComment(value, evt.target.parentNode.parentNode);
        this.toggleReply(reply.nextElementSibling);
        evt.target.parentNode.querySelector("input").value = "";
      });

      const likeButton = msgTemplate.getElementById("like");
      likeButton.addEventListener("click", (evt) => {
        evt.preventDefault();
        let likeCount = Number(
          evt.target.nextElementSibling.textContent.slice(0, 3)
        );
        likeCount++;
        evt.target.nextElementSibling.textContent = `${likeCount} likes`;
      });

      return this.renderMessage(msgTemplate);
    });
  }

  toggleReply(el) {
    el.classList.toggle("hideReply");
  }

  componentDidMount() {
    const apiKey = "628fa168f8a8b8aecbe96686";
    axios
      .get("https://dummyapi.io/data/v1/post?limit=15", {
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
