package com.tallerjavamysql.farmamedicine.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;
import com.tallerjavamysql.farmamedicine.application.CreateFarmaMedicineUseCase;
import com.tallerjavamysql.farmamedicine.application.DeleteFarmaMedicineUseCase;
import com.tallerjavamysql.farmamedicine.application.FindAllFarmaMedicineUseCase;
import com.tallerjavamysql.farmamedicine.application.FindByIdFarmaMedicineUseCase;
import com.tallerjavamysql.farmamedicine.application.UpdateFarmaMedicineUseCase;
import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class FarmaMedicineUi {

    private FarmaMedicineService farmaMedicineService;

    private CreateFarmaMedicineUseCase createFarmaMedicineUseCase;
    private DeleteFarmaMedicineUseCase deleteFarmaMedicineUseCase;
    private FindAllFarmaMedicineUseCase findAllFarmaMedicineUseCase;
    private FindByIdFarmaMedicineUseCase findByIdFarmaMedicineUseCase;
    private UpdateFarmaMedicineUseCase updateFarmaMedicineUseCase;

    public FarmaMedicineUi() {
        this.farmaMedicineService = new FarmaMedicineRepository();
        this.createFarmaMedicineUseCase = new CreateFarmaMedicineUseCase(farmaMedicineService);
        this.deleteFarmaMedicineUseCase = new DeleteFarmaMedicineUseCase(farmaMedicineService);
        this.findAllFarmaMedicineUseCase = new FindAllFarmaMedicineUseCase(farmaMedicineService);
        this.findByIdFarmaMedicineUseCase = new FindByIdFarmaMedicineUseCase(farmaMedicineService);
        this.updateFarmaMedicineUseCase = new UpdateFarmaMedicineUseCase(farmaMedicineService);
    }

    public void menuFarmaMedicine() {
        String opts = "1. Add FarmaMedicine\n2. Update FarmaMedicine\n3. Delete FarmaMedicine\n4. Search FarmaMedicine\n5. Search FarmaMedicinees\n6. Return";
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            switch (opt) {
                case 1:
                    createFarmaMedicine();
                    break;
                case 2:
                    updateFarmaMedicine();
                    break;
                case 3:
                    deleteFarmaMedicine();
                    break;
                case 4:
                    findByIdFarmaMedicine();
                    break;
                case 5:
                    findAllFarmaMedicines();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createFarmaMedicine() {
        FarmaMedicine farmaMedicine = new FarmaMedicine();
        farmaMedicine.setIdfarmacy(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la farmacia")));
        farmaMedicine
                .setIdmedicine(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la medicina")));
        farmaMedicine
                .setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio de la compra")));
        createFarmaMedicineUseCase.execute(farmaMedicine);
    }

    public void showByIdFarmaMedicine(FarmaMedicine farmamedicine) {
        String[] columns = { "ID Farmacy", "ID Medicine", "Price" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                farmamedicine.getIdfarmacy(),
                farmamedicine.getIdmedicine(),
                farmamedicine.getPrice() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "FarmaMedicine By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Object[] findByIdFarmaMedicine() {
        int idfarmacy = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la farmacia"));
        int idmedicine = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la medicina"));
        FarmaMedicine farmamedicine = findByIdFarmaMedicineUseCase.execute(idfarmacy, idmedicine);
        showByIdFarmaMedicine(farmamedicine);
        return new Object[] { farmamedicine, idfarmacy, idmedicine };
    }

    public void deleteFarmaMedicine() {
        Object[] result = findByIdFarmaMedicine();
        int idfarmacy = (int) result[1];
        int idmedicine = (int) result[2];
        deleteFarmaMedicineUseCase.execute(idfarmacy, idmedicine);
    }

    public void updateFarmaMedicine() {
        Object[] result = findByIdFarmaMedicine();
        FarmaMedicine farmaMedicine = (FarmaMedicine) result[0];
        int idfarmacy = (int) result[1];
        int idmedicine = (int) result[2];

        farmaMedicine.setIdfarmacy(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la farmacia")));
        farmaMedicine
                .setIdmedicine(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la medicina")));
        farmaMedicine
                .setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio de la compra")));

        updateFarmaMedicineUseCase.execute(farmaMedicine, idfarmacy, idmedicine);
    }

    public void showAllFarmaMedicines(List<FarmaMedicine> farmamedicines) {
        String[] columns = { "ID Farmacy", "ID Medicine", "Price" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        farmamedicines.forEach(farmamedicine -> {
            Object[] row = {
                    farmamedicine.getIdfarmacy(),
                    farmamedicine.getIdmedicine(),
                    farmamedicine.getPrice() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "FarmaMedicines List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllFarmaMedicines() {
        List<FarmaMedicine> farmaMedicines = findAllFarmaMedicineUseCase.execute();
        showAllFarmaMedicines(farmaMedicines);
    }

}
