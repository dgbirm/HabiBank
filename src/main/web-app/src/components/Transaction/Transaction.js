import React from "react";
import "./Transaction.css";
import { connect } from "react-redux";

/**
 * Transaction page. Options for user to withdraw, deposit, transfer
 */
const Transaction = (props) => {
  const renderSingleAccount = () => {
    return <div>Dropdown, input number, submit button</div>;
  };

  const renderTwoAccounts = (type) => {
    return <div>from and to dropdown, input number, submit button</div>;
  };

  // have a redux value for type
  const conditionalActions = (type) => {
    if (type === "Deposit" || type === "Withdraw") {
      return renderSingleAccount();
    }

    // Transfer
    else {
      return renderTwoAccounts();
    }
  };

  return (
    <div>
      Transaction {props.Type} {conditionalActions(props.Type)}
    </div>
  );
};

// export default Transaction;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(Transaction);
