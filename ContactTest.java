package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    
    // Tests to ensure the Contact ID cannot be less than 10 characters
    @Test
    public void testContactIDLessThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("890", "Tim", "Lee", "2223334444", "200 Broad St."));
    }

    // Tests to ensure a Contact ID of exactly 10 characters is considered valid
    @Test
    public void testContactIDEquals10() {
        assertDoesNotThrow(() -> new Contact("8765432109", "Samantha", "Brown", "1112223333", "300 Pine St."));
    }

    // Tests to ensure the Contact ID cannot be greater than 10 characters
    @Test
    public void testContactIDGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Charlie", "Green", "4445556666", "400 Maple St."));
    }

    // Tests to ensure the Contact ID cannot be null
    @Test
    public void testContactIDIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "NoName", "NullLast", "0001112222", "No Address St."));
    }

    // Verifies that getter methods return the correct values
    @Test
    public void testGetters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0123456789", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }
    
    // Verifies that setting firstName to its maximum allowed length does not throw an exception
    @Test
    public void testSetFirstNameWithMaxLength() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertDoesNotThrow(() -> contact.setFirstName("1234567890"));
        assertEquals("1234567890", contact.getFirstName());
    }

    // Tests setting the first name with a valid maximum length input
    @Test
    public void testSetFirstNameWithMaxLengthValid() {
        Contact contact = new Contact("1234567890", "ValidName", "Doe", "0123456789", "123 Main St");
        assertDoesNotThrow(() -> contact.setFirstName("1234567890"));
        assertEquals("1234567890", contact.getFirstName());
    }

    // Tests setting the first name with an input length that exceeds the maximum allowed, expecting an exception
    @Test
    public void testSetFirstNameWithInvalidLength() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("12345678901"));
    }

    // Tests setting the last name with an invalid input that exceeds maximum character length
    @Test
    public void testSetLastNameWithInvalidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ALongSurnameIndeed"));
    }

    // Tests setting the last name with a valid input
    @Test
    public void testSetLastNameWithValidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertDoesNotThrow(() -> contact.setLastName("Smith"));
        assertEquals("Smith", contact.getLastName());
    }

    // Tests setting the phone number with an input shorter than the required length
    @Test
    public void testSetPhoneNumberWithInvalidInputShort() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("12345"));
    }

    // Tests setting the phone number with a non-numeric input
    @Test
    public void testSetPhoneNumberWithInvalidInputNonNumeric() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("abcdefghij"));
    }

    // Tests setting the phone number with a valid numeric input
    @Test
    public void testSetPhoneNumberWithValidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertDoesNotThrow(() -> contact.setPhoneNumber("9876543210"));
        assertEquals("9876543210", contact.getPhoneNumber());
    }

    // Tests setting the address with an input that exceeds the maximum allowed character length
    @Test
    public void testSetAddressWithInvalidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("12345 Main Street, Some City, Some State, 12345-6789"));
    }

    // Tests setting the address with a valid input
    @Test
    public void testSetAddressWithValidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        assertDoesNotThrow(() -> contact.setAddress("456 Elm St"));
        assertEquals("456 Elm St", contact.getAddress());
    }

    // Tests the toString method to ensure it returns the expected string representation of the Contact object
    @Test
    public void testToString() {
        Contact contact = new Contact("1234567890", "John", "Doe", "0123456789", "123 Main St");
        String expected = "Contact [contactID=1234567890, firstName=John, lastName=Doe, phoneNumber=0123456789, address=123 Main St]";
        assertEquals(expected, contact.toString());
    }

    // Tests constructing a Contact object with inputs at the maximum valid lengths
    @Test
    public void testConstructorWithMaxValidInputLengths() {
        String tenChars = "1234567890";
        String thirtyChars = "123456789012345678901234567890";
        assertDoesNotThrow(() -> new Contact(tenChars, tenChars, tenChars, tenChars, thirtyChars));
    }

    // Tests constructing a Contact object with an address at the maximum allowed length
    @Test
    public void testConstructorWithMaxAddressLength() {
        String maxAddress = "123456789012345678901234567890"; // 30 characters
        assertDoesNotThrow(() -> new Contact("1234567890", "John", "Doe", "0123456789", maxAddress));
    }

    // Tests constructing a Contact object with a phone number that does not match the required pattern
    @Test
    public void testConstructorWithInvalidPhoneNumberPattern() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "12345abcde", "123 Main St"));
    }
}

