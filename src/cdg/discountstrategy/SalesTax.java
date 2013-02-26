
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class SalesTax implements TaxStrategy {

    private final double SALES_TAX_RATE = 0.051;
    
    public double calculateTaxAmount(double subtotal) {
        return Round.roundToTwoDecimals(subtotal * SALES_TAX_RATE);
    }
}
