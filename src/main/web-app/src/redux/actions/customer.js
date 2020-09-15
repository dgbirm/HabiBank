import {
  LOAD_CUSTOMER_PROFILE,
  CLEAR_CUSTOMER,
  LOAD_CUSTOMER_ACCOUNTS,
  LOAD_CHECKINGS,
  LOAD_SAVINGS,
  SET_ACCOUNTS_LOADED,
  LOAD_CHECKINGS_TRANSACTIONS,
  LOAD_SAVINGS_TRANSACTIONS,
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

export const fetchCheckingTransactions = () => {
  return (dispatch) => {
    axios
      .get(`http://localhost:8080/api/transactions?page=0`)
      .then((res) => {
        dispatch(loadCheckingTransactions(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadCheckingTransactions = (data) => {
  let allData = [];
  for (let i in data.content) {
    if (data.content[i].acct.acctType === "CHECKING") {
      let { amountTransfered, memo, transactionID } = data.content[i];
      let obj = { amountTransfered, memo, transactionID };
      allData.push(obj);
    }
  }
  return {
    type: LOAD_CHECKINGS_TRANSACTIONS,
    payload: allData,
  };
};

export const fetchSavingsTransactions = () => {
  return (dispatch) => {
    axios
      .get(`http://localhost:8080/api/transactions?page=0`)
      .then((res) => {
        dispatch(loadSavingsTransactions(res.data));
      })
      .catch((err) => console.log(err));
  };
};

export const loadSavingsTransactions = (data) => {
  let allData = [];
  for (let i in data.content) {
    if (data.content[i].acct.acctType === "SAVINGS") {
      let { amountTransfered, memo, transactionID } = data.content[i];
      let obj = { amountTransfered, memo, transactionID };
      allData.push(obj);
    }
  }
  return {
    type: LOAD_SAVINGS_TRANSACTIONS,
    payload: allData,
  };
};
