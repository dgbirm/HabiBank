import { SET_CHECKINGS_BALANCE } from "../actions/actionTypes";

/**
 * reducer managing a checkings account
 */

const initialState = {
  active: false,
  balance: 0,
};

function checkingsReducer(state = initialState, action) {
  switch (action.type) {
    case SET_CHECKINGS_BALANCE:
      return { ...state, balance: action.payload };

    default:
      return state;
  }
}

export default checkingsReducer;
