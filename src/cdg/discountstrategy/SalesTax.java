
package cdg.discountstrategy;

/**
 * One of the TaxStrategy options.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class SalesTax implements TaxStrategy {

    private final static double SALES_TAX_RATE = 0.051;
    
    /**
     * Returns the sales tax amount on the subtotal passed,
     * given the constant SALES_TAX_RATE.
     * @param subtotal
     * @return sales tax amount
     */
    @Override
    public double calculateTaxAmount(double subtotal) {
        // needs validation
        return Round.roundToTwoDecimals(subtotal * SALES_TAX_RATE);
    }
}
