import React from 'react';
import { products } from './productData';

class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {};
	}

	render() {
		return (
			<div className="App">
				<h1>Q.T.P</h1>
				<h1>Quesdallias, Tacos. Provecho!</h1>
			</div>
		);
	}
}

export default App;
