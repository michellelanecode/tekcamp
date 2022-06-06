import React, { useState } from "react";
import { Table } from "semantic-ui-react";

export default function Subtotal() {
  let total = 0;
  let subTotal = 0;
  let cartSubtotal = window.cart.map((item) => {
    return calculateTotal(item);
  });
  let formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
  });

  function calculateTotal(purchase) {
    let itemTotal = purchase.price * purchase.qty;
    let currentTotal = total;
    subTotal = subTotal += itemTotal;

    return (
      <Table.Row>
        <Table.Cell width={5}>
          {purchase.name} <br />
          {purchase.price}
          <br />
          <b>Qty:</b> {purchase.qty}
          <br />
          <b>Item Total: </b>
          {itemTotal}
        </Table.Cell>
      </Table.Row>
    );
  }

  return (
    <Table classname="subtotal" definition>
      <Table.Body>{cartSubtotal}</Table.Body>
      <Table.Cell>
        <b>Total:</b> {formatter.format(subTotal)}
      </Table.Cell>
    </Table>
  );
}
