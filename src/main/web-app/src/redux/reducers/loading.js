import {
  LOAD_ACCOUNTS,
  SET_ALL_CUSTOMERS,
  LOAD_TRANSACTIONS,
} from "../actions/actionTypes";
// import getCustomers from "../../apiServices/getCustomers";

/**
 * template placeholder for now
 */
import axios from "axios";

const ROOT = "/api";
const HOST_NAME = "http://localhost:8080";

//for testing
const CUST_REST_API_URL = "http://localhost:8080/api/customers";

const initialState = {
  data: {},
};

function loadingReducer(state = initialState, action) {
  switch (action.type) {
    // fetches and loads from customers route content
    case SET_ALL_CUSTOMERS:
      return Object.assign({}, state, {
        data: { ...state.data, ...action.payload },
      });

    default:
      return state;
  }
}

export default loadingReducer;
