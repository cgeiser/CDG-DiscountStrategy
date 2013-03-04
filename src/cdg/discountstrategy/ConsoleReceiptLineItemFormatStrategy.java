
package cdg.discountstrategy;

/**
 * Allows for various interchangeable LineItem formats for console output
 * of the receipt in ConsoleReceipt.
 * @author cgeiser
 */
public interface ConsoleReceiptLineItemFormatStrategy {

    public abstract String formatLineItem (LineItem lineItem, int rowWidth);

}
