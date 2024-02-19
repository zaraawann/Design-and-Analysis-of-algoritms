import javax.sound.sampled.Line;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        int menChoice;

        System.out.println("[1] Customer Menu\n[2] Products Menu\n");
        menChoice = in.nextInt();


        Customer[] customers = new Customer[0];
        Product[] products = new Product[0];
        if (menChoice == 1) {
            customers = new Customer[0];
            //Read from CSV file and insert data into Customer Array
            CSVReader csvReader = new CSVReader();
            customers = csvReader.readCustomers("C:\\Users\\maazm\\Desktop\\DAA_Project_Maaz_Saif_Zara\\src\\Customer.csv");

            //Menu We created
            int run = 1;
            do {
                int choice;

                System.out.println("[1] Show Customer Full Name\n[2] Show Customer in Order using Quicksort\n[3] Show Customer in Order using MergeSort\n[4] Search Customer Index:");

                choice = in.nextInt();

                if (choice == 1) {
                    for (Customer customer : customers) {
                        System.out.println(customer.getContactFirstName() + " " + customer.getContactLastName());
                    }
                } else if (choice == 2) {
                    // Sort the array of customers using Quicksort
                    Quicksort quicksort = new Quicksort();
                    quicksort.sort(customers);

                    // Print the sorted list of customers
                    System.out.println("Sorted Customers:");
                    for (Customer customer : customers) {
                        System.out.println(customer.getContactFirstName());
                    }
                } else if (choice == 4) {
                    System.out.println("Enter Customer Full Name to be found: ");
                    String targetName = st.nextLine();
                    // Perform linear search
                    LinearSearch linearSearch = new LinearSearch();
                    int index = linearSearch.search(customers, targetName);

                    if (index != -1) {
                        System.out.println("Target name found at index: " + index);
                    } else {
                        System.out.println("Customer Not Found");
                    }
                } else if (choice == 3) {
                    Mergesort mergesort = new Mergesort();
                    mergesort.sort(customers);
                    // Print the sorted list of customers
                    System.out.println("Sorted Customers:");
                    for (Customer customer : customers) {
                        System.out.println(customer.getContactFirstName());
                    }
                } else
                    System.out.println("Invalid option");

                System.out.println("\nContinue?\n[1] Yes\n[2] Exit");
                int choice1 = in.nextInt();
                if (choice1 == 2)
                    run = 0;


            } while (run == 1);

        } else if (menChoice == 2) {
            products = new Product[0];

            // Read from CSV file and insert data into Product array
            ProductCSVReader csvReader = new ProductCSVReader();
            products = ProductCSVReader.readProducts("C:\\Users\\maazm\\Desktop\\DAA_Project_Maaz_Saif_Zara\\src\\Products.csv");

            // Menu options
            int run = 1;
            do {
                int choice;

                System.out.println("[1] Show Product Names\n[2] Show Products Sorted by Name\n[3] Show Products Sorted by Price");
                choice = in.nextInt();

                if (choice == 1) {
                    System.out.println("Product Names: ");
                    for (Product product : products) {
                        System.out.println(product.getProductName());
                    }
                } else if (choice == 2) {
                    // Sort the products by name using Radix Sort
                    RadixSort radixSort = new RadixSort();
                    radixSort.sortByName(products);

                    System.out.println("Products Sorted by Name:");
                    for (Product product : products) {
                        System.out.println(product.getProductName() + " - " + product.getPrice());
                    }
                } else if (choice == 3) {
                    RadixSort radixSort = new RadixSort();
                    radixSort.sort(products);

                    System.out.println("Products Sorted by Price:");
                    for (Product product : products) {
                        System.out.println(product.getProductName() + " - " + product.getPrice());
                    }
                } else if (choice == 6) {
                    run = 0;
                } else {
                    System.out.println("Invalid option");
                }
            } while (run == 1);
        }
    }
}
