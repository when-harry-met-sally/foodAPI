import React from 'react';
import Order from './Order';

const Orders = ({ orders, createNewOrder }) => (
	<div className="Orders">
		{orders.size ? (
			orders.map(order => <Order order={order} />)
		) : (
			<h1>No Orders</h1>
		)}

		<h1>Create a new Order</h1>
	</div>
);

export default Orders;
