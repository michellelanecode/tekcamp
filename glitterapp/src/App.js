import React from "react";
import Header from "./Header.js";
import ProfileView from "./ProfileView.js";
import MessagesView from "./MessagesView.js";
import FavoritesView from "./FavoritesView.js";
class App extends React.Component {
  render() {
    return (
      <main>
        {" "}
        <Header />
        <section className="app">
          <ProfileView />
          <div className="ui grid container">
            {" "}
            <MessagesView />{" "}
          </div>{" "}
        </section>
      </main>
    );
  }
}
export default App;
