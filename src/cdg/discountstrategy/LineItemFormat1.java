package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * Used in the ConsoleReceipt to output to the console.
 * This formats the line item as:
 * itemID  itemDesc x qty   extendedPrice
 * discDesc             discount
 * 
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class LineItemFormat1 implements ConsoleReceiptLineItemFormatStrategy {

    private NumberFormat money = NumberFormat.getCurrencyInstance();
    
    private CharSequence spaces = "                                           ";
    
    private StringBuilder section;
    
    /**
     * Returns a formatted LineItem using width = rowWidth.
     * @param lineItem
     * @param rowWidth
     * @return String
     */
    @Override
    public String formatLineItem(LineItem lineItem, int rowWidth) {
        int spaceCount = 0;
        section = new StringBuilder();
        section.append("\n");
        // Item Line 1
        section.append(lineItem.getItem().getProductId());
        spaceCount += lineItem.getItem().getProductId().length();
        section.append(spaces, 0, 3);
        spaceCount += 3;
        section.append(lineItem.getItem().getProductDesc());
        spaceCount += lineItem.getItem().getProductDesc().length();
        section.append(" x ");
        spaceCount += 3;
        section.append(lineItem.getQuantity());
        spaceCount += Integer.toString(lineItem.getQuantity()).length();
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
