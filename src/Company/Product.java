package Company;

public class Product {

    private int prodID;
    private String name;
    private int quantity;

    public Product(int prodID, String name, int quantity) {
        this.prodID = prodID;
        this.name = name;
        this.quantity = quantity;
    }

    public void SellItem(int sold) {
        quantity += sold;
    }

    @Override
    public String toString() {
        String text = "";
        text += "Item Name: " + name + " Amount sold: " + quantity;

        return text;
    }
}
