package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAdd() {
        ContactService cs = new ContactService();
        // Verify adding a new contact with a valid, unique 10-character ID is successful.
        Contact test1 = new Contact("8765432109", "Alex", "Smith", "5555555555", "Pioneer 30 Avenue");
        assertTrue(cs.addContact(test1));
    }

    @Test
    public void testDelete() {
        ContactService cs = new ContactService();
        // Setup: Add three contacts for deletion tests.
        Contact test1 = new Contact("8765432109", "Alex", "Smith", "5555555555", "Pioneer 30 Avenue");
        Contact test2 = new Contact("5678901234", "Chris", "Jordan", "1234567890", "Hilltop View");
        Contact test3 = new Contact("3456789012", "Pat", "Lee", "9876543210", "River Bend");
        cs.addContact(test1); cs.addContact(test2); cs.addContact(test3);

        // Test deletion functionality and handling of non-existent IDs.
        assertTrue(cs.deleteContact("5678901234")); // Check deletion is successful.
        assertFalse(cs.deleteContact("1111111111")); // Check non-existent contact can't be deleted.
        assertFalse(cs.deleteContact("5678901234")); // Verify re-deletion is handled correctly.
    }

    @Test
    public void testUpdate() {
        ContactService cs = new ContactService();
        // Add contacts for update testing.
        Contact test1 = new Contact("8765432109", "Alex", "Smith", "5555555555", "Pioneer 30 Avenue");
        Contact test2 = new Contact("5678901234", "Chris", "Jordan", "1234567890", "Hilltop View");
        Contact test3 = new Contact("3456789012", "Pat", "Lee", "9876543210", "River Bend");
        cs.addContact(test1); cs.addContact(test2); cs.addContact(test3);

        // Verify updating existing contact's details and handling of non-existent contacts.
        assertTrue(cs.updateContact("3456789012", "PatFirst", "LeeLast", "9876543210", "New River Bend")); // Successful update.
        assertFalse(cs.updateContact("2222222222", "NonExistent", "User", "0000000000", "Nowhere Land")); // Update fails for non-existent ID.
    }
    
    @Test
    //Unique ID Test
    public void testAddContactWithDuplicateIDFails() {
        ContactService cs = new ContactService();
        // Test to ensure unique IDs by trying to add two contacts with the same ID.
        Contact test1 = new Contact("1234567890", "John", "Doe", "5551234567", "100 Main St");
        assertTrue(cs.addContact(test1)); // First addition should succeed.

        Contact testDuplicateID = new Contact("1234567890", "Jane", "Roe", "5557654321", "101 Main St");
        assertFalse(cs.addContact(testDuplicateID)); // Second addition with duplicate ID should fail.
    }
    
    @Test
    public void testUpdateExistingContactFields() {
        ContactService cs = new ContactService();
        // Add a contact, then update its fields to verify the update functionality.
        Contact test1 = new Contact("8765432109", "Alex", "Smith", "5555555555", "Pioneer 30 Avenue");
        cs.addContact(test1);

        assertTrue(cs.updateContact("8765432109", "Alexa", "Smythe", "6666666666", "Pioneer 31 Avenue")); // Confirm fields are updated.

        // Retrieve and verify updated contact details.
        Contact updatedContact = cs.getContact("8765432109");
        assertEquals("Alexa", updatedContact.getFirstName());
        assertEquals("Smythe", updatedContact.getLastName());
        assertEquals("6666666666", updatedContact.getPhoneNumber());
        assertEquals("Pioneer 31 Avenue", updatedContact.getAddress());
    }
}
