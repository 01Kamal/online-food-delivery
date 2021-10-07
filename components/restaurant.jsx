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
                    <Link to={`/restaurant/${res.restaurantId}`}>
                      <button
                        type="button"
                        className="btn btn-outline-primary bi bi bi-scissors"
                      ></button>
                    </Link>
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
