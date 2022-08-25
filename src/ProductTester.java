
import Company.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductTester {

    public static void main(String[] args) {
        Map<Integer, Product> products = new HashMap<>();
        Map<Integer, Customer> customers = new HashMap<>();
        String inFile = "sales.txt";

        try {
            InventoryMNGR(customers, products, inFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void InventoryMNGR(Map<Integer, Customer> cMap, Map<Integer, Product> pMap, String inFile) throws IOException {

        try (BufferedReader in = new BufferedReader(new FileReader(inFile))) {

            String check;

            while ((check = in.readLine()) != null) {
                String line = check;

                String inputs[] = line.split(" ");

                if (cMap.containsKey(Integer.parseInt(inputs[0]))) {
                    cMap.get(Integer.parseInt(inputs[0])).CalcBill(Integer.parseInt(inputs[6]), Integer.parseInt(inputs[5]));
                }
                if (pMap.containsKey(Integer.parseInt(inputs[3]))) {
                    pMap.get(Integer.parseInt(inputs[3])).SellItem(Integer.parseInt(inputs[6]));
                }
                if (!cMap.containsKey(Integer.parseInt(inputs[0]))) {
                    cMap.put(Integer.parseInt(inputs[0]), new Customer(Integer.parseInt(inputs[0]), inputs[1], inputs[2]));
                    cMap.get(Integer.parseInt(inputs[0])).CalcBill(Integer.parseInt(inputs[6]), Integer.parseInt(inputs[5]));
                }
                if (!pMap.containsKey(Integer.parseInt(inputs[3]))) {
                    pMap.put(Integer.parseInt(inputs[3]), new Product(Integer.parseInt(inputs[3]), inputs[4], Integer.parseInt(inputs[6])));
                }
            }
            for (Object key : cMap.entrySet()) {
                System.out.println(key.toString());

            }
            System.out.println("----------------------------------------------------------------------");
            for (Object key1 : pMap.entrySet()) {
                System.out.println(key1.toString());
            }
        }

    }
}
