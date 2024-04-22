package test;


public class Contact {
    // Fields to store the contact's details.
    String contactID;
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
   
    // Constructor to initialize a new Contact object.
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        // Validates that the contactID is not null and exactly 10 characters long.
        if (contactID == null || contactID.length() != 10) {
            throw new IllegalArgumentException("Contact ID must be exactly 10 characters long.");
        }
        // Validates that the firstName is not null and no longer than 10 characters.
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters and cannot be null.");
        }
        // Validates that the lastName is not null and no longer than 10 characters.
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters and cannot be null.");
        }
        // Validates that the phoneNumber is not null and matches a 10-digit numeric pattern.
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        // Validates that the address is not null and no longer than 30 characters.
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters and cannot be null.");
        }
        // Assigns the validated input to the class's fields.
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
  
    // Getter for contactID.
    // No setter for contactID.
    public String getContactID() {
        return contactID;
    }

    // Getter for firstName.
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName with validation.
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters and cannot be null.");
        }
        this.firstName = firstName;
    }

    // Getter for lastName.
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName with validation.
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters and cannot be null.");
        }
        this.lastName = lastName;
    }

    // Getter for phoneNumber.
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phoneNumber with validation.
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    // Getter for address.
    public String getAddress() {
        return address;
    }

    // Setter for address with validation.
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters and cannot be null.");
        }
        this.address = address;
    }

    // Overrides the Object's toString method to provide a string representation of the Contact object
    @Override
    public String toString() {
        return "Contact [contactID=" + contactID + ", firstName=" + firstName + ", lastName=" + lastName
                + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }  
}
