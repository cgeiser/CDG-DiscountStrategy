
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class Startup {

    public static void main(String[] args) {
        ReceiptOutputStrategy ros = new ConsoleReceipt();
        
        CashRegister cr = new CashRegister();
        
        cr.startNewTicket("C00");
        
        cr.addItemToTicket("1111", 1);
        cr.addItemToTicket("3333", 2);
        cr.addItemToTicket("5555", 1);
        cr.addItemToTicket("6666", 4);
        cr.addItemToTicket("7777", 12);
        
        cr.checkout(ros);
    }
}
