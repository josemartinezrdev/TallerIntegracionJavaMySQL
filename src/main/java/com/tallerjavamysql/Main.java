package com.tallerjavamysql;

import javax.swing.JOptionPane;

import com.tallerjavamysql.actprinciple.infrastructure.ActPrincipleUi;
import com.tallerjavamysql.city.infrastructure.CityUi;
import com.tallerjavamysql.country.infrastructure.CountryUi;
import com.tallerjavamysql.customer.infrastructure.CustomerUi;
import com.tallerjavamysql.farmacy.infrastructure.FarmacyUi;
import com.tallerjavamysql.farmamedicine.infrastructure.FarmaMedicineUi;
import com.tallerjavamysql.laboratory.infrastructure.LaboratoryUi;
import com.tallerjavamysql.medicine.infrastructure.MedicineUi;
import com.tallerjavamysql.modeadmin.infrastructure.ModeAdminUi;
import com.tallerjavamysql.region.infrastructure.RegionUi;
import com.tallerjavamysql.unitmeasure.infrastructure.UnitUi;

public class Main {

    public static void main(String[] args) {
        CountryUi countryUi = new CountryUi();
        RegionUi regionUi = new RegionUi();
        CityUi cityUi = new CityUi();
        CustomerUi customerUi = new CustomerUi();
        ModeAdminUi modeAdminUi = new ModeAdminUi();
        LaboratoryUi laboratoryUi = new LaboratoryUi();
        ActPrincipleUi actPrincipleUi = new ActPrincipleUi();
        UnitUi unitUi = new UnitUi();
        MedicineUi medicineUi = new MedicineUi();
        FarmacyUi farmacyUi = new FarmacyUi();
        FarmaMedicineUi farmaMedicineUi = new FarmaMedicineUi();

        String opts = "1. Country\n2. Region\n3. City\n4. Customer\n5. Mode Admin\n6. Laboratory\n7. Act Principle\n8. Unit Measure\n9. Medicine\n10. Farmacy\n11. Far - Med\n12. Quit";
        int opt = 0;
        do {
            try {
                opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al ingresar la opcion");
                continue;
            }

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
                case 5:
                    modeAdminUi.menuModeAdmin();
                    break;
                case 6:
                    laboratoryUi.menuLaboratory();
                    break;
                case 7:
                    actPrincipleUi.menuActPrinciple();
                    break;
                case 8:
                    unitUi.menuUnit();
                    break;
                case 9:
                    medicineUi.menuMedicine();
                    break;
                case 10:
                    farmacyUi.menuFarmacy();
                    break;
                case 11:
                    farmaMedicineUi.menuFarmaMedicine();
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