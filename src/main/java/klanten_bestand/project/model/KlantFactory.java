package klanten_bestand.project.model;

import java.io.PrintWriter;
import java.util.ArrayList;

public class KlantFactory {
    public static final int STANDAARD_GROOTTE = 100;
    private final String PLAATSEN_BESTAND = "src/main/resources/9.3 Plaatsnamenlijst.txt";
    private final String NAMEN_BESTAND = "src/main/resources/9.3 NamenlijstGroot.csv";
    private final String KLANTEN_BESTAND = "src/main/resources/Klanten.txt";

    public int lijstGrootte;
    public static ArrayList<String> namenLijst;
    public static ArrayList<String> plaatsenLijst;
    public static ArrayList<Klant> klantenLijst;
    PrintWriter printWriter;

    public KlantFactory() {
        this(STANDAARD_GROOTTE);
    }

    public KlantFactory(int lijstGrootte) {
    }

    public void maakKlantenBestand() {
    }
}
