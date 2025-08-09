import Controller.ContactController;
import Model.Contact;
import View.ContactView;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ContactView view = new ContactView();
        ContactController controller = new ContactController(view);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. Sort Contacts");
            System.out.println("6. Show All Contacts");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    controller.addContact(new Contact(name, phone, email, address));
                    break;
                case 2:
                    System.out.print("Enter Name of Contact to Edit: ");
                    String editName = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();
                    controller.editContact(editName, new Contact(newName, newPhone, newEmail, newAddress));
                    break;
                case 3:
                    System.out.print("Enter Name of Contact to Delete: ");
                    String delName = sc.nextLine();
                    controller.deleteContact(delName);
                    break;
                case 4:
                    System.out.print("Enter Name/Phone/Email to Search: ");
                    String keyword = sc.nextLine();
                    controller.searchContact(keyword);
                    break;
                case 5:
                    System.out.print("Sort by (name/phone/email): ");
                    String criteria = sc.nextLine();
                    controller.sortContacts(criteria);
                    break;
                case 6:
                    controller.showAllContacts();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
