import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

// import App from "./components/App/App";
import AccountHome from "./components/AccountHome/AccountHome";
import BankAccountWrapper from "./components/BankAccountWrapper/BankAccountWrapper";
import CreateBankAccount from "./components/CreateBankAccount/CreateBankAccount";
import Login from "./components/Login/Login";
import RegisterUser from "./components/RegisterUser/RegisterUser";
import Transaction from "./components/Transaction/Transaction";
import UserProfile from "./components/UserProfile/UserProfile";

/**
 * App routes
 * ex. http://localhost:3000/profile will render and display the UserProfile component
 */

// TODO: implementation on BAW and Transaction components
const createRoutes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path="/" component={Login} />
      <Route path="/home" component={AccountHome} />
      <Route path="/newaccount" component={CreateBankAccount} />
      {/* <Route
        path="/savings"
        render={(...props) => <BankAccountWrapper ChildComponent={Savings} />}
      />
      <Route
        path="/checkings"
        render={(...props) => <BankAccountWrapper ChildComponent={Checkings} />}
      />
      <Route
        path="/deposit"
        render={(...props) => <Transaction ChildComponent={Deposit} />}
      />
      <Route
        path="/withdrawal"
        render={(...props) => <Transaction ChildComponent={Withdrawal} />}
      />
      <Route
        path="/transfer"
        render={(...props) => <Transaction ChildComponent={Transfer} />}
      /> */}
      <Route path="/profile" component={UserProfile} />
      <Route path="/register" component={RegisterUser} />
    </Switch>
  </BrowserRouter>
);

export default createRoutes;
