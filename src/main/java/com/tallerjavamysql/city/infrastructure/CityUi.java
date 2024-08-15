package com.tallerjavamysql.city.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.city.application.CreateCityUseCase;
import com.tallerjavamysql.city.application.DeleteCityUseCase;
import com.tallerjavamysql.city.application.FindAllCityUseCase;
import com.tallerjavamysql.city.application.FindByIdCityUseCase;
import com.tallerjavamysql.city.application.UpdateCityUseCase;
import com.tallerjavamysql.city.domain.entity.City;
import com.tallerjavamysql.city.domain.service.CityService;

public class CityUi {
    private CityService cityService;

    private CreateCityUseCase createCityUseCase;
    private UpdateCityUseCase updateCityUseCase;
    private DeleteCityUseCase deleteCityUseCase;
    private FindAllCityUseCase findAllCityUseCase;
    private FindByIdCityUseCase findByIdCityUseCase;

    public CityUi() {
        this.cityService = new CityRepository();
        this.createCityUseCase = new CreateCityUseCase(cityService);
        this.updateCityUseCase = new UpdateCityUseCase(cityService);
        this.deleteCityUseCase = new DeleteCityUseCase(cityService);
        this.findAllCityUseCase = new FindAllCityUseCase(cityService);
        this.findByIdCityUseCase = new FindByIdCityUseCase(cityService);
    }

    public void menuCity() {
        String opts = "1. Add City\n2. Update City\n3. Delete City\n4. Search City\n5. Search Cities\n6. Return";
        int opt = 0;
        do {
            try {
                opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
                continue;
            }
            switch (opt) {
                case 1:
                    createCity();
                    break;
                case 2:
                    updateCity();
                    break;
                case 3:
                    deleteCity();
                    break;
                case 4:
                    findByIdCity();
                    break;
                case 5:
                    findAllCities();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createCity() {
        City city = new City();
        city.setCodecity(JOptionPane.showInputDialog(null, "Ingrese el código de la city"));
        city.setNamecity(JOptionPane.showInputDialog(null, "Ingrese el nombre de la city"));
        city.setCodereg(JOptionPane.showInputDialog(null, "Ingrese el código de la region de la city"));
        createCityUseCase.execute(city);
    }

    public void showByIdCity(City city) {
        String[] columns = { "Código", "Nombre", "Cod Region" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                city.getCodecity(),
                city.getNamecity(),
                city.getCodereg() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "City By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Object[] findByIdCity() {
        String codecity = JOptionPane.showInputDialog(null, "Ingresa el código de la city");
        City city = findByIdCityUseCase.execute(codecity);
        showByIdCity(city);
        return new Object[] { city, codecity };
    }

    public void updateCity() {
        Object[] result = findByIdCity();
        City city = (City) result[0];
        String codecity = (String) result[1];

        city.setCodecity(JOptionPane.showInputDialog(null, "Ingrese el código de la city"));
        city.setNamecity(JOptionPane.showInputDialog(null, "Ingrese el nombre de la city"));
        city.setCodereg(JOptionPane.showInputDialog(null, "Ingrese el código de la region de la city"));
        updateCityUseCase.execute(city, codecity);
    }

    public void deleteCity() {
        Object[] result = findByIdCity();
        City city = (City) result[0];
        deleteCityUseCase.execute(city.getCodecity());
    }

    public void showAllCities(List<City> cities) {
        String[] columns = { "Código", "Nombre", "Cod Region" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        cities.forEach(city -> {
            Object[] row = {
                    city.getCodecity(),
                    city.getNamecity(),
                    city.getCodereg() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllCities() {
        List<City> cities = findAllCityUseCase.execute();
        showAllCities(cities);
    }
}
