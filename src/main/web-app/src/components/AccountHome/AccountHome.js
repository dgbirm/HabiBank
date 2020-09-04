import React from "react";
import "./AccountHome.css";
import { connect } from "react-redux";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
/**
 * Home page when a user successfully logs in
 * Multiple user routes can be taken here (reference user flow diagram)
 */
const AccountHome = () => {
  return (
    <div>
      <h3>Account Home</h3>
      <Link to="/savings">
        <Button variant="primary">Savings</Button>
      </Link>
      <Link to="/checkings">
        <Button variant="primary">Checkings</Button>
      </Link>
    </div>
  );
};

// export default AccountHome;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(AccountHome);
