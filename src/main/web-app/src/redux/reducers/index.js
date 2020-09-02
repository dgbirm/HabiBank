import { combineReducers } from "redux";

import checkings from "./checkings";
import customer from "./customer";
import savings from "./savings";

export default combineReducers({
  checkings,
  customer,
  savings,
});
