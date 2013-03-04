
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public interface ConsoleReceiptLineItemFormatStrategy {

    public abstract String formatLineItem (LineItem lineItem, int rowWidth);

}
