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
  REGISTER,
} from "../../constants/index";
// putting fetch actions here for now
// const Login = ({ fetchCustomers, fetchAccounts, fetchTransactions }) => {
const Login = (props) => {
  const handleSubmit = (e) => {
    e.preventDefault();
    // console.log(props);
    const { loggedIn } = props;
    props.updateLogInStatus(!loggedIn);
    props.history.push("/home");
  };

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

        <Button variant="primary" type="submit">
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
    <div className="login-wrapper">
      {renderMessages()}
      <div className="form-container">{renderForm()}</div>
      <div className="registerLink">
        <Link to="/register">{REGISTER}</Link>
      </div>
    </div>
  );
};

// export default Login;
const mapStateToProps = (state) => {
  const { auth } = state;
  return { loggedIn: auth.loggedIn };
};

const mapDispatchToProps = { updateLogInStatus };
export default connect(mapStateToProps, mapDispatchToProps)(withRouter(Login));
