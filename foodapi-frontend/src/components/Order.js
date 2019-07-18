import React from 'react';

const Order = ({ order, setCurrentOrder }) => (
	<div className="Card" onClick={() => setCurrentOrder(order.id)}>
		<h2>{`ID: ${order.id}`}</h2>
		<h2>{`Price: $${order.price}`}</h2>

		{order.cart.map(product => (
			<h3>{product.name}</h3>
		))}
	</div>
);

export default Order;
