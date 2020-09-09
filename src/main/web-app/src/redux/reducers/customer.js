import { LOAD_SINGLE_CUSTOMER } from "../actions/actionTypes";
/**
 * reducer managing a customer
 */

const initialState = {
  userName: "jdoe",
  fullName: "Jane Doe",
  email: "jd@doeeee.com",
  address: "Disneyland, CA",
  phoneNumber: "1234567890",
  customerID: 1,
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
