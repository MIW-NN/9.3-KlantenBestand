package klanten_bestand.project.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

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
        this.lijstGrootte = lijstGrootte;
        maakPlaatsenLijst();
        maakNamenLijst();
        maakKlantenLijst();
    }

    private void maakPlaatsenLijst() {
        Scanner namenLezer;
        plaatsenLijst = new ArrayList<>();
        try {
            File namenBestand = new File(PLAATSEN_BESTAND);
            namenLezer = new Scanner(namenBestand);
            while (namenLezer.hasNextLine()) {
                plaatsenLijst.add(namenLezer.nextLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("Het namenbestand is niet gevonden.");
        }
    }

    private void maakNamenLijst() {
        Scanner namenLezer;
        namenLijst = new ArrayList<>();
        try {
            File namenBestand = new File(NAMEN_BESTAND);
            namenLezer = new Scanner(namenBestand);
            while (namenLezer.hasNextLine()) {
                namenLijst.add(namenLezer.nextLine());
            }

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("Het namenbestand is niet gevonden.");
        }
    }

    private String kiesWillekeurigePlaats() {
        int willekeurigeIndex = (int) (plaatsenLijst.size() * Math.random());
        return plaatsenLijst.get(willekeurigeIndex);
    }

    private String kiesWillekeurigeNaam() {
        int willekeurigeIndex = (int) (namenLijst.size() * Math.random());
        return namenLijst.get(willekeurigeIndex);
    }

    private void maakKlantenLijst() {
        klantenLijst = new ArrayList<>();
        for (int i = 0; i < lijstGrootte; i++) {
            String[] naamSplit = kiesWillekeurigeNaam().split(",");
            String tussenvoegsel = naamSplit[0];
            String achternaam = naamSplit[1];
            Klant nieuweKlant = new Klant(tussenvoegsel, achternaam, kiesWillekeurigePlaats());
            klantenLijst.add(nieuweKlant);
        }
    }

    public void maakKlantenBestand() {
        try {

            File customersFile = new File(KLANTEN_BESTAND);
            printWriter = new PrintWriter(customersFile);
            for (int i = 0; i < lijstGrootte; i++) {
                String naam = klantenLijst.get(i).getTussenvoegsel();
                if (naam.equals("")) {
                    naam = klantenLijst.get(i).getAchternaam();
                } else {
                    naam = naam + " " + klantenLijst.get(i).getAchternaam();
                }
                printWriter.printf("%6d %-20s %s\n", i+1,
                        naam, klantenLijst.get(i).getWoonplaats());
            }
            printWriter.close();
        } catch (Exception error) {
            error.getMessage();
        } finally {
            printWriter.close();
        }
    }
}
