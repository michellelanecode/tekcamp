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
        console.log("these are messages:", res.data);
      });
  }

  render() {
    return <div className="five wide column"> testing Message View </div>;
  }
}
