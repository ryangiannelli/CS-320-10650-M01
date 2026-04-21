package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Tests for the ContactService class
public class ContactServiceTest {

    private ContactService service;

    // Fresh service for each test so they do not affect each other
    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    // Should add a contact successfully
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        service.addContact(contact);
        assertNotNull(service.getContact("1234567890"));
        assertEquals("Ryan", service.getContact("1234567890").getFirstName());
    }

    // Should not allow duplicate contact IDs
    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        Contact contact2 = new Contact("1234567890", "John", "Smith", "9876543210", "456 Oak Ave");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Should not allow adding a null contact
    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    // Should delete a contact by ID
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    // Should throw an exception if the contact does not exist
    @Test
    public void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("9999999999");
        });
    }

    // Should update first name for an existing contact
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1234567890", "John");
        assertEquals("John", service.getContact("1234567890").getFirstName());
    }

    // Should throw an exception if the contact does not exist
    @Test
    public void testUpdateFirstNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("9999999999", "John");
        });
    }

    // Should update last name for an existing contact
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1234567890", "Smith");
        assertEquals("Smith", service.getContact("1234567890").getLastName());
    }

    // Should throw an exception if the contact does not exist
    @Test
    public void testUpdateLastNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("9999999999", "Smith");
        });
    }

    // Should update phone for an existing contact
    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1234567890", "9876543210");
        assertEquals("9876543210", service.getContact("1234567890").getPhone());
    }

    // Should throw an exception if the contact does not exist
    @Test
    public void testUpdatePhoneNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("9999999999", "9876543210");
        });
    }

    // Should update address for an existing contact
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "Ryan", "Giannelli", "8601234567", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1234567890", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("1234567890").getAddress());
    }

    // Should throw an exception if the contact does not exist
    @Test
    public void testUpdateAddressNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("9999999999", "456 Oak Ave");
        });
    }
}