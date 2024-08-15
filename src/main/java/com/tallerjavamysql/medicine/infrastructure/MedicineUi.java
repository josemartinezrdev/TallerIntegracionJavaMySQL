package com.tallerjavamysql.medicine.infrastructure;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.medicine.domain.entity.Medicine;
import com.tallerjavamysql.medicine.application.CreateMedicineUseCase;
import com.tallerjavamysql.medicine.application.DeleteMedicineUseCase;
import com.tallerjavamysql.medicine.application.FindAllMedicineUseCase;
import com.tallerjavamysql.medicine.application.FindByIdMedicineUseCase;
import com.tallerjavamysql.medicine.application.UpdateMedicineUseCase;
import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class MedicineUi {

    private MedicineService medicineService;

    private CreateMedicineUseCase createMedicineUseCase;
    private UpdateMedicineUseCase updateMedicineUseCase;
    private DeleteMedicineUseCase deleteMedicineUseCase;
    private FindAllMedicineUseCase findAllMedicineUseCase;
    private FindByIdMedicineUseCase findByIdMedicineUseCase;

    public MedicineUi() {
        this.medicineService = new MedicineRepository();
        this.createMedicineUseCase = new CreateMedicineUseCase(medicineService);
        this.updateMedicineUseCase = new UpdateMedicineUseCase(medicineService);
        this.deleteMedicineUseCase = new DeleteMedicineUseCase(medicineService);
        this.findAllMedicineUseCase = new FindAllMedicineUseCase(medicineService);
        this.findByIdMedicineUseCase = new FindByIdMedicineUseCase(medicineService);
    }

    public void menuMedicine() {
        String opts = "1. Add Medicine\n2. Update Medicine\n3. Delete Medicine\n4. Search Medicine\n5. Search Medicinees\n6. Return";
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
                    createMedicine();
                    break;
                case 2:
                    updateMedicine();
                    break;
                case 3:
                    deleteMedicine();
                    break;
                case 4:
                    findByIdMedicine();
                    break;
                case 5:
                    findAllMedicinees();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createMedicine() {
        Medicine medicine = new Medicine();
        medicine.setProceedings(JOptionPane.showInputDialog(null, "Ingrese el procedimiento"));
        medicine.setNamemedicine(JOptionPane.showInputDialog(null, "Ingrese el nombre de la medicina"));
        medicine.setHealthregister(JOptionPane.showInputDialog(null, "Ingrese el registro de salud"));
        medicine.setDescription(JOptionPane.showInputDialog(null, "Ingrese la descripcion"));
        medicine.setDescriptionshort(JOptionPane.showInputDialog(null, "Ingrese la descripcion corta"));
        medicine.setNamerol(JOptionPane.showInputDialog(null, "Ingrese el nombre del rol"));

        try {
            medicine.setCodemodeadmin(
                    Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Ingrese el codigo de la via de administracion")));
            medicine.setCodeap(
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del principio activo")));
            medicine.setIdum(
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de la unidad de medida")));
            medicine.setCodelab(
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del laboratorio")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
            return;
        }

        createMedicineUseCase.execute(medicine);
    }

    public void showByIdMedicine(Medicine medicine) {
        String[] columns = { "ID", "Procedimientos", "Nombre", "Registro Salud", "Desc", "Desc Short", "Name Rol",
                "Modo Admin", "Principio Act", "Unidad Medida", "Laboratorio" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                medicine.getId(),
                medicine.getProceedings(),
                medicine.getNamemedicine(),
                medicine.getHealthregister(),
                medicine.getDescription(),
                medicine.getDescriptionshort(),
                medicine.getNamerol(),
                medicine.getCodemodeadmin(),
                medicine.getCodeap(),
                medicine.getIdum(),
                medicine.getCodelab() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        JOptionPane.showMessageDialog(null, panel, "Medicine By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Medicine findByIdMedicine() {
        int id = 0;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID de la medicina"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
            return null;
        }
        Medicine medicine = findByIdMedicineUseCase.execute(id);
        showByIdMedicine(medicine);
        return medicine;
    }

    public void updateMedicine() {
        Medicine medicine = findByIdMedicine();
        medicine.setProceedings(JOptionPane.showInputDialog(null, "Ingrese el procedimiento"));
        medicine.setNamemedicine(JOptionPane.showInputDialog(null, "Ingrese el nombre de la medicina"));
        medicine.setHealthregister(JOptionPane.showInputDialog(null, "Ingrese el registro de salud"));
        medicine.setDescription(JOptionPane.showInputDialog(null, "Ingrese la descripcion"));
        medicine.setDescriptionshort(JOptionPane.showInputDialog(null, "Ingrese la descripcion corta"));
        medicine.setNamerol(JOptionPane.showInputDialog(null, "Ingrese el nombre del rol"));

        try {
            medicine.setCodemodeadmin(
                    Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Ingrese el codigo de la via de administracion")));
            medicine.setCodeap(
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del principio activo")));
            medicine.setIdum(
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de la unidad de medida")));
            medicine.setCodelab(
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del laboratorio")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
            return;
        }

        updateMedicineUseCase.execute(medicine);
    }

    public void deleteMedicine() {
        Medicine medicine = findByIdMedicine();
        deleteMedicineUseCase.execute(medicine.getId());
    }

    public void showAllMedicines(List<Medicine> medicines) {
        String[] columns = { "ID", "Procedimientos", "Nombre", "Registro Salud", "Desc", "Desc Short", "Name Rol",
                "Modo Admin", "Principio Act", "Unidad Medida", "Laboratorio" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        medicines.forEach(medicine -> {
            Object[] row = {
                    medicine.getId(),
                    medicine.getProceedings(),
                    medicine.getNamemedicine(),
                    medicine.getHealthregister(),
                    medicine.getDescription(),
                    medicine.getDescriptionshort(),
                    medicine.getNamerol(),
                    medicine.getCodemodeadmin(),
                    medicine.getCodeap(),
                    medicine.getIdum(),
                    medicine.getCodelab() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        JOptionPane.showMessageDialog(null, panel, "Medicines List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllMedicinees() {
        List<Medicine> medicines = findAllMedicineUseCase.execute();
        showAllMedicines(medicines);
    }

}
