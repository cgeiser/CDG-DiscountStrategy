package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * Used in ConsoleReceipt to format each LineItem section.
 * This formats the LineItem as:
 * LineItem#  itemId  itemDesc qty(if>1) ExtendedPrice
 * discDesc  discount
 * 
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class LineItemFormat3 implements ConsoleReceiptLineItemFormatStrategy {

    NumberFormat money = NumberFormat.getCurrencyInstance();
    NumberFormat disct = NumberFormat.getInstance();
    
    private CharSequence spaces = "                                           ";
    private StringBuilder section;
    static int lineCounter = 0;
    
    /**
     * Accepts a LineItem and the rowWidth.
     * @param lineItem
     * @param rowWidth
     * @return String
     */
    @Override
    public String formatLineItem(LineItem lineItem, int rowWidth) {
        // needs validation
        lineCounter ++;
        int spaceCount = 0;
        section = new StringBuilder();
        section.append("\n");
        // Item Line 1
        section.append(lineCounter);
        spaceCount += Integer.toString(lineCounter).length();
        section.append(": ");
        spaceCount += 2;
        section.append(lineItem.getItem().getProductId());
        spaceCount += lineItem.getItem().getProductId().length();
        section.append(spaces, 0, 3);
        spaceCount += 3;
        section.append(lineItem.getItem().getProductDesc());
        spaceCount += lineItem.getItem().getProductDesc().length();
        if (lineItem.getQuantity() > 1) {
            section.append(" x ");
            spaceCount += 3;
            section.append(lineItem.getQuantity());
            spaceCount += Integer.toString(lineItem.getQuantity()).length();
        }
        String pr = money.format(lineItem.getExtendedOriginalPrice());
        spaceCount += pr.length();
//                Chris =  fgvftcygtf uyk6rfv ut==
        section.append(spaces, 0, rowWidth - spaceCount);
        section.append(pr);
        section.append("\n  ");

        // Discount Desc Line
        DiscountStrategy ds = lineItem.getItem()
                .getProductDiscStrategy();
        spaceCount = 2;
        if (lineItem.getDiscountAmt() > 0) {
            String desc = lineItem.getItem()
                    .getProductDiscStrategy().getDiscountDesc();
            section.append(desc);
            spaceCount += desc.length();
            String disc = money.format(0 - lineItem.getDiscountAmt());
            spaceCount += disc.length();
            section.append(spaces, 0, rowWidth - spaceCount);
            section.append(disc);
        }
        return section.toString();
    }
}
