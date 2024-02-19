import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductCSVReader {
    private static final String COMMA_DELIMITER = ",";
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRICE_INDEX = 3;

    public static Product[] readProducts(String filePath) {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 6) {
                    String productName = data[PRODUCT_NAME_INDEX];
                    String priceStr = data[PRICE_INDEX].trim();
                    double price;
                    try {
                        price = Double.parseDouble(priceStr);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    Product product = new Product(productName, price);
                    productList.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList.toArray(new Product[0]);
    }

}
