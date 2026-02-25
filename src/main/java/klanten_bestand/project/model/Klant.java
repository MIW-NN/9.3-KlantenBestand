package klanten_bestand.project.model;

public class Klant {

    int klantId;
    String tussenvoegsel;
    String achternaam;
    String woonplaats;
    static int aantalKlanten = 0;

    public Klant(String tussenvoegsel, String achternaam, String woonplaats) {
        this.klantId = aantalKlanten++;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.woonplaats = woonplaats;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    @Override
    public String toString() {
        return String.format("Klant : {%d, %s, %s, %s}", klantId, tussenvoegsel, achternaam, woonplaats);
    }
}
