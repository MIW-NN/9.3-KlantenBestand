package klanten_bestand.project.controller;

import klanten_bestand.project.model.CustomerFactory;

public class KlantenBestandLauncher {

    public static void main(String[] args) {
        CustomerFactory customerFactory = new CustomerFactory(75);
        customerFactory.createCustomerFile();
    }
}
