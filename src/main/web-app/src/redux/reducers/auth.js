import { UPDATE_LOG_IN_STATUS } from "../actions/actionTypes";

const initialState = {
  loggedIn: false,
};

function authReducer(state = initialState, action) {
  switch (action.type) {
    case UPDATE_LOG_IN_STATUS:
      return { ...state, loggedIn: action.payload };
    default:
      return state;
  }
}

export default authReducer;
