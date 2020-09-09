import { combineReducers } from "redux";

import checkings from "./checkings";
import customer from "./customer";
import savings from "./savings";
import loading from "./loading";

export default combineReducers({
  checkings,
  customer,
  savings,
  loading,
});
