import React from "react";
import "./Logout.css";
import { connect } from "react-redux";

const Logout = () => {
  return <div>Logout</div>;
};

const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(Logout);
