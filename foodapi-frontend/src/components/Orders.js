import React from 'react';
import Order from './Order';

const Orders = ({
	orders,
	createNewOrder,
	setCurrentOrder,
	currentOrderID,
	deleteOrder,
	updateQuantity
}) => (
	<div className="Container">
		{orders.length ? (
			orders.map(order => (
				<Order
					key={order.id}
					order={order}
					setCurrentOrder={setCurrentOrder}
					currentOrderID={currentOrderID}
					deleteOrder={deleteOrder}
				/>
			))
		) : (
			<h1>No Orders</h1>
		)}

		<h1 onClick={() => createNewOrder()}>Create a new Order</h1>
	</div>
);

export default Orders;
