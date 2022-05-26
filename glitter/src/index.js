import React from 'react';
import ReactDOM from 'react-dom';
import Header from './Header.js'
import ProfileView from './ProfileView.js'
import MessagesView from './MessagesView.js'
import FavoritesView from './FavoritesView.js'
class App extends React.Component {

    render() {
        return ( < main > < Header / >
            <
            div className = 'ui grid container' > < ProfileView / > < MessagesView / > < FavoritesView / > < /div> </main > )
    }
}


ReactDOM.render( < App / > , document.querySelector('#root'));