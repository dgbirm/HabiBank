import React from 'react';
import { connect } from 'react-redux';
import _ from 'lodash'; 
import { Route, Switch, Router } from 'react-router-dom';
import { createBrowserHistory } from 'history';
import Login from '../components/Login';
import Register from '../components/Register';
import Profile from '../components/Profile';
import Logout from '../components/Logout';
import Header from '../components/Header';
import Account from '../components/Account';

export const history = createBrowserHistory();

const AppRouter = ({ auth }) => {
  return(
  <Router>
      <div className="container">
        <Switch>
          <Route path="/" component={Login} exact={true} />
          <Route path="/register" component={Register} />
          <Route path="/account" component={Account} />
          <Route path="/profile" component={Profile} />
          <Route path="/logout" component={Logout} />
        </Switch>
      </div>
  </Router>
  );
};

const mapStateToProps = (state) => ({
    auth: state.auth
});

export default connect(mapStateToProps)(AppRouter);