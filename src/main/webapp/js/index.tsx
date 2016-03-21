///<reference path="../typings/react/react.d.ts"/>
///<reference path="../typings/react/react-dom.d.ts"/>
///<reference path="../typings/react-router/react-router.d.ts"/>

import * as React from "react";
import * as ReactDOM from "react-dom";
import { Router, Route, Link, browserHistory } from 'react-router';
import WtApp from "./components/WtApp";


function render() {
  ReactDOM.render(
    <WtApp/>,
    document.getElementById('app')
  );
}

render();
