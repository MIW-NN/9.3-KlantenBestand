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

public class KlantFactoryTest {
    private final String CUSTOMERS_FILE = "src/main/resources/Klanten.txt";

    @Test
    public void onCreatingKlantFactory_arraysAreFilled() {
        Assert.assertNull(KlantFactory.namenLijst);
        Assert.assertNull(KlantFactory.plaatsenLijst);
        Assert.assertNull(KlantFactory.klantenLijst);
        var factory = new KlantFactory(75);

        Assert.assertNotEquals(0,KlantFactory.namenLijst.size());
        Assert.assertNotEquals(0,KlantFactory.plaatsenLijst.size());
        Assert.assertNotEquals(0,KlantFactory.klantenLijst.size());
    }

    @Test
    public void onMaakKlantenBestand_expectCustomerFileToBeFilled() throws FileNotFoundException {
        var aantalKlanten = 75;

        var factory = new KlantFactory(aantalKlanten);
        factory.maakKlantenBestand();

        var array = new ArrayList<>();
        var file = new File(CUSTOMERS_FILE);
        var reader = new Scanner(file);

        while (reader.hasNextLine()) {
            array.add(reader.nextLine());
        }

        Assert.assertEquals(aantalKlanten, array.size());
        leegKlantenTxt();
    }

    public void leegKlantenTxt() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(CUSTOMERS_FILE);
        printWriter.print("");
        printWriter.close();
    }
}
