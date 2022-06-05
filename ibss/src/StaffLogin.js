import React from "react";
import { Link } from "react-router-dom";
import { Button, Form, Grid, Header } from "semantic-ui-react";
export default class StaffLogin extends React.Component {
  toggleError(value, target, errmsg, direction) {
    console.log(target.getAttribute("error"));
    if (value.length < 4) {
      target.setAttribute("error", { content: errmsg, poining: direction });
    } else {
      target.removeAttribute("error");
    }
  }

  render() {
    return (
      <Grid textAlign="center">
        <Grid.Column style={{ maxWidth: 450 }}>
          <Header as="h2" color="black" textAlign="center">
            Staff Login
          </Header>
          <Form size="large" rewuired>
            <Form.Input
              fluid
              label="Username"
              value="TestUsername"
              id="form-input-username"
            />
            <Form.Input fluid label="Password" value="TestPassword" />{" "}
            <Link to="/inventoryView">
              <Button>Submit</Button>
            </Link>
          </Form>
        </Grid.Column>
      </Grid>
    );
  }
}
