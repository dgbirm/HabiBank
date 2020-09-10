import React from "react";
import "./Transaction.css";
import { connect } from "react-redux";
import { Form, Button } from "react-bootstrap";
import { withRouter } from "react-router-dom";
/**
 * Transaction page. Options for user to withdraw, deposit, transfer
 * TO DO: pull from redux store
 */
const Transaction = (props) => {
  const renderSrcSelect = () => {
    return (
      <Form.Group controlId="exampleForm.ControlSelect1">
        <Form.Label>From account</Form.Label>
        <Form.Control as="select">
          <option>Savings</option>
          <option>Checkings</option>
        </Form.Control>
      </Form.Group>
    );
  };

  const renderTgtSelect = () => {
    return (
      <Form.Group controlId="exampleForm.ControlSelect2">
        <Form.Label>To account</Form.Label>
        <Form.Control as="select">
          <option>Savings</option>
          <option>Checkings</option>
        </Form.Control>
      </Form.Group>
    );
  };

  const renderAmount = () => {
    return (
      <Form.Group controlId="exampleForm.ControlInput1">
        <Form.Label>Amount</Form.Label>
        <Form.Control type="text" placeholder="$" />
      </Form.Group>
    );
  };

  // TO DO: implementation to send data over
  const handleSubmit = (e) => {
    e.preventDefault();
    // console.log(props);
    // const { loggedIn } = props;
    // props.updateLogInStatus(!loggedIn);
    props.history.push("/home");
  };

  const renderForm = () => {
    return (
      <Form onSubmit={handleSubmit}>
        {renderSrcSelect()}
        {props.Type === "Transfer" ? renderTgtSelect() : null}
        {renderAmount()}
        <Button variant="primary" type="submit" className="shadowButton">
          Submit
        </Button>
      </Form>
    );
  };
  return (
    <div className="form-wrapper customStyle">
      Transaction {props.Type}
      <div className="form-container">{renderForm()}</div>
    </div>
  );
};

// export default Transaction;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(withRouter(Transaction));
