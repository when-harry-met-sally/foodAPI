import React from 'react';

const ProductCard = ({ product, addProductToLocalOrder }) => (
	<div className="ProductCard">
		<h1>{product.name}</h1>
		<h2>{`${product.price} Pesos`}</h2>
		<div onClick={() => addProductToLocalOrder(product)}>Add to Order</div>
	</div>
);

export default ProductCard;
