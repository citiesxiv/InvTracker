
package Company;


public class Customer {

    private int custID;
    private String fName;
    private String lName;
    private double bill;

    public Customer(int custID, String fName, String lName) {
        this.custID = custID;
        this.fName = fName;
        this.lName = lName;
        
    }

    public void CalcBill(int quantity, double price) {
        bill += quantity * price;

    }

    @Override
    public String toString() {
        String output = "";
        output += "Customer Name: " + fName + " " + lName + " Amount Owing: $" + bill;

        return output;
    }
}
