import React from "react";
import ProductCard from "./ProductCard.js";

export default function SearchList(props) {
  const results = props.items.map((prod) => <ProductCard info={prod} />);

  return results;
}
