import React, { useEffect } from "react";
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
import {
  fetchCustomerProfile,
  fetchCheckings,
  fetchSavings,
} from "../../redux/actions/customer";
/**
 * Home page when a user successfully logs in
 * Multiple user routes can be taken here (reference user flow diagram)
 */
const AccountHome = (props) => {
  // async function loadAll() {
  //   await props.fetchCustomerProfile();
  //   await props.fetchCheckings();
  //   await props.fetchSavings();
  // }
  // useEffect(() => {
  //   loadAll();
  // });
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
    console.log(props);
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
            {/* {props.savings.map((each, index) => {
              return ( */}
            <tr>
              <td>{props.savings.acctID}</td>
              <td>{props.savings.acctType.toUpperCase()}</td>
              <td>${props.savings.acctBalance.toFixed(2)}</td>
              <td>{renderButton(props.savings.acctType.toUpperCase())}</td>
            </tr>
            {/* );
            })} */}
            {/* {props.checkings.map((each, index) => {
              return ( */}
            <tr>
              <td>{props.checkings.acctID}</td>
              <td>{props.checkings.acctType.toUpperCase()}</td>
              <td>${props.checkings.acctBalance.toFixed(2)}</td>
              <td>{renderButton(props.checkings.acctType.toUpperCase())}</td>
            </tr>
            {/* );
            })} */}
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
    //accounts: customer.accounts,
    checkings: customer.checkings,
    savings: customer.savings,
  };
};

const mapDispatchToProps = {
  fetchCustomerProfile,
  fetchCheckings,
  fetchSavings,
};
export default connect(mapStateToProps, mapDispatchToProps)(AccountHome);

// future code for an array accounts containing multiple account objects
// ex. accounts = [ {savings}, {checkings}, ...]
/*
{ {props.accounts.map((each, index) => {
              return (
                <tr key={index}>
                  <td>{each.accountID}</td>
                  <td>{each.accountType.toUpperCase()}</td>
                  <td>${each.accountBalance.toFixed(2)}</td>
                  <td>{renderButton(each.accountType.toUpperCase())}</td>
                </tr>
              );
            })} }
*/
