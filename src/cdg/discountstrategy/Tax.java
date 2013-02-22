
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public abstract class Tax {

    private final double SALES_TAX_RATE = 0.051;
    
    public double calculateSalesTax(double subtotal) {
        return Round.roundToTwoDecimals(subtotal * SALES_TAX_RATE);
    }
}
