public class RadixSort {
    public void sort(Product[] products)
    {
        // Find the maximum price to determine the number of digits
        double maxPrice = getMaxPrice(products);

        // Perform Radix Sort on the products array based on prices
        for (double divisor = 1; maxPrice / divisor > 0; divisor *= 10) {
            countingSort(products, divisor);
        }
    }

    public void sortByName(Product[] products) {
        // Extract the product names as strings
        String[] names = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            names[i] = products[i].getProductName();
        }

        // Find the maximum length of product names
        int maxLength = findMaxLength(names);

        // Perform counting sort on each character from right to left
        for (int i = maxLength - 1; i >= 0; i--) {
            countingSortByName(products, i);
        }
    }

    private int findMaxLength(String[] names) {
        int maxLength = 0;
        for (String name : names) {
            if (name.length() > maxLength) {
                maxLength = name.length();
            }
        }
        return maxLength;
    }

    private void countingSortByName(Product[] products, int position) {
        final int MAX_CHAR = 256; // Assuming ASCII characters

        Product[] output = new Product[products.length];
        int[] count = new int[MAX_CHAR];

        // Initialize count array
        for (int i = 0; i < MAX_CHAR; i++) {
            count[i] = 0;
        }

        // Count occurrences of characters at the given position
        for (Product product : products) {
            String name = product.getProductName();
            int index = position < name.length() ? name.charAt(position) : 0;
            count[index]++;
        }

        // Calculate cumulative count
        for (int i = 1; i < MAX_CHAR; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array in sorted order
        for (int i = products.length - 1; i >= 0; i--) {
            String name = products[i].getProductName();
            int index = position < name.length() ? name.charAt(position) : 0;
            output[count[index] - 1] = products[i];
            count[index]--;
        }

        // Copy the sorted products back to the original array
        System.arraycopy(output, 0, products, 0, products.length);
    }


    private void countingSort(Product[] products, double divisor) {
        int n = products.length;
        int[] count = new int[10];
        Product[] output = new Product[n];

        // Count occurrences of each digit in current place value
        for (int i = 0; i < n; i++) {
            int digit = (int) ((products[i].getPrice() / divisor) % 10);
            count[digit]++;
        }

        // Calculate cumulative count to determine positions in output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (int) ((products[i].getPrice() / divisor) % 10);
            output[count[digit] - 1] = products[i];
            count[digit]--;
        }

        // Copy the sorted output array to the original array
        System.arraycopy(output, 0, products, 0, n);
    }

    private double getMaxPrice(Product[] products) {
        double maxPrice = Double.MIN_VALUE;
        for (Product product : products) {
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
        }
        return maxPrice;
    }
}
