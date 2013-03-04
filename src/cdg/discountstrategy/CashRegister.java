
package cdg.discountstrategy;

/**
 * Three methods to begin a sale, add items, and finish the sale.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class CashRegister {
    
    private Customer customer;
    private Ticket ticket;
    private TaxStrategy taxStrategy = new SalesTax();

    /**
     * Instantiates a new Ticket if a valid Customer is found using a
     * customer ID.  Uses a FindCustomerStrategy for various interchangeable
     * database locations to look for Customers.
     * @param custId 
     */
    public void startNewTicket(String custId) {
        // validate custId
        if (custId == null || custId.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        
        FindCustomerStrategy fcs = new FakeDatabase();
        customer = fcs.findCustomer(custId);
        if (customer != null) {
            ticket = new Ticket(customer);
        }
        else {
            System.out.println("Customer not found.");
        }
    }
    
    /**
     * Attempts to find a valid Item using item Id.  If found, it adds a
     * LineItem to the Ticket.  Uses a FindProductStrategy for various
     * interchangeable database locations to look for Products.
     * @param itemId
     * @param qty 
     */
    public void addItemToTicket(String itemId, int qty) {
        // validate itemId
        if (itemId == null || itemId.length() == 0) {
            System.out.println("Invalid Item ID");
            return;
        }
        // validate qty
        if (qty < 1) {
            System.out.println("Invalid Quantity");
        }
        FindProductStrategy fps = new FakeDatabase();
        Product product = fps.findProduct(itemId);
        if (product != null) {
            ticket.addLineItem(itemId, qty);
        }
    }
    
    /**
     * Closes the Ticket and outputs to the ReceiptOutputStrategy passed to it.
     * An interchangeable TaxStrategy is passed to the closeTicket method, and
     * the Ticket is passed to the displayReceipt method.
     * @param ros 
     */
    public void checkout(ReceiptOutputStrategy ros) {
        // needs validation
        this.ticket.closeTicket(taxStrategy);
        ros.displayReceipt(ticket);
    }
    
    /**
     * Gets the Customer.
     * @return Customer customer
     */
    public Customer getCustomer() {
        return customer;
    }
    
}
