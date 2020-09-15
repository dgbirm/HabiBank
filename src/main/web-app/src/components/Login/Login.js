import React, { useEffect, useState } from "react";
import "./Login.css";
import { connect } from "react-redux";
import { Form, Button } from "react-bootstrap";
import { updateLogInStatus } from "../../redux/actions/auth";
import { withRouter, Link } from "react-router-dom";
import {
  BANK_NAME,
  LOGIN_SLOGAN,
  EMAIL,
  ENTER_EMAIL,
  PASSWORD,
  SUBMIT,
  CREATE_ACCOUNT_TODAY,
} from "../../constants/index";
import {
  fetchCustomerProfile,
  fetchCheckings,
  fetchSavings,
  fetchCheckingTransactions,
  fetchSavingsTransactions,
} from "../../redux/actions/customer";

// putting fetch actions here for now
// const Login = ({ fetchCustomers, fetchAccounts, fetchCheckingTransactions }) => {
const Login = (props) => {
  const [dataLoaded, setDataLoaded] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    // console.log(props);
    const { loggedIn } = props;
    props.updateLogInStatus(!loggedIn);
    props.fetchCustomerProfile();
    props.fetchCheckings();
    props.fetchSavings();
    props.fetchCheckingTransactions();
    props.fetchSavingsTransactions();
    // console.log(dataLoaded);
    // setDataLoaded(!dataLoaded);
    // console.log(dataLoaded);
    // redirectPage();

    // setTimeout(() => {
    //   props.history.push("/home");
    // }, 1000);

    props.history.push("/home");
  };

  const redirectPage = () => {
    console.log(dataLoaded);
    if (dataLoaded) {
      props.history.push("/home");
    }
  };

  // async function loadAll() {
  //   await props.fetchCustomerProfile()
  //   await props.fetchCheckings()
  //   await props.fetchSavings()

  // }
  // useEffect(() => {
  //   loadAll();
  // });

  const renderForm = () => {
    return (
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formBasicEmail">
          <Form.Label>{EMAIL}</Form.Label>
          <Form.Control type="email" placeholder={ENTER_EMAIL} />
        </Form.Group>

        <Form.Group controlId="formBasicPassword">
          <Form.Label>{PASSWORD}</Form.Label>
          <Form.Control type="password" placeholder={PASSWORD} />
        </Form.Group>

        <Button variant="primary" type="submit" className="shadowButton">
          {SUBMIT}
        </Button>
      </Form>
    );
  };

  const renderMessages = () => {
    return (
      <div className="messages">
        <h2>{BANK_NAME}</h2>
        <h6>
          <i>{LOGIN_SLOGAN}</i>
        </h6>
      </div>
    );
  };

  return (
    <div className="form-wrapper">
      {renderMessages()}
      <div className="form-container">{renderForm()}</div>
      <div className="secondary-link">
        <Link to="/register">{CREATE_ACCOUNT_TODAY}</Link>
      </div>
    </div>
  );
};

// export default Login;
const mapStateToProps = (state) => {
  const { auth } = state;
  return { loggedIn: auth.loggedIn };
};

const mapDispatchToProps = {
  updateLogInStatus,
  fetchCustomerProfile,
  fetchCheckings,
  fetchSavings,
  fetchCheckingTransactions,
  fetchSavingsTransactions,
};
export default connect(mapStateToProps, mapDispatchToProps)(withRouter(Login));
