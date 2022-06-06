import { Card, Icon, Image, Button, Label } from "semantic-ui-react";
import { Link } from "react-router-dom";

export default function ProductCard(props) {
  let info = props.info;

  let stockAvailability;
  if (info.available && info.qty >= 10) {
    stockAvailability = <b className="inStock">In Stock!</b>;
  } else if (!info.available) {
    stockAvailability = <b className="outOfStock">Out of Stock</b>;
  } else if (info.available && info.qty < 10 && info.qty > 0) {
    info.limited = true;
    stockAvailability = <b className="limitedStock">Limited Stock!</b>;
  }

  return (
    <Card className="product-card">
      <Link to="/fullProd" state={{ info }}>
        <Image className="product-image" src={info.img} />
      </Link>
      <Card.Content>
        <Card.Header>{info.name}</Card.Header>
        {info.price} <p> {stockAvailability} </p>
        <Card.Meta>{info.description}</Card.Meta>
      </Card.Content>
      <Card.Content extra>
        <Link to="/fullProd" state={{ info }}>
          <Button as="div" labelPosition="right">
            <Button color="blue" animated="vertical">
              <Button.Content hidden>Shop</Button.Content>
              <Button.Content visible>
                <Icon name="shop" />
              </Button.Content>
            </Button>
            <Label as="a" basic color="blue" pointing="left">
              Amount Available: {info.qty}{" "}
            </Label>
          </Button>
        </Link>
      </Card.Content>
    </Card>
  );
}
