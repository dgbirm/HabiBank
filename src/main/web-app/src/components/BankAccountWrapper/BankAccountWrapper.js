import React from "react";
import "./BankAccountWrapper.css";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import {
  MY_CHECKINGS,
  CHECKINGS_MESSAGE,
  BANK_ACCOUNT_ID,
  BALANCE,
  CHECKINGS,
  DEPOSIT,
  WITHDRAW,
  TRANSFER,
  MY_SAVINGS,
  SAVINGS_MESSAGE,
  TRANSACTION_ID,
  TRANSACTION_MEMO,
  TRANSACTION_AMOUNT_TRANSFERED,
} from "../../constants/index";
/**
 * Displays savings or checkings account info here (balance, transaction history)
 */
const BankAccountWrapper = (props) => {
  const renderMessages = () => {
    const { checkings, savings } = props;
    let id = props.Type === CHECKINGS ? checkings.acctID : savings.acctID;
    let title = props.Type === CHECKINGS ? MY_CHECKINGS : MY_SAVINGS;
    let message =
      props.Type === CHECKINGS ? CHECKINGS_MESSAGE : SAVINGS_MESSAGE;
    let balance =
      props.Type === CHECKINGS ? checkings.acctBalance : savings.acctBalance;

    return (
      <div className="messages">
        <h2>{title}</h2>
        <p>
          {BANK_ACCOUNT_ID}
          {id}{" "}
        </p>
        <h6>
          <i>{message}</i>
        </h6>
        <h6>
          {BALANCE}: ${balance}
        </h6>
      </div>
    );
  };

  const renderRows = () => {
    if (props.Type === CHECKINGS) {
      return (
        <>
          {props.checkingsTransactions.map((each, index) => {
            console.log(each);
            return (
              <tr key={index}>
                <td>{each.transactionID}</td>
                <td>{each.memo}</td>
                <td>${each.amountTransfered.toFixed(2)}</td>
              </tr>
            );
          })}
        </>
      );
    } else {
      return (
        <>
          {props.savingsTransactions.map((each, index) => {
            console.log(each);
            return (
              <tr key={index}>
                <td>{each.transactionID}</td>
                <td>{each.memo}</td>
                <td>${each.amountTransfered.toFixed(2)}</td>
              </tr>
            );
          })}
        </>
      );
    }
  };

  const renderBalanceView = () => {
    return (
      <div className="form-wrapper customStyle">
        <Table striped borderless hover>
          <thead>
            <tr>
              <th>{TRANSACTION_ID}</th>
              <th>{TRANSACTION_MEMO}</th>
              <th>{TRANSACTION_AMOUNT_TRANSFERED}</th>
            </tr>
          </thead>
          <tbody>{renderRows()}</tbody>
        </Table>
      </div>
    );
  };

  const renderActions = () => {
    return (
      <div className="center transaction-buttons">
        <Link to="/deposit">
          <Button variant="primary" className="tButton shadowButton">
            {DEPOSIT}
          </Button>
        </Link>

        <Link to="/withdraw">
          <Button variant="primary" className="tButton shadowButton">
            {WITHDRAW}
          </Button>
        </Link>

        <Link to="/transfer">
          <Button variant="primary" className="tButton shadowButton">
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
    savings: customer.savings,
    checkings: customer.checkings,
    checkingsTransactions: customer.checkingsTransactions,
    savingsTransactions: customer.savingsTransactions,
  };
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(BankAccountWrapper);
