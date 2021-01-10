import Header from './Header';
import ProductsList from './ProductsList';
import './styles.css';
import { useEffect, useState } from 'react';
import { Product } from './types';
import { fetchProducts } from '../api';
 
function Orders () {
   const [products, setPrducts] = useState<Product[]>([]);
   console.log(products);
    useEffect(() => {
        fetchProducts()
            .then(response => setPrducts(response.data))
            .catch(error => console.log(error))
    }, []);
    return (
       
        <div className="order-container">
            <Header />
            <ProductsList products={products} />
        </div>
    );
}

export default Orders;