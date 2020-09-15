import {
  LOAD_ALL_ACCOUNTS,
  LOAD_ALL_TRANSACTIONS,
  LOAD_ALL_CUSTOMERS,
} from "./actionTypes";

import axios from "axios";

const ROOT = "/api";
const HOST_NAME = "http://localhost:8080";

//for testing
const CUST_REST_API_URL = "http://localhost:8080/api/customers";
const ACCT_REST_API_URL = "http://localhost:8080/api/accounts";
const TRANS_REST_API_URL = "http://localhost:8080/api/transactions";

export const fetchCustomers = () => {
  // fetch(CUST_REST_API_URL, { mode: "no-cors" }).then((res) =>
  //   console.log(res.data)
  // );
  return (dispatch) => {
    return axios
      .get(CUST_REST_API_URL)
      .then((res) => {
        dispatch(loadCustomers(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadCustomers = (data) => {
  return {
    type: LOAD_ALL_CUSTOMERS,
    payload: data.content,
  };
};

export const fetchAccounts = () => {
  return (dispatch) => {
    return axios
      .get(ACCT_REST_API_URL)
      .then((res) => {
        dispatch(loadAccounts(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadAccounts = (data) => {
  return {
    type: LOAD_ALL_ACCOUNTS,
    payload: data.content,
  };
};

export const fetchCheckingTransactions = () => {
  return (dispatch) => {
    return axios
      .get(TRANS_REST_API_URL)
      .then((res) => {
        dispatch(loadCheckingTransactions(res.data));
      })
      .catch((err) => {
        console.log(err);
      });
  };
};

export const loadCheckingTransactions = (data) => {
  return {
    type: LOAD_ALL_TRANSACTIONS,
    payload: data.content,
  };
};
