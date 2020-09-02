import React from "react";
import "./CreateBankAccount.css";
import { connect } from "react-redux";

/**
 * Allows a user to create a new bank account (either savings or checkings)
 */
const CreateBankAccount = () => {
  return <div>Create Bank Account</div>;
};

// export default CreateBankAccount;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(CreateBankAccount);
