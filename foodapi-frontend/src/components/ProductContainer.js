import React from 'react';
import ProductCard from './ProductCard';

const ProductContainer = ({ products, addProductToOrder }) => (
	<div className="Container">
		{products.map(product => (
			<ProductCard
				key={product.id}
				product={product}
				addProductToOrder={addProductToOrder}
			/>
		))}
	</div>
);

export default ProductContainer;
