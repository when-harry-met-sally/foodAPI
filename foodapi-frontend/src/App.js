import React from 'react';
import { products } from './productData';
import Logo from './logo.png';
import ProductContainer from './components/ProductContainer';
import Orders from './components/Orders';
import NavBar from './components/NavBar';
import axios from 'axios';

class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			currentScreen: 'Menu',
			products: products,
			orders: []
		};
	}

	addProductToLocalOrder = product => {
		console.log(product);
	};

	returnCurrentScreen = () => {
		switch (this.state.currentScreen) {
			case 'Menu':
				return (
					<ProductContainer
						products={this.state.products}
						addProductToLocalOrder={this.addProductToLocalOrder}
					/>
				);

			case 'Orders':
				return (
					<Orders
						orders={this.state.orders}
						createNewOrder={this.createNewOrder}
					/>
				);
		}
	};

	updateCurrentScreen = newScreen => {
		this.setState({ currentScreen: newScreen });
	};

	createNewOrder = () => {
		console.log('Yeet');
	};

	render() {
		return (
			<div className="App">
				<div className="NavSpan">
					<img src={Logo} />

					<NavBar updateCurrentScreen={this.updateCurrentScreen} />
				</div>

				{this.returnCurrentScreen()}
			</div>
		);
	}
}

export default App;
