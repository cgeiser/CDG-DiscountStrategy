package cdg.discountstrategy;

import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.*;

/**
 * Part of the GUIReceipt.
 * Accepts a Tickets and formats its LineItems for the LineItemSection.
 * @author cgeiser
 * @version 1.0
 */
public class LineItemPanel extends JPanel {
    
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    
    public LineItemPanel(Ticket t) {
        LineItem[] items = t.getLineItems();
        int x=0;
        for (LineItem a : items) {
            x ++;
        }
        setLayout(new GridLayout(x*2, 3));
        
        for (LineItem l : items) {
            // line 1
            JLabel id = new JLabel(l.getItem().getProductId());
            add(id);
            JLabel desc = new JLabel(l.getItem().getProductDesc());
            add(desc);
            JLabel price = new JLabel(money.format(l.getExtendedOriginalPrice()));
            add(price);
            // line 2
            JLabel blank = new JLabel("----");
            add(blank);
            JLabel discDesc = new JLabel(l.getItem().getProductDiscStrategy().getDiscountDesc());
            add(discDesc);
            JLabel disc = new JLabel(money.format(l.getDiscountAmt()));
            add(disc);
            
        }
    }
    
}
