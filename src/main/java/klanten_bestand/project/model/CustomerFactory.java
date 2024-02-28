package klanten_bestand.project.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerFactory {
    public static final int DEFAULT_SIZE = 100;
    private final String PLACES_FILE = "9.3 Plaatsnamenlijst.txt";
    private final String NAMES_FILE = "9.3 NamenlijstGroot.csv";
    private final String CUSTOMERS_FILE = "Klanten.txt";
    private final ClassLoader classloader;
    public int listSize;
    public static ArrayList<String> namesList;
    public static ArrayList<String> placesList;
    public static ArrayList<Customer> customerList;
    PrintWriter printWriter;

    public CustomerFactory() {
        this(DEFAULT_SIZE);
    }

    public CustomerFactory(int listSize) {
        this.listSize = listSize;
        classloader = Thread.currentThread().getContextClassLoader();
        createPlacesList();
        createNamesList();
        createCustomersList();
    }

    private void createPlacesList() {
        Scanner namesReader;
        placesList = new ArrayList<>();
        try {
            var filePath = classloader.getResource(PLACES_FILE).toURI().getPath();
            File namesFile = new File(filePath);
            namesReader = new Scanner(namesFile);
            while (namesReader.hasNextLine()) {
                placesList.add(namesReader.nextLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("Het namenbestand is niet gevonden.");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNamesList() {
        Scanner namesReader;
        namesList = new ArrayList<>();
        try {
            var filePath = classloader.getResource(NAMES_FILE).toURI().getPath();
            File namesFile = new File(filePath);
            namesReader = new Scanner(namesFile);
            while (namesReader.hasNextLine()) {
                namesList.add(namesReader.nextLine());
            }

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("Het namenbestand is niet gevonden.");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRandomPlace() {
        int randomIndex = (int) (placesList.size() * Math.random());
        return placesList.get(randomIndex);
    }

    private String getRandomName() {
        int randomIndex = (int) (namesList.size() * Math.random());
        return namesList.get(randomIndex);
    }

    private void createCustomersList() {
        customerList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            String[] naamSplit = getRandomName().split(",");
            String tussenvoegsel = naamSplit[0];
            String achternaam = naamSplit[1];
            Customer nieuweKlant = new Customer(tussenvoegsel, achternaam, getRandomPlace());
            customerList.add(nieuweKlant);
        }
    }

    public void createCustomerFile() {
        try {

            var filePath = classloader.getResource(PLACES_FILE).toURI().getPath();
            File customersFile = new File(filePath);
            printWriter = new PrintWriter(customersFile);
            for (int i = 0; i < listSize; i++) {
                String name = customerList.get(i).getInfix();
                if (name.equals("")) {
                    name = customerList.get(i).getSurname();
                } else {
                    name = name + " " + customerList.get(i).getSurname();
                }
                printWriter.printf("%6d %-20s %s\n", i+1,
                        name, customerList.get(i).getResidence());
            }
            printWriter.close();
        } catch (Exception error) {
            error.getMessage();
        } finally {
            printWriter.close();
        }
    }
}
