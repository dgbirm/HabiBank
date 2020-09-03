/**
 * reducer managing a savings account
 */

const initialState = {
  active: false,
  balance: 0,
};

function savingsReducer(state = initialState, action) {
  switch (action.type) {
    default:
      return state;
  }
}

export default savingsReducer;
