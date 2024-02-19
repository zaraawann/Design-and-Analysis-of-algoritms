public class Customer {
    private String contactFirstName;
    private String contactLastName;

    public char getContactInitials() {
        return contactInitials;
    }

    public void setContactInitials(char contactInitials) {
        this.contactInitials = contactInitials;
    }

    private char contactInitials;

    public Customer(String contactFirstName, String contactLastName, char contactInitials) {
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactInitials = contactInitials;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }
}
