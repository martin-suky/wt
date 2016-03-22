import * as React from "react";
import TopMenu from "./TopMenu";

export default class WtApp extends React.Component<WTAppProps, {}> {
  public render() {
    return (
      <div>
        <TopMenu/>
        <div className="container-fluid">
            {this.props.children}
        </div>

      </div>
    )
  }
}
