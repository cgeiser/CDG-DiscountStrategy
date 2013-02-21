
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class FakeDatabase implements FindProductStrategy {
    private Product[] products = {
        new Product("1111", "Baseball Hat", 19.95, new FlatRateDiscount(0.15)),
        new Product("2222", "Men's Dress Shirt", 35.50, new QuantityDiscount(5, .10)),
        new Product("3333", "Women's Socks", 9.50, new NoDiscount()),
        new Product("4444", "LEGO Star Wars", 129.99, new FixedAmountDiscount(20)),
        new Product("5555", "Harry Potter DVD", 14.49, new NoDiscount()),
        new Product("6666", "Snickers Candy Bar", 0.79, new QuantityDiscount(5, 0.50))
    };
    
    
//    private Customer[] customers = {
//	        new Customer("A00", "John Smith"),
//	        new Customer("B00", "Sally Jones"),
//	        new Customer("C00", "Bob Clementi")
//	    };
    
    
    
    @Override
    public  Product getProductMatch (final String prodId) {
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
	
    
    
    // test method
    public static void main(String[] args) {
        FakeDatabase fd = new FakeDatabase();
        Product p = fd.getProductMatch("2222");
        System.out.println(p.getProductId() + "  " + p.getProductDesc() + "  "
                + p.getProductPrice());
        
        Product f = fd.getProductMatch("6699");
        if (f == null) {
            System.out.println("No Match found");
        }
        else {
            System.out.println(f.getProductId() + "  " + f.getProductDesc() + "  "
                + f.getProductPrice());
        }
    }
}
