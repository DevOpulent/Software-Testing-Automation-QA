package test;

import java.util.ArrayList;

public class ContactService {
    private ArrayList<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getContactID().equals(contact.getContactID())) {
                return false;
            }
        }
        contacts.add(contact);
        return true;
    }

    public boolean deleteContact(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    public boolean updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                if (firstName != null && !firstName.isBlank() && firstName.length() <= 10) {
                    contact.setFirstName(firstName);
                }
                if (lastName != null && !lastName.isBlank() && lastName.length() <= 10) {
                    contact.setLastName(lastName);
                }
                if (phoneNumber != null && !phoneNumber.isBlank() && phoneNumber.matches("\\d{10}")) {
                    contact.setPhoneNumber(phoneNumber);
                }
                if (address != null && !address.isBlank() && address.length() <= 30) {
                    contact.setAddress(address);
                }
                return true;
            }
        }
        return false;
    }

    // Retrieves a contact by its ID.
    public Contact getContact(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null; // Contact not found.
    }
}
