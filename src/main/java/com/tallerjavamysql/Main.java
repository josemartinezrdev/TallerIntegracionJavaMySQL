package com.tallerjavamysql;

import javax.swing.JOptionPane;

import com.tallerjavamysql.city.infrastructure.CityUi;
import com.tallerjavamysql.country.infrastructure.CountryUi;
import com.tallerjavamysql.customer.infrastructure.CustomerUi;
import com.tallerjavamysql.region.infrastructure.RegionUi;

public class Main {

    public static void main(String[] args) {
        CountryUi countryUi = new CountryUi();
        RegionUi regionUi = new RegionUi();
        CityUi cityUi = new CityUi();
        CustomerUi customerUi = new CustomerUi();

        String opts = "1. Country\n2. Region\n3. City\n4. Customer\n5. Mode Admin\n12. Quit";
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));

            switch (opt) {
                case 1:
                    countryUi.menuCountry();
                    break;
                case 2:
                    regionUi.menuRegion();
                    break;
                case 3:
                    cityUi.menuCity();
                    break;
                case 4:
                    customerUi.menuCustomer();
                    break;
                case 12:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 12);
    }
}