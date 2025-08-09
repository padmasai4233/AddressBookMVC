package View;

import Model.Contact;
import java.util.List;

public class ContactView {
    public void showContact(Contact contact) {
        System.out.println(contact);
    }

    public void showAllContacts(List<Contact> contacts) {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
