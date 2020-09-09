import {
  LOAD_ACCOUNTS,
  LOAD_TRANSACTIONS,
  SET_ALL_CUSTOMERS,
} from "./actionTypes";

import axios from "axios";

const ROOT = "/api";
const HOST_NAME = "http://localhost:8080";

//for testing
const CUST_REST_API_URL = "http://localhost:8080/api/customers";
const ACCT_REST_API_URL = "http://localhost:8080/api/accounts";
const TRANS_REST_API_URL = "http://localhost:8080/api/transactions";

export const fetchCustomers = () => {
  return function (dispatch) {
    console.log("dispatching fetch");
    return axios.get(CUST_REST_API_URL).then(function (res) {
      dispatch(setCustomers(res.data));
    });
  };
};

export const setCustomers = (data) => {
  return {
    type: SET_ALL_CUSTOMERS,
    payload: data.content,
  };
};
