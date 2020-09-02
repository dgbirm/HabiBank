import React from "react";
import "./UserProfile.css";
import { connect } from "react-redux";
import userIcon from "../../assets/userIcon.png";
import { Button } from "react-bootstrap";

/**
 * Displays user information
 */
const UserProfile = () => {
  const renderProfileImage = () => {
    return (
      <div className="profileImage">
        <img src={userIcon} alt="default user icon image" />
      </div>
    );
  };

  // TODO: currently using placeholder text
  const renderProfileDetails = () => {
    let first = "Jane";
    let last = "Doe";
    let city = "Boston";
    let state = "Massachusetts";
    return (
      <div>
        <h3>
          {first} {last}
        </h3>
        <p>
          {city}, {state}
        </p>
      </div>
    );
  };

  const renderEditProfile = () => {
    return (
      <div>
        <Button variant="primary">Edit </Button>
      </div>
    );
  };
  return (
    <div>
      User Profile
      {renderProfileImage()}
      {renderProfileDetails()}
      {renderEditProfile()}
    </div>
  );
};

// export default UserProfile;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(UserProfile);
