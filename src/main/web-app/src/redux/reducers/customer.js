import { LOAD_SINGLE_CUSTOMER } from "../actions/actionTypes";
/**
 * reducer managing a customer
 */

const initialState = {
  profile: {
    userName: "jdoe",
    fullName: "Jane Doe",
    email: "jd@doeeee.com",
    address: "Disneyland, CA",
    phoneNumber: "1234567890",
    customerID: 1,
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
  userLoaded: true, //false, // currently hard coded
};

function customerReducer(state = initialState, action) {
  switch (action.type) {
    case LOAD_SINGLE_CUSTOMER:
      return Object.assign({}, state, {
        ...state,
        ...action.payload,
        userLoaded: true,
      });
    default:
      return state;
  }
}

export default customerReducer;
