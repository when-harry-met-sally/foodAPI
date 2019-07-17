import React from 'react';
import ProductCard from './ProductCard';

const ProductContainer = ({ products, addProductToLocalOrder }) => (
	<div className="ProductContainer">
		{products.map(product => (
			<ProductCard
				key={product.id}
				product={product}
				addProductToLocalOrder={addProductToLocalOrder}
			/>
		))}
	</div>
);

export default ProductContainer;
