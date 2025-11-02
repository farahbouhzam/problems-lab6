package challenge;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();

        // Add towns ordered by distance (method keeps them sorted)
        addPlace(places, new Place("Sydney", 0));
        addPlace(places, new Place("Melbourne", 877));
        addPlace(places, new Place("Brisbane", 917));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Alice Springs", 2771));
        addPlace(places, new Place("Perth", 3923));
        addPlace(places, new Place("Darwin", 3972));

        visit(places);
    }

    // === Method to insert a place in order and avoid duplicates ===
    private static void addPlace(LinkedList<Place> list, Place newPlace) {
        ListIterator<Place> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Place current = iterator.next();

            // Duplicate check
            if (current.getName().equalsIgnoreCase(newPlace.getName())) {
                System.out.println("❗ " + newPlace.getName() + " is already included in the list.");
                return;
            }

            // Insert in order
            if (current.getDistanceFromSydney() > newPlace.getDistanceFromSydney()) {
                iterator.previous(); // step back to insert before current
                iterator.add(newPlace);
                return;
            }
        }

        // If we reached the end, add it at the end
        iterator.add(newPlace);
    }

    // === Method to display the interactive itinerary menu ===
    private static void visit(LinkedList<Place> places) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Place> iterator = places.listIterator();
        printMenu();

        if (places.isEmpty()) {
            System.out.println("No places in the itinerary.");
            return;
        } else {
            System.out.println("Starting at " + iterator.next());
        }

        while (!quit) {
            System.out.print("\nEnter action: ");
            String action = scanner.nextLine().toUpperCase();

            switch (action) {
                case "F":
                    if (!goingForward) {
                        if (iterator.hasNext()) iterator.next();
                        goingForward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("You have reached the end of the list.");
                        goingForward = false;
                    }
                    break;

                case "B":
                    if (goingForward) {
                        if (iterator.hasPrevious()) iterator.previous();
                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("You are at the start of the list.");
                        goingForward = true;
                    }
                    break;

                case "L":
                    printList(places);
                    break;

                case "M":
                    printMenu();
                    break;

                case "Q":
                    quit = true;
                    System.out.println("Exiting itinerary.");
                    break;

                default:
                    System.out.println("Invalid option. Type 'M' to see the menu.");
            }
        }
    }

    // === Helper method to print all places ===
    private static void printList(LinkedList<Place> places) {
        System.out.println("\n--- List of places to visit ---");
        for (Place place : places) {
            System.out.println(" • " + place);
        }
    }

    // === Helper method to print the menu ===
    private static void printMenu() {
        System.out.println("""
            \nAvailable actions (select letter):
            (F)orward
            (B)ackward
            (L)ist places
            (M)enu
            (Q)uit
            """);
    }
}
