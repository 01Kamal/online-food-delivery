import React, { Component } from "react";
import axios from "axios";

class viewRestaurant extends Component {
  state = {
    restaurant: {
      contactNumber: "",
      managerName: "",
      restaurantName: "",
      restaurantId: 0,
    },
  };
  componentDidMount() {
    axios
      .get(
        `http://localhost:8082/restaurant/${this.props.match.params.restaurantId}`
      )
      .then((res) => {
        console.log(res);
        this.setState({ restaurant: res.data });
      });
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Restaurant Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Restaurant Name: </label>
              <div> {this.state.restaurant.restaurantName}</div>
            </div>
            <div className="row">
              <label> manager Name: </label>
              <div> {this.state.restaurant.managerName}</div>
            </div>
            <div className="row">
              <label> Contact Number: </label>
              <div> {this.state.restaurant.contactNumber}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default viewRestaurant;
