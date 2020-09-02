/**
 * reducer managing a customer
 */

const initialState = {
  name: "",
  id: -1,
};

function customerReducer(state = initialState, action) {
  switch (action.type) {
    default:
      return state;
  }
}

export default customerReducer;
