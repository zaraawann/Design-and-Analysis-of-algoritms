public class Mergesort {
    public void sort(Customer[] customers) {
        mergesort(customers, 0, customers.length - 1);
    }

    private void mergesort(Customer[] customers, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergesort(customers, low, mid);
            mergesort(customers, mid + 1, high);
            merge(customers, low, mid, high);
        }
    }

    private void merge(Customer[] customers, int low, int mid, int high) {
        Customer[] temp = new Customer[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (customers[left].getContactFirstName().compareToIgnoreCase(customers[right].getContactFirstName()) <= 0) {
                temp[k] = customers[left];
                left++;
            } else {
                temp[k] = customers[right];
                right++;
            }
            k++;
        }

        while (left <= mid) {
            temp[k] = customers[left];
            left++;
            k++;
        }

        while (right <= high) {
            temp[k] = customers[right];
            right++;
            k++;
        }

        for (int i = 0; i < temp.length; i++) {
            customers[low + i] = temp[i];
        }
    }
}
