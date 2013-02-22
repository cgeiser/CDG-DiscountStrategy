
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class FakeDatabase implements FindProductStrategy, FindCustomerStrategy {
    
    private Product[] products = {
        new Product("1111", "Baseball Hat", 19.95, new FlatRateDiscount(0.15)),
        new Product("2222", "Men's Dress Shirt", 35.50, new QuantityDiscount(2, 0.13)),
        new Product("3333", "Women's Socks", 9.50, new NoDiscount()),
        new Product("4444", "LEGO Star Wars", 129.90, new FixedAmountDiscount(20)),
        new Product("5555", "Harry Potter DVD", 14.49, new NoDiscount()),
        new Product("6666", "Snickers Candy Bar", 0.79, new QuantityDiscount(10, 0.50)),
        new Product("7777", "Yogurt", 0.65, new QuantityFixedAmountDiscount(6, 0.05))
    };
    
    
    private Customer[] customers = {
        new Customer("A00", "John Smith"),
        new Customer("B00", "Sally Jones"),
        new Customer("C00", "Bob Clementi"),
        new Customer("D00", "Bobby Knight"),
        new Customer("E00", "Darth Vadar"),
        new Customer("F00", "Ginny Weasley")
    };
    
    
    
    @Override
    public final Product findProduct (final String prodId) {
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
	
    
    @Override
    public final Customer findCustomer(final String custId) {
	        // validation is needed
	        Customer customer = null;
	        for(Customer c : customers) {
	            if(custId.equals(c.getCustId())) {
	                customer = c;
	                break;
	            }
	        }

	        return customer;
	    }
    
    
    // test method
    public static void main(String[] args) {
        FakeDatabase fd = new FakeDatabase();
        Product p = fd.findProduct("2222");
        System.out.println(p.getProductId() + "  " + p.getProductDesc() + "  "
                + p.getProductPrice());
        
        Product f = fd.findProduct("6699");
        if (f == null) {
            System.out.println("No Match found");
        }
        else {
            System.out.println(f.getProductId() + "  " + f.getProductDesc() + "  "
                + f.getProductPrice());
        }
        
        
        
        Customer c = fd.findCustomer("F00");
        if (c == null) {
            System.out.println("No Match found");
        }
        else {
            System.out.println(c.getCustId() + "  " + c.getCustName());
        }
    }
}
