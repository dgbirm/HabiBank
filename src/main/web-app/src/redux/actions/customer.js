import {
  LOAD_CUSTOMER_PROFILE,
  CLEAR_CUSTOMER,
  LOAD_CUSTOMER_ACCOUNTS,
  LOAD_CHECKINGS,
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

// 0 to get cj.... TODO to pass in ID#
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
  console.log("AC", data);
  return {
    type: LOAD_CHECKINGS,
    payload: data.content,
  };
};
