package problem3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter library capacity: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Library library = new Library(n);

        // Initialize with two documents
        Novel novel1 = new Novel("Novel1", "Author1", 200, 19.99);
        Dictionary dic1 = new Dictionary("Oxford", "English");

        library.add(novel1);
        library.add(dic1);

        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add a document");
            System.out.println("2. Display documents");
            System.out.println("3. Display authors");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter type (Dictionary/Magazine/Textbook/Novel): ");
                    String type = scanner.next();
                    scanner.nextLine();
                    if (type.equalsIgnoreCase("Dictionary")) {
                        System.out.print("Enter title and language: ");
                        String title = scanner.next();
                        String lang = scanner.next();
                        library.add(new Dictionary(title, lang));
                    }
                    break;

                case 2:
                    library.displayDocuments();
                    break;

                case 3:
                    library.displayAuthors();
                    break;
            }
        } while (choice != 0);
    }
}
