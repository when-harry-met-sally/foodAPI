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
			currentOrderID: '',
			products: products,
			orders: []
		};
	}

	addProductToLocalOrder = async product => {
		// need to check if current id is empty
		const currentOrder = this.state.orders.filter(
			order => order.id === this.state.currentOrderID
		)[0];

		const newCurrentOrder = {
			...currentOrder,
			cart: [...currentOrder.cart, product]
		};

		this.setState({
			orders: [
				...this.state.orders.filter(
					order => order.id !== this.state.currentOrderID
				),
				newCurrentOrder
			]
		});
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
						setCurrentOrder={this.setCurrentOrder}
					/>
				);
		}
	};

	updateCurrentScreen = newScreen => {
		this.setState({ currentScreen: newScreen });
	};

	createNewOrder = async () => {
		const response = await axios.post('/orders');

		this.setState(
			{ orders: response.data },
			console.log(this.state.orders)
		);
	};

	setCurrentOrder = orderID => {
		this.setState({ currentOrderID: orderID });
	};

	componentWillMount = async () => {
		const response = await axios.get('/orders');
		this.setState({ orders: response.data });
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
