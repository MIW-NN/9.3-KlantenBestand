package klanten_bestand.project.controller;

import klanten_bestand.project.model.KlantFactory;

public class KlantenbestandLauncher {

    public static void main(String[] args) {
        KlantFactory klantFactory = new KlantFactory(75);
        klantFactory.maakKlantenBestand();
    }
}
