package problem2;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("EcoBank");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        bank.addTransaction(c1, 150.0);
        bank.addTransaction(c1, -50.0);
        bank.addTransaction(c2, 200.0);

        bank.displayCustomers();
    }
}
