import React, { Component } from "react";
import axios from "axios";

class updateRestaurant extends Component {
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
  handleChange = (e) => {
    const restaurant = { ...this.state.restaurant };
    restaurant[e.target.name] = e.target.value;
    this.setState({ restaurant: restaurant });
    this.setState({ restaurant });
  };
  handleSubmit = (e) => {
    e.preventDefault();
    axios
      .put(
        `http://localhost:8082/restaurant/${this.props.match.params.restaurantId}`,
        this.state.restaurant
      )
      .then(() => {
        this.props.history.push("/restaurant");
      });
  };
  render() {
    return (
      <div>
        <div className="container">
          <div>
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h2 className="text-cener">Update Restaurant</h2>
              <div className="card-body">
                <form onSubmit={this.handleSubmit}>
                  <div className="form-group">
                    <label>Restaurant Name</label>
                    <input
                      placeholder="Restaurant Name"
                      className="form-control"
                      name="restaurantName"
                      value={this.state.restaurant.restaurantName}
                      onChange={this.handleChange}
                    />
                  </div>
                  <div className="form-group">
                    <label>Manager Name</label>
                    <input
                      placeholder="Manager Name"
                      className="form-control"
                      name="managerName"
                      value={this.state.restaurant.managerName}
                      onChange={this.handleChange}
                    />
                  </div>
                  <div className="form-group">
                    <label>Contact Number</label>
                    <input
                      placeholder="Contact Number"
                      className="form-control"
                      name="contactNumber"
                      value={this.state.restaurant.contactNumber}
                      onChange={this.handleChange}
                    />
                  </div>
                  <button type="submit" class="btn btn-primary">
                    Update
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default updateRestaurant;
