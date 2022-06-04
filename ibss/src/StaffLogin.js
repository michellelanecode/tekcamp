import React from "react";
import { Link } from "react-router-dom";
import { Button, Form, Grid, Header, Image, Segment } from "semantic-ui-react";
export default class StaffLogin extends React.Component {
  render() {
    return (
      <Grid textAlign="center">
        <Grid.Column style={{ maxWidth: 450 }}>
          <Header as="h2" color="black" textAlign="center">
            Staff Login
          </Header>
          <Form size="large">
            <Segment stacked>
              <Form.Input icon="user" iconPosition="left" placeholder="Name" />
              <Form.Input
                fluid
                icon="lock"
                iconPosition="left"
                placeholder="Password"
                type="password"
              />
              <Link to="/inventoryView">
                <Button color="black" size="large">
                  Login
                </Button>
              </Link>
            </Segment>
          </Form>
        </Grid.Column>
      </Grid>
    );
  }
}
