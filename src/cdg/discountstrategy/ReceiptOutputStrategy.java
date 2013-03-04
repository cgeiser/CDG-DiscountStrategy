
package cdg.discountstrategy;

/**
 * Allows for various ways to output a receipt.
 * Each one must have a displayReceipt method.
 * @author cgeiser
 */
public interface ReceiptOutputStrategy {

    public abstract void displayReceipt (Ticket ticket);

}
