import React from "react";
import "./Header.css";
import { connect } from "react-redux";
import { Navbar } from "react-bootstrap";
/**
 * Displays savings or checkings account info here (balance, transaction history)
 */
const Header = () => {
  return (
    <div>
      <Navbar>
        <Navbar.Brand href="#home">Navbar with text</Navbar.Brand>
        <Navbar.Toggle />
        <Navbar.Collapse className="justify-content-end">
          <Navbar.Text>
            Signed in as: <a href="#login">Mark Otto</a>
          </Navbar.Text>
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
