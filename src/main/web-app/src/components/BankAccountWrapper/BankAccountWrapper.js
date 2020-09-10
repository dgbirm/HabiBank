import React from "react";
import "./BankAccountWrapper.css";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import {
  MY_CHECKINGS,
  CHECKINGS_MESSAGE,
  BANK_ACCOUNT_ID,
  ACCOUNT_TYPE,
  BALANCE,
  CHECKINGS,
  DEPOSIT,
  WITHDRAW,
  TRANSFER,
  MY_SAVINGS,
  SAVINGS_MESSAGE,
} from "../../constants/index";
/**
 * Displays savings or checkings account info here (balance, transaction history)
 */
const BankAccountWrapper = (props) => {
  const getID = (type) => {
    for (let i = 0; i < props.accounts.length; i++) {
      let obj = props.accounts[i];
      if (obj.accountType.toUpperCase() === type) {
        return obj.accountID;
      }
    }
  };

  const renderMessages = () => {
    let id = props.Type === CHECKINGS ? getID("CHECKINGS") : getID("SAVINGS");
    let title = props.Type === CHECKINGS ? MY_CHECKINGS : MY_SAVINGS;
    let message =
      props.Type === CHECKINGS ? CHECKINGS_MESSAGE : SAVINGS_MESSAGE;
    return (
      <div className="messages">
        <h2>{title}</h2>
        <p>
          {BANK_ACCOUNT_ID} {id}{" "}
        </p>
        <h6>
          <i>{message}</i>
        </h6>
      </div>
    );
  };

  // TODO: show transactions
  const renderBalanceView = () => {
    return (
      <div className="form-wrapper customStyle">
        <Table striped borderless hover>
          <thead>
            <tr>
              <th>{BANK_ACCOUNT_ID}</th>
              <th>{ACCOUNT_TYPE}</th>
              <th>{BALANCE}</th>
            </tr>
          </thead>
          <tbody>
            {props.accounts.map((each, index) => {
              return (
                <tr key={index}>
                  <td>{each.accountID}</td>
                  <td>{each.accountType.toUpperCase()}</td>
                  <td>${each.accountBalance.toFixed(2)}</td>
                </tr>
              );
            })}
          </tbody>
        </Table>
      </div>
    );
  };

  const renderActions = () => {
    return (
      <div className="center transaction-buttons">
        <Link to="/deposit">
          <Button variant="primary" className="tButton">
            {DEPOSIT}
          </Button>
        </Link>

        <Link to="/withdraw">
          <Button variant="primary" className="tButton">
            {WITHDRAW}
          </Button>
        </Link>

        <Link to="/transfer">
          <Button variant="primary" className="tButton">
            {TRANSFER}
          </Button>
        </Link>
      </div>
    );
  };
  return (
    <div>
      {renderMessages()}
      {renderActions()}
      {renderBalanceView()}
    </div>
  );
};

const mapStateToProps = (state) => {
  const { customer } = state;
  return {
    accounts: customer.accounts,
  };
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(BankAccountWrapper);
