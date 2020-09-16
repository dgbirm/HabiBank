import {
  LOAD_CUSTOMER_PROFILE,
  CLEAR_CUSTOMER,
  LOAD_CHECKINGS,
  LOAD_SAVINGS,
  SET_ACCOUNTS_LOADED,
  LOAD_CHECKINGS_TRANSACTIONS,
  LOAD_SAVINGS_TRANSACTIONS,
} from "../actions/actionTypes";
/**
 * reducer managing a customer
 */

const initialState = {
  profile: {
    userName: "",
    fullName: "",
    email: "",
    address: "",
    phoneNumber: "",
    customerID: 0,
  },
  checkings: {
    acctID: 0,
    acctBalance: 0,
    acctType: "",
  },
  savings: {
    acctID: 0,
    acctBalance: 0,
    acctType: "",
  },
  checkingsTransactions: [],
  savingsTransactions: [],
  userLoaded: false,
  accountsLoaded: false,
};

function customerReducer(state = initialState, action) {
  switch (action.type) {
    case LOAD_CUSTOMER_PROFILE:
      return Object.assign({}, state, {
        ...state,
        profile: action.payload,
        userLoaded: true,
      });

    case LOAD_CHECKINGS:
      return Object.assign({}, state, {
        ...state,
        checkings: action.payload,
      });

    case LOAD_SAVINGS:
      return Object.assign({}, state, {
        ...state,
        savings: action.payload,
      });

    case LOAD_CHECKINGS_TRANSACTIONS:
      return {
        ...state,
        checkingsTransactions: action.payload,
      };

    case LOAD_SAVINGS_TRANSACTIONS:
      return {
        ...state,
        savingsTransactions: action.payload,
      };

    case SET_ACCOUNTS_LOADED:
      return {
        ...state,
        actionLoaded: action.payload,
      };

    case CLEAR_CUSTOMER:
      return initialState;
    default:
      return state;
  }
}

export default customerReducer;
