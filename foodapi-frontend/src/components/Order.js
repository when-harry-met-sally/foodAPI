import React from 'react';

const Order = ({ order, setCurrentOrder }) => (
	<div className="Card" onClick={() => setCurrentOrder(order.id)}>
		<h2>{`ID: ${order.id}`}</h2>
		<h2>{`Price: $${order.price}`}</h2>

		{order.cart.map(product => (
			<div className="span">
				<h3>{product.name} </h3>
				<h3>{product.price}</h3>
			</div>
		))}
	</div>
);

export default Order;
