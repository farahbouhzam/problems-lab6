package problem1;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {

        ArrayList<Item> cart = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        String keepShopping = "y";
        double totalPrice = 0;

        do {
            System.out.print("Enter the name of the item: ");
            String itemName = scan.nextLine();

            System.out.print("Enter the unit price: ");
            double itemPrice = scan.nextDouble();

            System.out.print("Enter the quantity: ");
            int quantity = scan.nextInt();

            scan.nextLine(); // clear newline

            Item newItem = new Item(itemName, itemPrice, quantity);
            cart.add(newItem);

            // Print cart contents
            System.out.println("\n--- Cart Contents ---");
            totalPrice = 0;
            for (Item i : cart) {
                System.out.println(i);
                totalPrice += i.getPrice() * i.getQuantity();
            }

            System.out.println("---------------------");
            System.out.printf("Total price: %.2f\n", totalPrice);

            System.out.print("\nContinue shopping (y/n)? ");
            keepShopping = scan.nextLine();

        } while (keepShopping.equalsIgnoreCase("y"));

        System.out.println("\nThank you for shopping!");
    }
}
