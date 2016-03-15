/// <reference path="../typings/react/react-global.d.ts" />
/// <reference path="../typings/react/react-dom.d.ts" />
/// <reference path="interfaces.d.ts"/>

import React = require("react");
import ReactDOM = require("react-dom");

namespace wt.components {
  export class WTApp extends React.Component<WTAppProps, {}> {
    public render() {
      return (
        <div>
          <h1>Hello World</h1>
          <p>I am here</p>
        </div>
      )
    }
  }
}

var WtApp = wt.components.WTApp;

function render() {
  ReactDOM.render(
    <WtApp/>,
    document.getElementById('app')
  );
}

render();
