import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Restaurant extends Component {
  state = {
    restaurant: [],
  };
  componentDidMount() {
    axios.get("http://localhost:8082/restaurant").then((res) => {
      console.log(res);
      this.setState({ restaurant: res.data });
    });
  }
  handleDelete = (restaurantId) => {
    axios
      .delete(`http://localhost:8082/restaurant/${restaurantId}`)
      .then((res) => {
        const restaurant = this.state.restaurant.filter(
          (p) => p.restaurantid !== restaurantId
        );
        this.setState({ restaurant: restaurant });
        this.props.history.push("/restaurant");
      });
  };
  handleView(restaurantId) {
    this.props.history.push(`/viewRestaurant/${restaurantId}`);
  }
  render() {
    const { restaurant } = this.state;

    return (
      <div>
        <h3>RESTAURANT PAGE</h3>
        <div>
          <Link to="/addRestaurant">
            <button className="btn btn-primary">Add-Restaurant</button>
          </Link>
        </div>
        <div>
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th scope="col">restaurantId</th>
                <th scope="col">restaurantName</th>
                <th scope="col">managerName</th>
                <th scope="col">contactNumber</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              {restaurant.map((res) => (
                <tr key={res.restaurantId}>
                  <th scope="row">{res.restaurantId}</th>
                  <td>{res.restaurantName}</td>
                  <td>{res.managerName}</td>
                  <td>{res.contactNumber}</td>
                  <td>
                    <Link to={`/updaterestaurant/${res.restaurantId}`}>
                      <button
                        type="button"
                        className="btn btn-outline-primary bi bi-file-earmark-check-fill"
                      ></button>
                    </Link>
                    <button
                      type="button"
                      style={{ marginLeft: "10px" }}
                      className="btn btn-outline-primary bi bi bi-scissors"
                      onClick={() => this.handleDelete(res.restaurantId)}
                    ></button>
                    <button
                      type="button"
                      className="btn btn-info"
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.handleView(res.restaurantId)}
                    >
                      View
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default Restaurant;
