import React from "react";
import "./UserProfile.css";
import { connect } from "react-redux";
import userIcon from "../../assets/userIcon.png";
// import { Button } from "react-bootstrap";

/**
 * Displays user information
 */
const UserProfile = (props) => {
  const renderProfileImage = () => {
    return (
      <div className="profileImage">
        <img src={userIcon} alt="" />
      </div>
    );
  };

  const renderProfileDetails = () => {
    // console.log(props);
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

  // uncommenting for now
  // const renderEditProfile = () => {
  //   return (
  //     <div>
  //       <Button variant="primary">Edit </Button>
  //     </div>
  //   );
  // };
  return (
    <div className="form-wrapper">
      {renderProfileImage()}
      {renderProfileDetails()}
      {/* {renderEditProfile()} */}
    </div>
  );
};

// export default UserProfile;
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
