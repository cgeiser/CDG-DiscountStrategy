
package cdg.discountstrategy;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * Construct the HeaderPanel for GuiReceipt.
 * 
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class HeaderPanel1 extends JPanel {

    public HeaderPanel1() {
        setLayout(new GridLayout(3,1));
        
        
        JLabel title = new JLabel("Mom & Pop General Store");
        add(title);
        JLabel info1 = new JLabel("Anytown, USA  65432");
        add(info1);
        JLabel info2 = new JLabel("(555) 444-9999");
        add(info2);
    }
}
