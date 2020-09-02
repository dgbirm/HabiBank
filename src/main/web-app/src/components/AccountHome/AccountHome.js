import React from "react";
import "./AccountHome.css";
import { connect } from "react-redux";
import { Button } from "react-bootstrap";
/**
 * Home page when a user successfully logs in
 * Multiple user routes can be taken here (reference user flow diagram)
 */
const AccountHome = () => {
  return (
    <div>
      <h3>Account Home</h3>
      <Button variant="primary">Savings</Button>
      <Button variant="primary">Checkings</Button>
    </div>
  );
};

// export default AccountHome;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(AccountHome);
