import React from 'react';

const NavBar = ({ updateCurrentScreen, currentOrderID }) => (
	<div className="NavBar">
		<h2 className="clickable" onClick={() => updateCurrentScreen('Menu')}>
			Menu
		</h2>
		<h2 className="clickable" onClick={() => updateCurrentScreen('Orders')}>
			Orders
		</h2>

		{currentOrderID !== '' ? (
			<h2>Order Selected</h2>
		) : (
			<h2>No Order Selected</h2>
		)}
	</div>
);

export default NavBar;
