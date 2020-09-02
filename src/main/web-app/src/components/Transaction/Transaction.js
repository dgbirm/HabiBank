import React from "react";
import "./Transaction.css";
import { connect } from "react-redux";

/**
 * Transaction page. Options for user to withdraw, deposit, transfer
 */
const Transaction = (props) => {
  return (
    <div>
      Transaction <props.ChildComponent />
    </div>
  );
};

// export default Transaction;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(Transaction);
