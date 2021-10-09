import "./App.css";
import Restaurant from "./components/restaurant";
import { Switch, Route } from "react-router-dom";
import updateRestaurant from "./components/updateRestaurant";
import HeaderComp from "./components/HeaderComp";
import FooterComp from "./components/FooterComp";
import addRestaurant from "./components/addRestaurant";
import viewRestaurant from "./components/viewRestaurant";

function App() {
  return (
    <div>
      <HeaderComp />
      <div className="container">
        <Switch>
          <Route path="/restaurant" component={Restaurant} />
          <Route
            path="/updaterestaurant/:restaurantId"
            component={updateRestaurant}
          />
          <Route
            path="/viewRestaurant/:restaurantId"
            component={viewRestaurant}
          />
          <Route path="/addRestaurant" component={addRestaurant} />
        </Switch>
      </div>
      <FooterComp />
    </div>
  );
}

export default App;
