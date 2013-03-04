
package cdg.discountstrategy;

/**
 * Allows for finding Customers in various databases/locations.
 * Each one must have a findCustomer method.
 * @author cgeiser
 */
public interface FindCustomerStrategy  {
    
    public abstract Customer findCustomer(String custId);


    
}