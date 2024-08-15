package com.tallerjavamysql.farmacy.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.farmacy.application.CreateFarmacyUseCase;
import com.tallerjavamysql.farmacy.application.DeleteFarmacyUseCase;
import com.tallerjavamysql.farmacy.application.FindAllFarmacyUseCase;
import com.tallerjavamysql.farmacy.application.FindByIdFarmacyUseCase;
import com.tallerjavamysql.farmacy.application.UpdateFarmacyUseCase;
import com.tallerjavamysql.farmacy.domain.entity.Farmacy;
import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class FarmacyUi {
    private FarmacyService farmacyService;

    private CreateFarmacyUseCase createFarmacyUseCase;
    private UpdateFarmacyUseCase updateFarmacyUseCase;
    private DeleteFarmacyUseCase deleteFarmacyUseCase;
    private FindAllFarmacyUseCase findAllFarmacyUseCase;
    private FindByIdFarmacyUseCase findByIdFarmacyUseCase;

    public FarmacyUi() {
        this.farmacyService = new FarmacyRepository();
        this.createFarmacyUseCase = new CreateFarmacyUseCase(farmacyService);
        this.updateFarmacyUseCase = new UpdateFarmacyUseCase(farmacyService);
        this.deleteFarmacyUseCase = new DeleteFarmacyUseCase(farmacyService);
        this.findAllFarmacyUseCase = new FindAllFarmacyUseCase(farmacyService);
        this.findByIdFarmacyUseCase = new FindByIdFarmacyUseCase(farmacyService);
    }

    public void menuFarmacy() {
        String opts = "1. Add Farmacy\n2. Update Farmacy\n3. Delete Farmacy\n4. Search Farmacy\n5. Search pharmacies\n6. Return";
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            switch (opt) {
                case 1:
                    createFarmacy();
                    break;
                case 2:
                    updateFarmacy();
                    break;
                case 3:
                    deleteFarmacy();
                    break;
                case 4:
                    findByIdFarmacy();
                    break;
                case 5:
                    findAllpharmacies();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createFarmacy() {
        Farmacy farmacy = new Farmacy();
        farmacy.setNamefarmacy(JOptionPane.showInputDialog(null, "Ingrese el nombre de la farmacia"));
        farmacy.setAddresfarmacy(JOptionPane.showInputDialog(null, "Ingrese la direccion de la farmacia"));
        farmacy.setLongitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la longitud de la farmacia")));
        farmacy.setLatitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la latitud de la farmacia")));
        farmacy.setLogofarmacy(JOptionPane.showInputDialog(null, "Ingrese el logo de la farmacia"));
        farmacy.setCodecityfarmacy(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ciudad de la farmacia"));
        createFarmacyUseCase.execute(farmacy);
    }

    public void showByIdFarmacy(Farmacy farmacy) {
        String[] columns = { "ID", "Nombre", "Direccion", "Longitud", "Latitud", "Logo", "Ciudad" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                farmacy.getIdfarmacy(),
                farmacy.getNamefarmacy(),
                farmacy.getAddresfarmacy(),
                farmacy.getLongitud(),
                farmacy.getLatitud(),
                farmacy.getLogofarmacy(),
                farmacy.getCodecityfarmacy() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Farmacy By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Farmacy findByIdFarmacy() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID de la farmacia"));
        Farmacy farmacy = findByIdFarmacyUseCase.execute(id);
        showByIdFarmacy(farmacy);
        return farmacy;
    }

    public void updateFarmacy() {
        Farmacy farmacy = findByIdFarmacy();
        farmacy.setNamefarmacy(JOptionPane.showInputDialog(null, "Ingrese el nombre de la farmacia"));
        farmacy.setAddresfarmacy(JOptionPane.showInputDialog(null, "Ingrese la direccion de la farmacia"));
        farmacy.setLongitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la longitud de la farmacia")));
        farmacy.setLatitud(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la latitud de la farmacia")));
        farmacy.setLogofarmacy(JOptionPane.showInputDialog(null, "Ingrese el logo de la farmacia"));
        farmacy.setCodecityfarmacy(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ciudad de la farmacia"));

        updateFarmacyUseCase.execute(farmacy);
    }

    public void deleteFarmacy() {
        Farmacy farmacy = findByIdFarmacy();
        deleteFarmacyUseCase.execute(farmacy.getIdfarmacy());
    }

    public void showAllPharmacies(List<Farmacy> pharmacies) {
        String[] columns = { "ID", "Nombre", "Direccion", "Longitud", "Latitud", "Logo", "Ciudad" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        pharmacies.forEach(farmacy -> {
            Object[] row = {
                    farmacy.getIdfarmacy(),
                    farmacy.getNamefarmacy(),
                    farmacy.getAddresfarmacy(),
                    farmacy.getLongitud(),
                    farmacy.getLatitud(),
                    farmacy.getLogofarmacy(),
                    farmacy.getCodecityfarmacy() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Pharmacies List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllpharmacies() {
        List<Farmacy> pharmacies = findAllFarmacyUseCase.execute();
        showAllPharmacies(pharmacies);
    }
}
