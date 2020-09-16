import React from "react";
import "./Transaction.css";
import { connect } from "react-redux";
import { Form, Button } from "react-bootstrap";
import { withRouter } from "react-router-dom";
import {
  DEPOSIT,
  WITHDRAW,
  TRANSFER,
  TRANSACTION_MESSAGE,
  SAVINGS,
  CHECKINGS,
  AMOUNT,
  TO_ACCOUNT,
  FROM_ACCOUNT,
  SUBMIT,
} from "../../constants/index";
/**
 * Transaction page. Options for user to withdraw, deposit, transfer
 */
const Transaction = (props) => {
  const renderMessages = () => {
    let title = "";
    if (props.Type === DEPOSIT) title = DEPOSIT;
    if (props.Type === WITHDRAW) title = WITHDRAW;
    if (props.Type === TRANSFER) title = TRANSFER;

    return (
      <div className="messages">
        <h2>{title}</h2>
        <h6>
          <i>{TRANSACTION_MESSAGE}</i>
        </h6>
      </div>
    );
  };

  const renderSrcSelect = () => {
    return (
      <Form.Group controlId="exampleForm.ControlSelect1">
        <Form.Label>{FROM_ACCOUNT}</Form.Label>
        <Form.Control as="select">
          <option>{SAVINGS}</option>
          <option>{CHECKINGS}</option>
        </Form.Control>
      </Form.Group>
    );
  };

  const renderTgtSelect = () => {
    return (
      <Form.Group controlId="exampleForm.ControlSelect2">
        <Form.Label>{TO_ACCOUNT}</Form.Label>
        <Form.Control as="select">
          <option>{SAVINGS}</option>
          <option>{CHECKINGS}</option>
        </Form.Control>
      </Form.Group>
    );
  };

  const renderAmount = () => {
    return (
      <Form.Group controlId="exampleForm.ControlInput1">
        <Form.Label>{AMOUNT}</Form.Label>
        <Form.Control type="number" placeholder="$" />
      </Form.Group>
    );
  };

  // TO DO: implementation to send data over
  const handleSubmit = (e) => {
    e.preventDefault();
    props.history.push("/home");
  };

  const renderForm = () => {
    return (
      <Form onSubmit={handleSubmit}>
        {renderSrcSelect()}
        {props.Type === "Transfer" ? renderTgtSelect() : null}
        {renderAmount()}
        <Button variant="primary" type="submit" className="shadowButton">
          {SUBMIT}
        </Button>
      </Form>
    );
  };
  return (
    <div>
      {renderMessages()}
      <div className="form-wrapper customStyle">
        <div className="form-container">{renderForm()}</div>
      </div>
    </div>
  );
};

const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(withRouter(Transaction));
