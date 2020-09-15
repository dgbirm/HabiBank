import {
  LOAD_ALL_ACCOUNTS,
  LOAD_ALL_CUSTOMERS,
  LOAD_ALL_TRANSACTIONS,
} from "../actions/actionTypes";

const initialState = {
  customers: {},
  accounts: {},
  transactions: {},
};

/**
 * For an admin account - to have access to all data
 */
function baseDataReducer(state = initialState, action) {
  switch (action.type) {
    case LOAD_ALL_CUSTOMERS:
      return Object.assign({}, state, {
        customers: { ...state.customers, ...action.payload },
      });

    case LOAD_ALL_ACCOUNTS:
      return Object.assign({}, state, {
        accounts: { ...state.accounts, ...action.payload },
      });

    case LOAD_ALL_TRANSACTIONS:
      return Object.assign({}, state, {
        transactions: { ...state.transactions, ...action.payload },
      });

    default:
      return state;
  }
}

export default baseDataReducer;
