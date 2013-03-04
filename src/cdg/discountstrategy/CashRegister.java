
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class CashRegister {
    
    private Customer customer;
    private Ticket ticket;
    private TaxStrategy taxStrategy = new SalesTax();

    
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
    
    public void checkout(ReceiptOutputStrategy ros) {
        this.ticket.closeTicket(taxStrategy);
        ros.displayReceipt(ticket);
    }
    
    public Customer getCustomer() {
        return customer;
    }
    // test
//    public static void main(String[] args) {
//        CashRegister cr = new CashRegister();
//        cr.startNewTicket("A00");
//        cr.addItemToTicket("2222", 1);
//        cr.addItemToTicket("3333", 3);
//        cr.addItemToTicket("1111", 1);
//        cr.addItemToTicket("5555", 4);
//        cr.addItemToTicket("6666", 14);
//        cr.addItemToTicket("4444", 1);
//        cr.checkout(new ConsoleReceipt());
//    }
}
