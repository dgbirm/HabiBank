import { UPDATE_LOG_IN_STATUS } from "./actionTypes";

export const updateLogInStatus = (status) => {
  return {
    type: UPDATE_LOG_IN_STATUS,
    payload: status,
  };
};
