package cdg.discountstrategy;

/**
 * Contains the hard-coded Product and Customer arrays.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class FakeDatabase implements PersistenceStrategy {
    
    private Product[] products = {
        new Product("1111", "Baseball Hat", 19.95, new FlatRateDiscount(0.15)),
        new Product("2222", "Men's Dress Shirt", 35.50, new QuantityDiscount(2, 0.13)),
        new Product("3333", "Women's Socks", 9.50, new NoDiscount()),
        new Product("4444", "LEGO Star Wars", 129.90, new FixedAmountDiscount(20)),
        new Product("5555", "Harry Potter DVD", 14.49, new FlatRateDiscount(0.25)),
        new Product("6666", "Snickers Candy Bar", 0.79, new QuantityDiscount(3, 0.50)),
        new Product("7777", "Yogurt", 0.65, new QuantityFixedAmountDiscount(6, 2.0))
    };
    
    
    private Customer[] customers = {
        new Customer("A00", "John Smith"),
        new Customer("B00", "Sally Jones"),
        new Customer("C00", "Bob Clementi"),
        new Customer("D00", "Bobby Knight"),
        new Customer("E00", "Darth Vadar"),
        new Customer("F00", "Ginny Weasley"),
        new Customer("G00", "Lamar Deveraux")
    };
    
    
    /**
     * Searches the "database" for a Product matching the Id passed.
     * @param prodId
     * @return Product product if a match is found
     */
    @Override
    public final Product findProduct (final String prodId) {
	// validate prodId
        if (prodId == null || prodId.length() == 0) {
            System.out.println("Invalid Product ID");
            System.exit(0);
        }
        Product product = null;
        for (Product p : products) {
            if (prodId.equals(p.getProductId())) {
                product = p;
                break;
            }
        }
        return product;
    }
	
    /**
     * Searches the "database" for a Customer matching the Id passed.
     * @param custId
     * @return Customer customer if a match is found
     */
    @Override
    public final Customer findCustomer(final String custId) {
	// validate custId
        if (custId == null || custId.length() == 0) {
            System.out.println("Invalid Customer ID");
            System.exit(0);
        }
        Customer customer = null;
        for (Customer c : customers) {
            if (custId.equals(c.getCustId())) {
                customer = c;
                break;
            }
        }
        return customer;
    }

}
