package klanten_bestand.project.model;

public class Customer {

    int customerId;
    String infix;
    String surname;
    String residence;
    static int amountOfCustomers = 0;

    public Customer(String infix, String surname, String residence) {
        this.customerId = amountOfCustomers++;
        this.infix = infix;
        this.surname = surname;
        this.residence = residence;
    }

    public String getInfix() {
        return infix;
    }

    public String getSurname() {
        return surname;
    }

    public String getResidence() {
        return residence;
    }

    @Override
    public String toString() {
        return String.format("Klant : {%d, %s, %s, %s}", customerId, infix, surname, residence);
    }
}
