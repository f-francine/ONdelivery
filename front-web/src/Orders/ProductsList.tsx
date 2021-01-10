import { Product } from './types'
import ProductsCard from "./ProductsCard";

type Props = {
    products: Product[]; //Means product's type is Products[]
}

function ProductsList ({ products }: Props) {
    return (
        <div className="products-list-container">
            <div className="products-list-content">
                <div className="products-list-items">
                    {products.map(product => ( // product is the callback's function
                        <ProductsCard key={product.id} product={product}/>
                    ))}
                </div>
            </div>
        </div>    
    );
}
export default ProductsList;