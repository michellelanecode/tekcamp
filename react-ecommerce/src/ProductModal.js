import React from "react";

export default class ProductModal extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    if (!this.props.show) {
      return null;
    }
    return <div>{this.props.modal}</div>;
  }
}
