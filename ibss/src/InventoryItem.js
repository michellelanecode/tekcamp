import React, { useState } from "react";
import { Container, Item, Icon, Button } from "semantic-ui-react";
import { useNavigate } from "react-router-dom";
export default function InventoryItem(props) {
  let prod = props.item;
  let [items, setState] = useState(window.products);
  let navigate = useNavigate();
  let availability, limited;
  if (prod.available) {
    availability = "Yes";
  } else {
    availability = "Yes";
  }
  if (prod.limited) {
    limited = "Limited Stock";
  } else {
    limited = "In Stock";
  }

  function updateProducts(update) {
    window.products = update;
    setState(update);
  }

  function removeElement(element) {
    let test = window.products.filter((val) => {
      return props.item.name !== val.name;
    });
    updateProducts(test);
    element.remove();
  }

  function inventoryItemUpdate() {
    setTimeout(() => {
      navigate("/inventoryItem", { state: prod });
    }, 1000);
  }

  return (
    <Container className="inventory-items">
      <Icon
        className="window close outline"
        onClick={(evt) => {
          removeElement(evt.target.parentNode);
        }}
      />

      <Button icon floated="right" onClick={inventoryItemUpdate}>
        <Icon name="edit outline" /> Update Item
      </Button>
      <Container className="inventory-description">
        <Item.Meta>
          <h3>{prod.name}</h3>
          <p>
            <b>Price:</b> {prod.price}
          </p>
          <p>
            <b>Qty:</b> {prod.qty}{" "}
          </p>
          <p>
            <b>Availability:</b> {availability}
          </p>
        </Item.Meta>

        <Item className="inventory-item-info">
          <p>
            <b>Stock Limitations:</b> {limited}
          </p>
          <p>
            <b>Serial No:</b> {prod.serial}
          </p>
          <b>Current Item Description:</b> {prod.description}
          <p>
            <b>product Tags:</b>
            {"[" + prod.tags + "]"}
          </p>
          <br />
          <b>product Images:</b> <br />
          <Item.Image src={prod.img} size="tiny" />{" "}
          <Item.Image src={prod.alternateView} size="tiny" />{" "}
        </Item>
      </Container>
    </Container>
  );
}
