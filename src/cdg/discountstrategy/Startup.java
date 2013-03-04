package cdg.discountstrategy;

/**
 * Demonstration class for the Discount Strategy.
 * Creates a CashRegister, which starts a new Ticket by sending a customer
 * ID #.  Add items by sending an item # and quantity.  Sends the
 * ReceiptOutputStrategy in the checkout method to close the sale and
 * display the Receipt.
 * 
 * @author cgeiser
 * @version 1.0
 * 
 * @param ReceiptOutputStrategy -- ConsoleReceipt() or
 *                                 GuiReceipt()
 */
public class Startup {

    public static void main(String[] args) {
//        ReceiptOutputStrategy ros = new GuiReceipt();
        // or
        ReceiptOutputStrategy ros = new ConsoleReceipt();
        
        CashRegister cr = new CashRegister();
        
        cr.startNewTicket("C00");
        
        cr.addItemToTicket("1111", 1);
        cr.addItemToTicket("3333", 2);
        cr.addItemToTicket("5555", 1);
        cr.addItemToTicket("6666", 4);
        cr.addItemToTicket("7777", 3);
        
        cr.checkout(ros);
    }
}
