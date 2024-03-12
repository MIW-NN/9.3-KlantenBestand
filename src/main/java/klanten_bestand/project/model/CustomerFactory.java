package klanten_bestand.project.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerFactory {
    public static final int DEFAULT_SIZE = 100;
    private final String PLACES_FILE = "src/main/resources/9.3 Plaatsnamenlijst.txt";
    private final String NAMES_FILE = "src/main/resources/9.3 NamenlijstGroot.csv";
    private final String CUSTOMERS_FILE = "src/main/resources/Klanten.txt";
    public int listSize;
    public static ArrayList<String> namesList;
    public static ArrayList<String> placesList;
    public static ArrayList<Customer> customerList;
    PrintWriter printWriter;

    public CustomerFactory() {
        this(DEFAULT_SIZE);
    }

    public CustomerFactory(int listSize) {
    }

    public void createCustomerFile() {
    }
}
