import React from "react";
import "./RegisterUser.css";
import { connect } from "react-redux";
import { Form, Button, Col } from "react-bootstrap";
import { Link, withRouter } from "react-router-dom";
import { updateLogInStatus } from "../../redux/actions/auth";
import {
  BANK_NAME,
  LOGIN_SLOGAN,
  LOG_IN_NOW,
  NAME,
  EMAIL,
  ADDRESS,
  SUBMIT,
  ENTER_EMAIL,
  PHONE_NUMBER,
  PASSWORD,
  USERNAME,
  CREATE_ACCOUNT,
} from "../../constants/index";
/**
 * Form for user to sign up as a customer
 */
const RegisterUser = (props) => {
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
        <Form.Row>
          <Form.Group as={Col} controlId="formName">
            <Form.Label>{NAME}</Form.Label>
            <Form.Control placeholder={NAME} />
          </Form.Group>

          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>{PHONE_NUMBER}</Form.Label>
            <Form.Control type="text" placeholder={PHONE_NUMBER} />
          </Form.Group>
        </Form.Row>

        <Form.Group controlId="formGridAddress">
          <Form.Label>{ADDRESS}</Form.Label>
          <Form.Control placeholder={ADDRESS} />
        </Form.Group>

        <Form.Group controlId="formGridEmail">
          <Form.Label>{EMAIL}</Form.Label>
          <Form.Control type="email" placeholder={ENTER_EMAIL} />
        </Form.Group>

        <Form.Row>
          <Form.Group as={Col} controlId="formGridUsername">
            <Form.Label>{USERNAME}</Form.Label>
            <Form.Control type="text" placeholder={USERNAME} />
          </Form.Group>

          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>{PASSWORD}</Form.Label>
            <Form.Control type="password" placeholder={PASSWORD} />
          </Form.Group>
        </Form.Row>

        <Button variant="primary" type="submit">
          {CREATE_ACCOUNT}
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
        <Link to="/">{LOG_IN_NOW}</Link>
      </div>
    </div>
  );
};

// export default RegisterUser;
const mapStateToProps = (state) => {
  const { auth } = state;
  return { loggedIn: auth.loggedIn };
};

const mapDispatchToProps = { updateLogInStatus };
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(withRouter(RegisterUser));
