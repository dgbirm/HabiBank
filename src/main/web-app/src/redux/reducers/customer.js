import { LOAD_SINGLE_CUSTOMER } from "../actions/actionTypes";
/**
 * reducer managing a customer
 */

const initialState = {
  userName: "",
  fullName: "",
  email: "",
  address: "",
  phoneNumber: "",
  customerID: 0,
};

function customerReducer(state = initialState, action) {
  switch (action.type) {
    case LOAD_SINGLE_CUSTOMER:
      // return {
      //   ...state,
      return Object.assign({}, state, {
        userName: action.userName,
        fullName: action.fullName,
        email: action.email,
        address: action.address,
        phoneNumber: action.phoneNumber,
        customerID: action.customerID,
      });
    default:
      return state;
  }
}

export default customerReducer;
