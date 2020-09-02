import React from "react";
import "./App.css";
import { connect } from "react-redux";
import Header from "../Header/Header";
const App = (props) => {
  return (
    <div className="App">
      <Header />
      <props.ChildComponent />
    </div>
  );
};

//export default App;
const mapStateToProps = (state) => {
  return {};
};

const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(App);
