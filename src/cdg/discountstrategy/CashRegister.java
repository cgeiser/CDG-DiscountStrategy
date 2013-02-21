
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class CashRegister {
    
    private Customer customer;
    private Ticket ticket;
    private ReceiptStrategy receiptStrategy;

    
    public void startNewTicket(String custId) {
        FindCustomerStrategy fcs = new FakeDatabase();
        customer = fcs.findCustomer(custId);
        if (customer != null) {
            ticket = new Ticket(customer);
        }
    }
    
    public void checkout(ReceiptStrategy rs) {
        ticket.closeTicket();
        receiptStrategy = rs;
        receiptStrategy.displayReceipt(ticket);
    }
}
