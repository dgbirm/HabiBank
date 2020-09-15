import {
  LOAD_CUSTOMER_PROFILE,
  CLEAR_CUSTOMER,
  LOAD_CUSTOMER_ACCOUNTS,
  LOAD_CHECKINGS,
  LOAD_SAVINGS,
  SET_ACCOUNTS_LOADED,
} from "./actionTypes";
import axios from "axios";

export const fetchCustomerProfile = (id) => {
  return (dispatch) => {
    axios
      .get(`http://localhost:8080/api/customers?page=${id}&size=1`)
      .then((res) => {
        dispatch(loadCustomerProfile(res.data));
      })
      .catch((err) => console.log(err));
  };
};

// TODO to pass in ID#
export const loadCustomerProfile = (data) => {
  return {
    type: LOAD_CUSTOMER_PROFILE,
    payload: data.content[0],
  };
};

export const clearCustomer = () => {
  return {
    type: CLEAR_CUSTOMER,
  };
};

export const fetchCheckings = () => {
  return (dispatch) => {
    axios
      .get(`http://localhost:8080/api/accounts?page=0&size=1`)
      .then((res) => {
        dispatch(loadCheckings(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadCheckings = (data) => {
  let { acctID, acctBalance, acctType } = data.content[0];
  return {
    type: LOAD_CHECKINGS,
    payload: { acctID, acctBalance, acctType },
  };
};

export const fetchSavings = () => {
  return (dispatch) => {
    axios
      .get(`http://localhost:8080/api/accounts?page=2&size=1`)
      .then((res) => {
        dispatch(loadSavings(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadSavings = (data) => {
  let { acctID, acctBalance, acctType } = data.content[0];
  return {
    type: LOAD_SAVINGS,
    payload: { acctID, acctBalance, acctType },
  };
};

export const setAccountsLoaded = (status) => {
  return {
    type: SET_ACCOUNTS_LOADED,
    payload: status,
  };
};
