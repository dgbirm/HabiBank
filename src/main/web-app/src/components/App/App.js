import React, { useEffect } from "react";
import "./App.css";
import { connect } from "react-redux";
import Header from "../Header/Header";
import {
  fetchCustomers,
  fetchAccounts,
  fetchTransactions,
} from "../../redux/actions/baseData";

const App = (props) => {
  // temporary feature - loads all db data into redux store
  async function loadAll() {
    await props.fetchCustomers();
    await props.fetchAccounts();
    await props.fetchTransactions();
  }
  useEffect(() => {
    loadAll();
  });

  return (
    <div className="App">
      <Header />
      {props.Type !== undefined ? (
        <props.ChildComponent Type={props.Type} />
      ) : (
        <props.ChildComponent />
      )}
    </div>
  );
};

//export default App;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = { fetchCustomers, fetchAccounts, fetchTransactions };
export default connect(mapStateToProps, mapDispatchToProps)(App);
