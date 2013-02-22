
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
    
    public void addItemToTicket(String itemId, int qty) {
        FindProductStrategy fps = new FakeDatabase();
        Product product = fps.findProduct(itemId);
        if (product != null) {
            ticket.addLineItem(itemId, qty);
        }
    }
    
    public void checkout(ReceiptStrategy rs) {
        this.ticket.closeTicket();
        rs.displayReceipt(ticket);
    }
    
    // test
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        cr.startNewTicket("A00");
        cr.addItemToTicket("2222", 1);
        cr.addItemToTicket("3333", 3);
        cr.addItemToTicket("1111", 1);
        cr.addItemToTicket("5555", 4);
        cr.addItemToTicket("6666", 14);
        cr.addItemToTicket("4444", 1);
        cr.checkout(new ConsoleReceipt());
    }
}
