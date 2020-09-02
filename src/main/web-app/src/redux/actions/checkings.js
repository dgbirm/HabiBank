import { SET_CHECKINGS_BALANCE } from "./actionTypes";

/**
 *
 * Action creators for checkingsReducer
 */

export const setCheckingsBalance = (newBalance) => {
  return {
    type: SET_CHECKINGS_BALANCE,
    payload: newBalance,
  };
};
