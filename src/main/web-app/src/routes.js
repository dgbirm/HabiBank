import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

import App from "./components/App/App";
import AccountHome from "./components/AccountHome/AccountHome";
import BankAccountWrapper from "./components/BankAccountWrapper/BankAccountWrapper";
import Login from "./components/Login/Login";
import RegisterUser from "./components/RegisterUser/RegisterUser";
import Transaction from "./components/Transaction/Transaction";
import UserProfile from "./components/UserProfile/UserProfile";

/**
 * App routes
 * ex. http://localhost:3000/profile will render and display the UserProfile component
 */

const createRoutes = () => (
  <BrowserRouter>
    <Switch>
      <Route
        exact
        path="/"
        render={(...props) => <App ChildComponent={Login} />}
      />
      <Route
        path="/home"
        render={(...props) => <App ChildComponent={AccountHome} />}
      />
      <Route
        path="/savings"
        render={(...props) => (
          <App ChildComponent={BankAccountWrapper} Type="Savings" />
        )}
      />
      <Route
        path="/checkings"
        render={(...props) => (
          <App ChildComponent={BankAccountWrapper} Type="Checkings" />
        )}
      />
      <Route
        path="/deposit"
        render={(...props) => (
          <App ChildComponent={Transaction} Type="Deposit" />
        )}
      />
      <Route
        path="/withdraw"
        render={(...props) => (
          <App ChildComponent={Transaction} Type="Withdraw" />
        )}
      />
      <Route
        path="/transfer"
        render={(...props) => (
          <App ChildComponent={Transaction} Type="Transfer" />
        )}
      />
      <Route
        path="/profile"
        render={(...props) => <App ChildComponent={UserProfile} />}
      />
      <Route
        path="/register"
        render={(...props) => <App ChildComponent={RegisterUser} />}
      />
    </Switch>
  </BrowserRouter>
);

export default createRoutes;
