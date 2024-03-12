package klanten_bestand.project.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerFactoryTest {
    private final String CUSTOMERS_FILE = "src/main/resources/Klanten.txt";

    @Test
    public void onCreatingCustomerFactory_arraysAreFilled() {
        Assert.assertNull(CustomerFactory.namesList);
        Assert.assertNull(CustomerFactory.placesList);
        Assert.assertNull(CustomerFactory.customerList);
        var factory = new CustomerFactory(75);

        Assert.assertNotEquals(0,CustomerFactory.namesList.size());
        Assert.assertNotEquals(0,CustomerFactory.placesList.size());
        Assert.assertNotEquals(0,CustomerFactory.customerList.size());
    }

    @Test
    public void onCreateCustomerFile_expectCustomerFileToBeFilled() throws FileNotFoundException {
        var customerCount = 75;

        var factory = new CustomerFactory(customerCount);
        factory.createCustomerFile();

        var array = new ArrayList<>();
        var file = new File(CUSTOMERS_FILE);
        var reader = new Scanner(file);

        while (reader.hasNextLine()) {
            array.add(reader.nextLine());
        }

        Assert.assertEquals(customerCount, array.size());
        EmptyKlantenTXT();
    }

    public void EmptyKlantenTXT() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(CUSTOMERS_FILE);
        printWriter.print("");
        printWriter.close();
    }
}