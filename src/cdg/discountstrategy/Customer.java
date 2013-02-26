
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Customer {
    
    private String custId;
    private String custName;
    
    public Customer(String custId, String custName) {
        // validate custId
        if (custId == null || custId.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        // validate custName
        if (custName == null || custName.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        setCustId(custId);
        setCustName(custName);
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        // validate custId
        if (custId == null || custId.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        // validate custName
        if (custName == null || custName.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        this.custName = custName;
    }


}
