package com.tallerjavamysql.laboratory.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.laboratory.application.CreateLaboratoryUseCase;
import com.tallerjavamysql.laboratory.application.DeleteLaboratoryUseCase;
import com.tallerjavamysql.laboratory.application.FindAllLaboratoryUseCase;
import com.tallerjavamysql.laboratory.application.FindByIdLaboratoryUseCase;
import com.tallerjavamysql.laboratory.application.UpdateLaboratoryUseCase;
import com.tallerjavamysql.laboratory.domain.entity.Laboratory;
import com.tallerjavamysql.laboratory.domain.service.LaboratoryService;

public class LaboratoryUi {
    private LaboratoryService laboratoryService;

    private CreateLaboratoryUseCase createLaboratoryUseCase;
    private UpdateLaboratoryUseCase updateLaboratoryUseCase;
    private DeleteLaboratoryUseCase deleteLaboratoryUseCase;
    private FindAllLaboratoryUseCase findAllLaboratoryUseCase;
    private FindByIdLaboratoryUseCase findByIdLaboratoryUseCase;

    public LaboratoryUi() {
        this.laboratoryService = new LaboratoryRepository();
        this.createLaboratoryUseCase = new CreateLaboratoryUseCase(laboratoryService);
        this.updateLaboratoryUseCase = new UpdateLaboratoryUseCase(laboratoryService);
        this.deleteLaboratoryUseCase = new DeleteLaboratoryUseCase(laboratoryService);
        this.findAllLaboratoryUseCase = new FindAllLaboratoryUseCase(laboratoryService);
        this.findByIdLaboratoryUseCase = new FindByIdLaboratoryUseCase(laboratoryService);
    }

    public void menuLaboratory() {
        String opts = "1. Add Laboratory\n2. Update Laboratory\n3. Delete Laboratory\n4. Search Laboratory\n5. Search laboratories\n6. Return";
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            switch (opt) {
                case 1:
                    createLaboratory();
                    break;
                case 2:
                    updateLaboratory();
                    break;
                case 3:
                    deleteLaboratory();
                    break;
                case 4:
                    findByIdLaboratory();
                    break;
                case 5:
                    findAlllaboratories();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createLaboratory() {
        Laboratory laboratory = new Laboratory();
        laboratory.setNamelab(JOptionPane.showInputDialog(null, "Ingrese el nombre del laboratorio"));
        laboratory.setCodecityreg(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ciudad del laboratorio"));
        createLaboratoryUseCase.execute(laboratory);
    }

    public void showByIdLaboratory(Laboratory laboratory) {
        String[] columns = { "ID", "Nombre", "ID City" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                laboratory.getId(),
                laboratory.getNamelab(),
                laboratory.getCodecityreg() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Laboratory By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Laboratory findByIdLaboratory() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID del laboratorio"));
        Laboratory laboratory = findByIdLaboratoryUseCase.execute(id);
        showByIdLaboratory(laboratory);
        return laboratory;
    }

    public void updateLaboratory() {
        Laboratory laboratory = findByIdLaboratory();
        laboratory.setNamelab(JOptionPane.showInputDialog(null, "Ingrese el nombre del laboratorio"));
        laboratory.setCodecityreg(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ciudad del laboratorio"));
        updateLaboratoryUseCase.execute(laboratory);
    }

    public void deleteLaboratory() {
        Laboratory laboratory = findByIdLaboratory();
        deleteLaboratoryUseCase.execute(laboratory.getId());
    }

    public void showAllLaboratories(List<Laboratory> laboratories) {
        String[] columns = { "ID", "Descripcion", "ID City" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        laboratories.forEach(laboratory -> {
            Object[] row = {
                    laboratory.getId(),
                    laboratory.getNamelab(),
                    laboratory.getCodecityreg() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Laboratories List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAlllaboratories() {
        List<Laboratory> laboratories = findAllLaboratoryUseCase.execute();
        showAllLaboratories(laboratories);
    }
}
