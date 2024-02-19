public class LinearSearch
{
    public int search(Customer[] customers, String targetName)
    {
        for (int i = 0; i < customers.length; i++) {
            String customerName = customers[i].getContactFirstName() + " " + customers[i].getContactLastName();
            if (customerName.equalsIgnoreCase(targetName)) {
                return i; // Found the target
            }
        }
        return -1; // Target not found
    }
}
