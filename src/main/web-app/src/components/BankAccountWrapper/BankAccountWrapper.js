import React from "react";
import "./BankAccountWrapper.css";

/**
 * Displays savings or checkings account info here (balance, transaction history)
 */
const BankAccountWrapper = (props) => {
  return (
    <div>
      Bank Account <props.ChildComponent />
    </div>
  );
};

export default BankAccountWrapper;
