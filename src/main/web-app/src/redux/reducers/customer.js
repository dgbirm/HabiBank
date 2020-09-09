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
  userLoaded: false,
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
