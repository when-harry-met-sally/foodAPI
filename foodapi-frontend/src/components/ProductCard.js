import React from 'react';

const ProductCard = ({ product, addProductToOrder }) => (
	<div className="Card">
		<img className="foodImg" src={product.img} alt="FOOD" />
		<h1>{product.name}</h1>
		<h2>{`${product.price} Pesos`}</h2>
		<div
			className="addButton clickable"
			onClick={() => addProductToOrder(product)}
		>
			Add to Current Order
		</div>
	</div>
);

export default ProductCard;
