
package cdg.discountstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public abstract class Round {

    public static double roundToTwoDecimals(double number) {
        BigDecimal bd = new BigDecimal(String.valueOf(number));
        bd.setScale(2, RoundingMode.HALF_EVEN);
        return bd.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        
    }
    
    public static double roundToTwoDecimals(String number) {
        BigDecimal bd = new BigDecimal(number);
        bd.setScale(2, RoundingMode.HALF_EVEN);
        return bd.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        
    }
    
    
    public static int roundToInteger(double number) {
        BigDecimal bd = new BigDecimal(String.valueOf(number));
        bd.setScale(0, RoundingMode.HALF_EVEN);
        return bd.setScale(0, RoundingMode.HALF_EVEN).intValue();
        
    }
}
