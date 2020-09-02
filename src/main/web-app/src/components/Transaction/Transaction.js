import React from "react";
import "./Transaction.css";

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

export default Transaction;
