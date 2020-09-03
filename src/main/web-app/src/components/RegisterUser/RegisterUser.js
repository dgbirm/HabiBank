import React from "react";
import "./RegisterUser.css";
import { connect } from "react-redux";

/**
 * Form for user to sign up as a customer
 */
const RegisterUser = () => {
  return <div>Register User</div>;
};

// export default RegisterUser;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(RegisterUser);
