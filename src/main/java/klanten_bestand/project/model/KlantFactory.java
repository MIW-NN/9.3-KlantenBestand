package klanten_bestand.project.model;

import java.io.PrintWriter;
import java.util.ArrayList;

public class KlantFactory {
    public static final int DEFAULT_SIZE = 100;
    private final String PLAATSEN_BESTAND = "src/main/resources/9.3 Plaatsnamenlijst.txt";
    private final String NAMEN_BESTAND = "src/main/resources/9.3 NamenlijstGroot.csv";
    private final String KLANTEN_BESTAND = "src/main/resources/Klanten.txt";

    public int listSize;
    public static ArrayList<String> namenlijst;
    public static ArrayList<String> plaatsenlijst;
    public static ArrayList<Klant> klantenlijst;
    PrintWriter printWriter;

    public KlantFactory() {
        this(DEFAULT_SIZE);
    }

    public KlantFactory(int listSize) {
    }

    public void createCustomerFile() {
    }
}
