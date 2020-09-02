import { createStore, applyMiddleware } from "redux";
import rootReducer from "./reducers/index";
import ReduxThunk from "redux-thunk";

export const middlewares = [ReduxThunk];
const createStoreWithMiddleWare = applyMiddleware(...middlewares)(createStore);

export default createStoreWithMiddleWare(
  rootReducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);
