import React from "react";
import "./Header.css";
import { connect } from "react-redux";
import { Navbar, Nav, NavDropdown } from "react-bootstrap";
/**
 * Universal header when the user is logged in
 */
const Header = () => {
  // temp data
  let loggedIn = true;
  let first = "Jane";
  let last = "Doe";

  const renderName = (status) => {
    let name = status ? `${first} ${last}` : "Guest";
    return (
      <Navbar.Text>
        Welcome, <span className="navbar-name">{name}</span>
      </Navbar.Text>
    );
  };

  const renderLinks = (status) => {
    if (status) {
      return (
        <Nav>
          <Nav.Link href="/home">Home</Nav.Link>
          <NavDropdown title="Settings" id="collasible-nav-dropdown">
            <NavDropdown.Item href="/profile">Profile</NavDropdown.Item>
            <NavDropdown.Item href="/logout">Log out</NavDropdown.Item>
          </NavDropdown>
        </Nav>
      );
    } else {
      return (
        <Nav>
          <Nav.Link href="/">Log In</Nav.Link>
        </Nav>
      );
    }
  };

  return (
    <div>
      <Navbar bg="primary" variant="dark">
        {renderName(loggedIn)}
        <Navbar.Collapse className="justify-content-end">
          {renderLinks(loggedIn)}
        </Navbar.Collapse>
      </Navbar>
    </div>
  );
};

// export default BankAccountWrapper;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(Header);
