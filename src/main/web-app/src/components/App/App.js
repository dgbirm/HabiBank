import React, { useEffect } from "react";
import "./App.css";
import "./customizedStyles.css";
import { connect } from "react-redux";
import Header from "../Header/Header";
import {
  fetchCustomers,
  fetchAccounts,
  fetchTransactions,
} from "../../redux/actions/baseData";
import {
  fetchCustomerProfile,
  fetchCheckings,
} from "../../redux/actions/customer";

const App = (props) => {
  // temporary feature - loads all db data into redux store
  async function loadAll() {
    await props.fetchCheckings();
    // await props.fetchCustomers();
    // await props.fetchAccounts();
    // await props.fetchTransactions();
    // await props.fetchCustomerProfile();
  }
  useEffect(() => {
    loadAll();
  });

  return (
    <div className="App">
      <div className="header-container">
        <Header />
      </div>

      <div className="view-container">
        {props.Type !== undefined ? (
          <props.ChildComponent Type={props.Type} />
        ) : (
          <props.ChildComponent />
        )}
      </div>
    </div>
  );
};

//export default App;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {
  fetchCustomers,
  fetchAccounts,
  fetchTransactions,
  fetchCustomerProfile,
  fetchCheckings,
};
export default connect(mapStateToProps, mapDispatchToProps)(App);
