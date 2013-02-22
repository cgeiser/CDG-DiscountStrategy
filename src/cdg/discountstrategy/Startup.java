
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class Startup {

    public static void main(String[] args) {
        ReceiptStrategy rs = new ConsoleReceipt();
        
        CashRegister cr = new CashRegister();
        
        cr.startNewTicket("F00");
        
        cr.addItemToTicket("1111", 1);
        cr.addItemToTicket("3333", 6);
        cr.addItemToTicket("5555", 1);
        cr.addItemToTicket("6666", 2);
        cr.addItemToTicket("7777", 12);
        
        cr.checkout(rs);
    }
}
