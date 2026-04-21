package contact;

import java.util.HashMap;
import java.util.Map;

// Manages contacts in memory using a HashMap
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a contact if the ID is unique
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    // Update methods for each updatable field
    public void updateFirstName(String contactId, String firstName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.get(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.get(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.get(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.get(contactId).setAddress(address);
    }

    // Helper method to retrieve a contact by ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}