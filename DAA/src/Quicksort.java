public class Quicksort {
    public void sort(Customer[] customers) {
        quicksort(customers, 0, customers.length - 1);
    }

    private void quicksort(Customer[] customers, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(customers, low, high);
            quicksort(customers, low, pivotIndex - 1);
            quicksort(customers, pivotIndex + 1, high);
        }
    }

    private int partition(Customer[] customers, int low, int high) {
        Customer pivot = customers[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (customers[j].getContactFirstName().compareToIgnoreCase(pivot.getContactFirstName()) <= 0)
            {
                i++;
                swap(customers, i, j);
            }
        }

        swap(customers, i + 1, high);
        return i + 1;
    }

    private void swap(Customer[] customers, int i, int j) {
        Customer temp = customers[i];
        customers[i] = customers[j];
        customers[j] = temp;
    }
}
