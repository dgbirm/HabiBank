import React from "react";
import "./Login.css";
import { connect } from "react-redux";
import { Form, Button } from "react-bootstrap";
import { updateLogInStatus } from "../../redux/actions/auth";
import { withRouter } from "react-router-dom";

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
  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formBasicEmail">
          <Form.Label>Email address</Form.Label>
          <Form.Control type="email" placeholder="Enter email" />
        </Form.Group>

        <Form.Group controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" placeholder="Password" />
        </Form.Group>

        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
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
