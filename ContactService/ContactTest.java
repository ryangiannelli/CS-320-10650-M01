package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Tests for the Contact class
public class ContactTest {

    // Valid contact should be created without issues
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Ryan", contact.getFirstName());
        assertEquals("Giannelli", contact.getLastName());
        assertEquals("8601234567", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Contact ID cannot be longer than 10 characters
    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Ryan", "Giannelli", "8601234567", "123 Main St");
        });
    }

    // Contact ID cannot be null
    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ryan", "Giannelli", "8601234567", "123 Main St");
        });
    }

    // First name cannot be longer than 10 characters
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryannnnnnnn", "Giannelli", "8601234567", "123 Main St");
        });
    }

    // First name cannot be null
    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Giannelli", "8601234567", "123 Main St");
        });
    }

    // Last name cannot be longer than 10 characters
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelliii", "8601234567", "123 Main St");
        });
    }

    // Last name cannot be null
    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", null, "8601234567", "123 Main St");
        });
    }

    // Phone cannot be longer than 10 digits
    @Test
    public void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelli", "86012345678", "123 Main St");
        });
    }

    // Phone cannot be shorter than 10 digits
    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelli", "860123456", "123 Main St");
        });
    }

    // Phone cannot be null
    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelli", null, "123 Main St");
        });
    }

    // Phone must only contain digits
    @Test
    public void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelli", "860abc4567", "123 Main St");
        });
    }

    // Address cannot be longer than 30 characters
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "1234567890123456789012345678901");
        });
    }

    // Address cannot be null
    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Ryan", "Giannelli", "8601234567", null);
        });
    }

    // First name should update with a valid value
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());
    }

    // First name should not update with an invalid value
    @Test
    public void testSetFirstNameInvalid() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // Last name should update with a valid value
    @Test
    public void testSetLastName() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    // Last name should not update with an invalid value
    @Test
    public void testSetLastNameInvalid() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // Phone should update with a valid value
    @Test
    public void testSetPhone() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }

    // Phone should not update with an invalid value
    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
    }

    // Address should update with a valid value
    @Test
    public void testSetAddress() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // Address should not update with an invalid value
    @Test
    public void testSetAddressInvalid() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    // Contact ID should not be updatable since there is no setter
    @Test
    public void testContactIdNotUpdatable() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }
}