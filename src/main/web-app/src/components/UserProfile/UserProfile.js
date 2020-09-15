import React from "react";
import "./UserProfile.css";
import { connect } from "react-redux";
import userIcon from "../../assets/userIcon.png";
import { USER_PROFILE, PROFILE_MESSAGE } from "../../constants/index";

/**
 * Displays user information
 */
const UserProfile = (props) => {
  const renderMessages = () => {
    return (
      <div className="messages">
        <h2>{USER_PROFILE}</h2>
        <h6>
          <i>{PROFILE_MESSAGE}</i>
        </h6>
      </div>
    );
  };

  const renderProfileImage = () => {
    return (
      <div className="profileImage">
        <img src={userIcon} alt="" />
      </div>
    );
  };

  const renderProfileDetails = () => {
    const { userLoaded } = props;
    if (userLoaded) {
      const { profile } = props;
      const { fullName, address, email, phoneNumber } = profile;
      return (
        <div className="center">
          <div>
            <h3>{fullName}</h3>
            <p>{address}</p>
            <p>{email}</p>
            <p>{phoneNumber}</p>
          </div>
        </div>
      );
    }
  };

  return (
    <div>
      {renderMessages()}
      <div className="form-wrapper">
        {renderProfileImage()}
        {renderProfileDetails()}
      </div>
    </div>
  );
};

const mapStateToProps = (state) => {
  const { customer } = state;
  return {
    profile: customer.profile,
    fullName: customer.fullName,
    email: customer.email,
    address: customer.address,
    phoneNumber: customer.phoneNumber,
    userLoaded: customer.userLoaded,
  };
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(UserProfile);
