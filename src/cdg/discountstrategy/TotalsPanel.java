package cdg.discountstrategy;

import java.awt.GridLayout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * Constructs the TotalsPanel for GuiReceipt.
 * Displays the subtotal, tax amount, total, amount saved, date of sale.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class TotalsPanel extends JPanel {

    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");
    
    
    public TotalsPanel(Ticket t) {
        // needs validation
        setLayout(new GridLayout(4,1));
        
        
        JLabel sub = new JLabel("Subtotal  " + money.format(t.getSubtotal()));
        add(sub);
        JLabel tax = new JLabel("Tax       " + money.format(t.getSalesTax()));
        add(tax);
        JLabel total = new JLabel("TOTAL     " + money.format(t.getTotalSale()));
        add(total);
        JLabel saved = new JLabel("----- You saved: " + money.format(t.getAmountSaved())
                + " -----    " + sdf.format(t.getSaleDate()));
        add(saved);
    }
}
