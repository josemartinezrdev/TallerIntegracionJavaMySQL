package com.tallerjavamysql.country.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.country.application.CreateCountryUseCase;
import com.tallerjavamysql.country.application.DeleteCountryUseCase;
import com.tallerjavamysql.country.application.FindAllCountryUseCase;
import com.tallerjavamysql.country.application.FindByIdCountryUseCase;
import com.tallerjavamysql.country.application.UpdateCountryUseCase;
import com.tallerjavamysql.country.domain.entity.Country;
import com.tallerjavamysql.country.domain.service.CountryService;

public class CountryUi {

    private CountryService countryService;

    private CreateCountryUseCase createCountryUseCase;
    private UpdateCountryUseCase updateCountryUseCase;
    private DeleteCountryUseCase deleteCountryUseCase;
    private FindAllCountryUseCase findAllCountryUseCase;
    private FindByIdCountryUseCase findByIdCountryUseCase;

    public CountryUi() {
        this.countryService = new CountryRepository();
        this.createCountryUseCase = new CreateCountryUseCase(countryService);
        this.updateCountryUseCase = new UpdateCountryUseCase(countryService);
        this.deleteCountryUseCase = new DeleteCountryUseCase(countryService);
        this.findAllCountryUseCase = new FindAllCountryUseCase(countryService);
        this.findByIdCountryUseCase = new FindByIdCountryUseCase(countryService);
    }

    public void menuCountry() {
        String opts = "1. Add Country\n2. Update Country\n3. Delete Country\n4. Search Country\n5. Search Countries\n6. Return";
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            switch (opt) {
                case 1:
                    createCountry();
                    break;
                case 2:
                    updateCountry();
                    break;
                case 3:
                    deleteCountry();
                    break;
                case 4:
                    findByIdCountry();
                    break;
                case 5:
                    findAllCountries();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createCountry() {
        Country country = new Country();
        country.setCodecountry(JOptionPane.showInputDialog(null, "Ingrese el código del país"));
        country.setNamecountry(JOptionPane.showInputDialog(null, "Ingrese el nombre del país"));
        createCountryUseCase.execute(country);
    }

    public void showByIdCountry(Country country) {
        String[] columns = { "Código", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                country.getCodecountry(),
                country.getNamecountry() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Country By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Object[] findByIdCountry() {
        String codecountry = JOptionPane.showInputDialog(null, "Ingresa el código del país");
        Country country = findByIdCountryUseCase.execute(codecountry);
        showByIdCountry(country);
        return new Object[] { country, codecountry };
    }

    public void updateCountry() {
        Object[] result = findByIdCountry();
        Country country = (Country) result[0];
        String codecountry = (String) result[1];

        country.setCodecountry(JOptionPane.showInputDialog(null, "Ingrese el código del país"));
        country.setNamecountry(JOptionPane.showInputDialog(null, "Ingrese el nombre del país"));
        updateCountryUseCase.execute(country, codecountry);
    }

    public void deleteCountry() {
        Object[] result = findByIdCountry();
        Country country = (Country) result[0];
        deleteCountryUseCase.execute(country.getCodecountry());
    }

    public void showAllCountries(List<Country> countries) {
        String[] columns = { "Código", "Nombre" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        countries.forEach(country -> {
            Object[] row = {
                    country.getCodecountry(),
                    country.getNamecountry() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Countries List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllCountries() {
        List<Country> countries = findAllCountryUseCase.execute();
        showAllCountries(countries);
    }
}
