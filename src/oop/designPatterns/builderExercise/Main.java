package oop.designPatterns.builderExercise;

import java.util.*;

public class Main {

    private static final String CREATE_COMMAND = "CREATE";
    private static final String CONTACT_INFO_COMMAND = "INFO";
    private static final String DELETE_CONTACT_COMMAND = "DELETE";
    private static final String PHONEBOOK_COMMAND = "PHONEBOOK";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Phonebook phonebook = new Phonebook();

        String command = scanner.nextLine();

        while (!END_COMMAND.equals(command)) {

            if (command.equals(CONTACT_INFO_COMMAND)) {
                String name = scanner.nextLine();

                Contact contact = phonebook.getContactByName(name);
                System.out.println(contact.toString());

            } else if (command.equals(DELETE_CONTACT_COMMAND)) {
                String name = scanner.nextLine();
                System.out.println("Was contact deleted: " + phonebook.deleteContactByName(name));

            } else if (command.equals(CREATE_COMMAND)) {
                List<String> contactInfo = readContactInfo(scanner);

                String name = contactInfo.get(0);
                String number = contactInfo.get(1);
                String company = contactInfo.get(2);
                String title = contactInfo.get(3);
                String email = contactInfo.get(4);
                String website = contactInfo.get(5);
                String birthday = contactInfo.get(6);

                try {
                    Contact contact = Contact.builder()
                            .withName(name)
                            .withNumber(number)
                            .withCompany(company)
                            .withTitle(title)
                            .withEmail(email)
                            .withWebsite(website)
                            .withBirthday(birthday)
                            .build();

                    phonebook.addContact(contact);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }

            } else if (command.equals(PHONEBOOK_COMMAND)) {
                Collection<Contact> allContacts = phonebook.getAllContacts();

                allContacts.forEach(c -> System.out.println(c.toString()));
            }

            command = scanner.nextLine();
        }
    }

    private static List<String> readContactInfo(Scanner input) {
        List<String> contactInfo = new ArrayList<>();

        System.out.print("Name: ");
        contactInfo.add(input.nextLine());

        System.out.print("Number: ");
        contactInfo.add(input.nextLine());

        System.out.print("Company: ");
        contactInfo.add(input.nextLine());

        System.out.print("Title: ");
        contactInfo.add(input.nextLine());

        System.out.print("Email: ");
        contactInfo.add(input.nextLine());

        System.out.print("Website: ");
        contactInfo.add(input.nextLine());

        System.out.print("Birthday: ");
        contactInfo.add(input.nextLine());

        return contactInfo;
    }
}
