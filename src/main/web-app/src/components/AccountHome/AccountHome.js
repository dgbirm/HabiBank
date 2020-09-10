import React from "react";
import "./AccountHome.css";
import { connect } from "react-redux";
import { Button, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import {
  ACCOUNT_HOME,
  ACCOUNT_HOME_MESSAGE,
  BANK_ACCOUNT_ID,
  ACCOUNT_TYPE,
  SAVINGS,
  CHECKINGS,
  BALANCE,
} from "../../constants/index";
/**
 * Home page when a user successfully logs in
 * Multiple user routes can be taken here (reference user flow diagram)
 */
const AccountHome = (props) => {
  const renderMessages = () => {
    return (
      <div className="messages">
        <h2>{ACCOUNT_HOME}</h2>
        <h6>
          <i>{ACCOUNT_HOME_MESSAGE}</i>
        </h6>
      </div>
    );
  };

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
                  <td>{renderButton(each.accountType.toUpperCase())}</td>
                </tr>
              );
            })}
          </tbody>
        </Table>
      </div>
    );
  };

  const renderButton = (type) => {
    let link = type === "SAVINGS" ? "/savings" : "/checkings";
    let text = type === "SAVINGS" ? SAVINGS : CHECKINGS;

    return (
      <Link to={link}>
        <Button variant="primary" className="shadowButton">
          {text}
        </Button>
      </Link>
    );
  };

  return (
    <div>
      {renderMessages()}
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
export default connect(mapStateToProps, mapDispatchToProps)(AccountHome);
