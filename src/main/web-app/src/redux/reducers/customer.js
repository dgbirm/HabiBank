import { LOAD_SINGLE_CUSTOMER, CLEAR_CUSTOMER } from "../actions/actionTypes";
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
  accounts: [
    {
      accountID: 1,
      accountBalance: 900.1,
      accountType: "checkings",
    },
    {
      accountID: 2,
      accountBalance: 222.47,
      accountType: "savings",
    },
  ],
  userLoaded: false,
};

function customerReducer(state = initialState, action) {
  switch (action.type) {
    case LOAD_SINGLE_CUSTOMER:
      return Object.assign({}, state, {
        ...state,
        profile: action.payload,
        userLoaded: true,
      });

    case CLEAR_CUSTOMER:
      return initialState;
    default:
      return state;
  }
}

export default customerReducer;
