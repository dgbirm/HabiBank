import React from "react";
import "./AccountHome.css";
import { connect } from "react-redux";

/**
 * Home page when a user successfully logs in
 * Multiple user routes can be taken here (reference user flow diagram)
 */
const AccountHome = () => {
  return <div>Account Home</div>;
};

// export default AccountHome;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(AccountHome);
