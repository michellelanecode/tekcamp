import React from "react";
import { useNavigate } from "react-router-dom";
import { Button, Form, Grid, Header, Message } from "semantic-ui-react";

export default function StaffLogin() {
  let username = "username";
  let password = "password";
  let navigate = useNavigate();

  function validateForm() {
    let Password = document.getElementById("form-input-password");
    let Username = document.getElementById("form-input-username");
    let errormsg = document.querySelector(".login-error");
    if (Username.value === username && Password.value === password) {
      submitForm();

      setTimeout(() => {
        navigate("/inventory");
      }, 2000);
    } else {
      errormsg.classList.remove("hidden");
    }
  }

  function submitForm() {
    let errormsg = document.querySelector(".login-error");
    let successmsg = document.querySelector(".login-success");
    errormsg.classList.add("hidden");
    successmsg.classList.remove("hidden");
  }

  function removeError() {
    let errormsg = document.querySelector(".login-error");
    errormsg.classList.add("hidden");
  }

  return (
    <Grid textAlign="center">
      <Grid.Column style={{ maxWidth: 450 }}>
        <Header as="h2" color="black" textAlign="center">
          Staff Login
        </Header>
        <Form.Input
          fluid
          label="Username"
          id="form-input-username"
          onChange={removeError}
        />
        <Form.Input
          fluid
          label="Password"
          id="form-input-password"
          onChange={removeError}
        />{" "}
        <Message
          className="login-error error hidden"
          header="Invalid Information"
          content="username or password is not valid."
        />
        <Message
          success
          className="login-success hidden"
          header="Success"
          content="Success! You are being redirected to inventory page."
        />
        <Button clssName="login-button " onClick={validateForm}>
          Submit
        </Button>
      </Grid.Column>
    </Grid>
  );
}
