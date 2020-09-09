import React from "react";
import "./Header.css";
import { connect } from "react-redux";
import { Navbar, Nav } from "react-bootstrap";
import { updateLogInStatus } from "../../redux/actions/auth";
/**
 * Universal header when the user is logged in
 */
const Header = (props) => {
  const renderName = () => {
    const { userLoaded, loggedIn, fullName } = props;
    // userloaded check
    let name = loggedIn ? fullName : "Guest";

    return (
      <Navbar.Text>
        Welcome, <span className="navbar-name">{name}</span>
      </Navbar.Text>
    );
  };

  const handleLogOut = () => {
    const { loggedIn } = props;
    props.updateLogInStatus(!loggedIn);
  };

  const renderLinks = () => {
    const { loggedIn } = props;
    if (loggedIn) {
      return (
        <Nav>
          <Nav.Link href="/home">Home</Nav.Link>
          <Nav.Link href="/profile">Profile</Nav.Link>
          <Nav.Link href="/logout" onClick={handleLogOut}>
            Log out
          </Nav.Link>
        </Nav>
      );
    } else {
      return (
        <Nav>
          <Nav.Link href="/">Log in</Nav.Link>
        </Nav>
      );
    }
  };

  return (
    <div>
      <Navbar bg="primary" variant="dark">
        {renderName()}
        <Navbar.Collapse className="justify-content-end">
          {renderLinks()}
        </Navbar.Collapse>
      </Navbar>
    </div>
  );
};

const mapStateToProps = (state) => {
  const { customer, auth } = state;
  return {
    fullName: customer.fullName,
    userLoaded: customer.userLoaded,
    loggedIn: auth.loggedIn,
  };
};

const mapDispatchToProps = { updateLogInStatus };
export default connect(mapStateToProps, mapDispatchToProps)(Header);
