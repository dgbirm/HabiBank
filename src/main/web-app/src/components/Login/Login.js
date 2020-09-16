import React from "react";
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

const Login = (props) => {
  // TO DO: improve loadtime in fetching data before directing to /home
  const handleSubmit = (e) => {
    e.preventDefault();
    const { loggedIn } = props;
    props.updateLogInStatus(!loggedIn);
    props.fetchCustomerProfile();
    props.fetchCheckings();
    props.fetchSavings();
    props.fetchCheckingTransactions();
    props.fetchSavingsTransactions();
    props.history.push("/home");
  };

  // unused code, keeping here as reference
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
