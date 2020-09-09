import { combineReducers } from "redux";

import customer from "./customer";
import baseData from "./baseData";
import auth from "./auth";

export default combineReducers({
  customer,
  baseData,
  auth,
});
