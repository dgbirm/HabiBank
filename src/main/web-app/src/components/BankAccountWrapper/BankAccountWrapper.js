import React from "react";
import "./BankAccountWrapper.css";
import { connect } from "react-redux";

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

// export default BankAccountWrapper;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(BankAccountWrapper);
