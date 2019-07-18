import React from 'react';

const Order = ({ order, setCurrentOrder, currentOrderID, deleteOrder }) => {
	const quantityMap = {};

	return (
		<div className="Card">
			{order.cart.forEach(product =>
				quantityMap[product.name]
					? (quantityMap[product.name] =
							quantityMap[product.name] + 1)
					: (quantityMap[product.name] = 1)
			)}

			{Object.keys(quantityMap).map(key => (
				<div className="span">
					<h3>{`${quantityMap[key]} x ${key}`}</h3>
				</div>
			))}

			<h2>{`Total: ${order.price} Pesos`}</h2>

			<h2 className="clickable" onClick={() => setCurrentOrder(order.id)}>
				{order.id === currentOrderID ? '' : 'Select as Current Order'}
			</h2>

			<h2 className="clickable" onClick={() => deleteOrder(order.id)}>
				Delete Order
			</h2>
			{/* <h2>Checkout Order</h2> */}
		</div>
	);
};

export default Order;
