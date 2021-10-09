import React, { Component } from "react";
import { NavLink } from "react-router-dom";

class HeaderComp extends Component {
  state = {};
  render() {
    return (
      <div>
        <header>
          <nav className="navbar navbar-expand-md navbar-dark bg-dark">
            <div className="container-fluid">
              <NavLink className="navbar-brand" to="/Restaurant">
                Online Food Delivery
              </NavLink>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}

export default HeaderComp;
