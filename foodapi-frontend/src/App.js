import React from 'react';
import { products } from './productData';
import Logo from './logo.png';
import ProductCard from './components/ProductCard';

class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			products: products,
			order: {}
		};
	}

	addProductToLocalOrder = product => {
		console.log(product);
	};

	render() {
		return (
			<div className="App">
				<div>
					<span>
						<img src={Logo} />
					</span>

					<span>Cart</span>
				</div>

				<div className="ProductContainer">
					{this.state.products.map(product => (
						<ProductCard
							key={product.id}
							product={product}
							addProductToLocalOrder={this.addProductToLocalOrder}
						/>
					))}
				</div>
			</div>
		);
	}
}

export default App;
