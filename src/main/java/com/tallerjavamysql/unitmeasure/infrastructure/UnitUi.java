package com.tallerjavamysql.unitmeasure.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.unitmeasure.application.CreateUnitUseCase;
import com.tallerjavamysql.unitmeasure.application.DeleteUnitUseCase;
import com.tallerjavamysql.unitmeasure.application.FindAllUnitUseCase;
import com.tallerjavamysql.unitmeasure.application.FindByIdUnitUseCase;
import com.tallerjavamysql.unitmeasure.application.UpdateUnitUseCase;
import com.tallerjavamysql.unitmeasure.domain.entity.Unit;
import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class UnitUi {
    private UnitService unitService;

    private CreateUnitUseCase createUnitUseCase;
    private UpdateUnitUseCase updateUnitUseCase;
    private DeleteUnitUseCase deleteUnitUseCase;
    private FindAllUnitUseCase findAllUnitUseCase;
    private FindByIdUnitUseCase findByIdUnitUseCase;

    public UnitUi() {
        this.unitService = new UnitRepository();
        this.createUnitUseCase = new CreateUnitUseCase(unitService);
        this.updateUnitUseCase = new UpdateUnitUseCase(unitService);
        this.deleteUnitUseCase = new DeleteUnitUseCase(unitService);
        this.findAllUnitUseCase = new FindAllUnitUseCase(unitService);
        this.findByIdUnitUseCase = new FindByIdUnitUseCase(unitService);
    }

    public void menuUnit() {
        String opts = "1. Add Unit\n2. Update Unit\n3. Delete Unit\n4. Search Unit\n5. Search Units\n6. Return";
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, opts));
            switch (opt) {
                case 1:
                    createUnit();
                    break;
                case 2:
                    updateUnit();
                    break;
                case 3:
                    deleteUnit();
                    break;
                case 4:
                    findByIdUnit();
                    break;
                case 5:
                    findAllUnits();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createUnit() {
        Unit unit = new Unit();
        unit.setNameum(JOptionPane.showInputDialog(null, "Ingrese el nombre de la unidad de medida"));
        createUnitUseCase.execute(unit);
    }

    public void showByIdUnit(Unit unit) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                unit.getIdum(),
                unit.getNameum() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Unit By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Unit findByIdUnit() {
        int idum = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID de la unidad de medida"));
        Unit unit = findByIdUnitUseCase.execute(idum);
        showByIdUnit(unit);
        return unit;
    }

    public void updateUnit() {
        Unit unit = findByIdUnit();

        unit.setNameum(JOptionPane.showInputDialog(null, "Ingrese el nombre de la unidad de medida"));
        updateUnitUseCase.execute(unit);
    }

    public void deleteUnit() {
        Unit unit = findByIdUnit();
        deleteUnitUseCase.execute(unit.getIdum());
    }

    public void showAllUnits(List<Unit> units) {
        String[] columns = { "ID", "Nombre" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        units.forEach(unit -> {
            Object[] row = {
                    unit.getIdum(),
                    unit.getNameum() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Units List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllUnits() {
        List<Unit> units = findAllUnitUseCase.execute();
        showAllUnits(units);
    }

}
