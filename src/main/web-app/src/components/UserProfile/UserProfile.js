import React from "react";
import "./UserProfile.css";
import { connect } from "react-redux";

/**
 * Displays user information
 */
const UserProfile = () => {
  return <div>User Profile</div>;
};

// export default UserProfile;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(UserProfile);
