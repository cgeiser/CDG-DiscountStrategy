
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class FakeDatabase {
    private Product[] products = {
            new Product("1111", "Baseball Hat", 19.95, new FlatRateDiscount(0.15)),
            new Product("2222", "Men's Dress Shirt", 35.50, new QuantityDiscount(5, .10)),
            new Product("3333", "Women's Socks", 9.50, new NoDiscount()),
            new Product("4444", "LEGO Star Wars", 129.99, new FixedAmountDiscount(10)),
            new Product("5555", "Harry Potter DVD", 14.49, new NoDiscount())
        };
    
    
//    private Customer[] customers = {
//	        new Customer("A00", "John Smith"),
//	        new Customer("B00", "Sally Jones"),
//	        new Customer("C00", "Bob Clementi")
//	    };
    
    
    
    public final Product findProduct(final String prodId) {
	        // validation is needed
	        Product product = null;
	        for(Product p : products) {
	            if(prodId.equals(p.getProductId())) {
	                product = p;
	                break;
	            }
	        }
	        return product;
    }
	
}
