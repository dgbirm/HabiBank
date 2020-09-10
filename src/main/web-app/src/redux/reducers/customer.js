import {
  LOAD_CUSTOMER_PROFILE,
  CLEAR_CUSTOMER,
  LOAD_CHECKINGS,
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
  accounts: {
    checkings: {
      accountID: 1,
      accountBalance: 900.1,
      accountType: "checkings",
    },
    savings: {
      accountID: 2,
      accountBalance: 222.47,
      accountType: "savings",
    },
  },
  userLoaded: false,
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
        ...state.accounts,
        checkings: action.payload,
      });
    case CLEAR_CUSTOMER:
      return initialState;
    default:
      return state;
  }
}

export default customerReducer;
