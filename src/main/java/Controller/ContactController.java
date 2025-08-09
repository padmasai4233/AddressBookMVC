package Controller;

import Model.Contact;
import View.ContactView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactController {
    private List<Contact> contacts = new ArrayList<>();
    private ContactView view;

    public ContactController(ContactView view) {
        this.view = view;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        view.showMessage("Contact added successfully!");
    }

    public void editContact(String name, Contact newContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.set(i, newContact);
                view.showMessage("Contact updated successfully!");
                return;
            }
        }
        view.showMessage("Contact not found!");
    }

    public void deleteContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        view.showMessage("Contact deleted successfully!");
    }

    public void searchContact(String keyword) {
        List<Contact> results = contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(keyword)
                        || c.getPhoneNumber().equalsIgnoreCase(keyword)
                        || c.getEmail().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
        view.showAllContacts(results);
    }

    public void sortContacts(String criteria) {
        switch (criteria.toLowerCase()) {
            case "name":
                contacts.sort(Comparator.comparing(Contact::getName));
                break;
            case "phone":
                contacts.sort(Comparator.comparing(Contact::getPhoneNumber));
                break;
            case "email":
                contacts.sort(Comparator.comparing(Contact::getEmail));
                break;
            default:
                view.showMessage("Invalid sort criteria!");
                return;
        }
        view.showAllContacts(contacts);
    }

    public void showAllContacts() {
        view.showAllContacts(contacts);
    }
}
