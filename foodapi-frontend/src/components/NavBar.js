import React from 'react';

const NavBar = ({ updateCurrentScreen }) => (
	<div className="NavBar">
		<h2 onClick={() => updateCurrentScreen('Menu')}>Menu</h2>
		<h2 onClick={() => updateCurrentScreen('Orders')}>Orders</h2>
	</div>
);

export default NavBar;
