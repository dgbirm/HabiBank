import React from "react";
import "./Login.css";
import { connect } from "react-redux";
import { Form, Button } from "react-bootstrap";
import {
  fetchCustomers,
  fetchAccounts,
  fetchTransactions,
} from "../../redux/actions/baseData";

// putting fetch actions here for now
const Login = ({ fetchCustomers, fetchAccounts, fetchTransactions }) => {
  const handleSubmit = (e) => {
    e.preventDefault();
    fetchCustomers();
    fetchAccounts();
    fetchTransactions();
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
  return {};
};

const mapDispatchToProps = { fetchCustomers, fetchAccounts, fetchTransactions };
export default connect(mapStateToProps, mapDispatchToProps)(Login);
