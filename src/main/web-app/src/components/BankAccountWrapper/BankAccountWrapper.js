import React from "react";
import "./BankAccountWrapper.css";
import { connect } from "react-redux";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
/**
 * Displays savings or checkings account info here (balance, transaction history)
 */
const BankAccountWrapper = (props) => {
  const renderActions = () => {
    return (
      <div>
        <Link to="/deposit">
          <Button variant="primary">Deposit</Button>
        </Link>

        <Link to="/withdraw">
          <Button variant="primary">Withdraw</Button>
        </Link>

        <Link to="/transfer">
          <Button variant="primary">Transfer</Button>
        </Link>
      </div>
    );
  };
  return (
    <div>
      Bank Account {props.Type} {renderActions()}
    </div>
  );
};

// export default BankAccountWrapper;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(BankAccountWrapper);
