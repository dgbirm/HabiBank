import { combineReducers } from "redux";

import customer from "./customer";
import baseData from "./baseData";

export default combineReducers({
  customer,
  baseData,
});
