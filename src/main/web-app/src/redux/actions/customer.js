import { LOAD_SINGLE_CUSTOMER, CLEAR_CUSTOMER } from "./actionTypes";
import axios from "axios";

export const fetchCustomer = (id) => {
  return (dispatch) => {
    axios
      .get(`http://localhost:8080/api/customers?page=${id}&size=1`)
      .then((res) => {
        dispatch(loadCustomer(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadCustomer = (data) => {
  return {
    type: LOAD_SINGLE_CUSTOMER,
    payload: data.content[0],
  };
};

export const clearCustomer = () => {
  return {
    type: CLEAR_CUSTOMER,
  };
};
