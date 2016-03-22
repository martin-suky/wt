import * as React from "react";
import * as ReactDOM from "react-dom";
import { Router, Route, Link, IndexRoute, browserHistory } from 'react-router';
import WtApp from "./components/WtApp";
import About from "./components/About";
import Home from "./components/Home";


function render() {
  ReactDOM.render(
    <Router history={browserHistory}>
      <Route path="/" component={WtApp}>
        <IndexRoute component={Home}/>
        <Route path="about" component={About}/>
      </Route>
    </Router>,
    document.getElementById('app')
  );
}

render();
