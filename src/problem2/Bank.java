package problem2;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addCustomer(Customer customer) {
        if (customers.contains(customer)) {
            System.out.println("Customer already exists.");
        } else {
            customers.add(customer);
            System.out.println("Customer added successfully.");
        }
    }

    public void addTransaction(Customer customer, double amount) {
        if (customers.contains(customer)) {
            customer.addTransaction(amount);
            System.out.println("Transaction added for " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void displayCustomers() {
        System.out.println("\n--- Bank Statement for " + name + " ---");
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName());
            System.out.print("Transactions: ");
            for (Double d : customer.getTransactions()) {
                System.out.print(d + "  ");
            }

            double total = 0;
            for (Double d : customer.getTransactions()) {
                total += d; // unboxing
            }

            System.out.println("\nTotal balance: " + total + "\n");
        }
    }
}
