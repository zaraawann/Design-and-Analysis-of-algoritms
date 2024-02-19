import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public Customer[] readCustomers(String filePath) {
        List<Customer> customersList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] data = line.split(",");
                if (data.length >= 5) {
                    String contactFirstName = data[3].trim();
                    String contactLastName = data[4].trim();
                    char contactInitials = contactFirstName.charAt(0);
                    customersList.add(new Customer(contactFirstName, contactLastName, contactInitials));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customersList.toArray(new Customer[0]);
    }

}
