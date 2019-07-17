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

	render() {
		return (
			<div className="App">
				<img src={Logo} />

				<div className="ProductContainer">
					{this.state.products.map(product => (
						<ProductCard key={product.id} product={product} />
					))}
				</div>
			</div>
		);
	}
}

export default App;
