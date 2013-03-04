
package cdg.discountstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Rounding class of various rounding methods.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public abstract class Round {

    /**
     * Rounds a double to 2 decimal places.
     * @param number
     * @return double rounded number
     */
    public static double roundToTwoDecimals(double number) {
        // needs validation
        BigDecimal bd = new BigDecimal(String.valueOf(number));
        bd.setScale(2, RoundingMode.HALF_EVEN);
        return bd.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
    
    /**
     * Rounds a String number to 2 decimal places.
     * @param number
     * @return double rounded number
     */
    public static double roundToTwoDecimals(String number) {
        // needs validation
        BigDecimal bd = new BigDecimal(number);
        bd.setScale(2, RoundingMode.HALF_EVEN);
        return bd.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
    
    /**
     * Rounds a double to the nearest Integer.
     * @param number
     * @return integer rounded number
     */
    public static int roundToInteger(double number) {
        // needs validation
        BigDecimal bd = new BigDecimal(String.valueOf(number));
        bd.setScale(0, RoundingMode.HALF_EVEN);
        return bd.setScale(0, RoundingMode.HALF_EVEN).intValue();
        
    }
}
