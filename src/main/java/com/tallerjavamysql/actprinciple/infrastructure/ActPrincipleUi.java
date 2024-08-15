package com.tallerjavamysql.actprinciple.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.actprinciple.application.CreateActPrincipleUseCase;
import com.tallerjavamysql.actprinciple.application.DeleteActPrincipleUseCase;
import com.tallerjavamysql.actprinciple.application.FindAllActPrincipleUseCase;
import com.tallerjavamysql.actprinciple.application.FindByIdActPrincipleUseCase;
import com.tallerjavamysql.actprinciple.application.UpdateActPrincipleUseCase;
import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;
import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class ActPrincipleUi {
    private ActPrincipleService actPrincipleService;

    private CreateActPrincipleUseCase createActPrincipleUseCase;
    private UpdateActPrincipleUseCase updateActPrincipleUseCase;
    private DeleteActPrincipleUseCase deleteActPrincipleUseCase;
    private FindAllActPrincipleUseCase findAllActPrincipleUseCase;
    private FindByIdActPrincipleUseCase findByIdActPrincipleUseCase;

    public ActPrincipleUi() {
        this.actPrincipleService = new ActPrincipleRepository();
        this.createActPrincipleUseCase = new CreateActPrincipleUseCase(actPrincipleService);
        this.updateActPrincipleUseCase = new UpdateActPrincipleUseCase(actPrincipleService);
        this.deleteActPrincipleUseCase = new DeleteActPrincipleUseCase(actPrincipleService);
        this.findAllActPrincipleUseCase = new FindAllActPrincipleUseCase(actPrincipleService);
        this.findByIdActPrincipleUseCase = new FindByIdActPrincipleUseCase(actPrincipleService);
    }

    public void menuActPrinciple() {
        String opts = "1. Add ActPrinciple\n2. Update ActPrinciple\n3. Delete ActPrinciple\n4. Search ActPrinciple\n5. Search ActPrinciples\n6. Return";
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
                    createActPrinciple();
                    break;
                case 2:
                    updateActPrinciple();
                    break;
                case 3:
                    deleteActPrinciple();
                    break;
                case 4:
                    findByIdActPrinciple();
                    break;
                case 5:
                    findAllActPrinciples();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createActPrinciple() {
        ActPrinciple actPrinciple = new ActPrinciple();
        actPrinciple.setNameap(JOptionPane.showInputDialog(null, "Ingrese el nombre del principio activo"));
        createActPrincipleUseCase.execute(actPrinciple);
    }

    public void showByIdActPrinciple(ActPrinciple actPrinciple) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                actPrinciple.getIdap(),
                actPrinciple.getNameap() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "ActPrinciple By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public ActPrinciple findByIdActPrinciple() {
        int id = 0;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID del principio activo"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
            return null;
        }
        ActPrinciple actPrinciple = findByIdActPrincipleUseCase.execute(id);
        showByIdActPrinciple(actPrinciple);
        return actPrinciple;
    }

    public void updateActPrinciple() {
        ActPrinciple actPrinciple = findByIdActPrinciple();
        actPrinciple.setNameap(JOptionPane.showInputDialog(null, "Ingrese el nombre del principio activo"));
        updateActPrincipleUseCase.execute(actPrinciple);
    }

    public void deleteActPrinciple() {
        ActPrinciple actPrinciple = findByIdActPrinciple();
        deleteActPrincipleUseCase.execute(actPrinciple.getIdap());
    }

    public void showAllActPrinciples(List<ActPrinciple> actPrinciples) {
        String[] columns = { "ID", "Nombre" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        actPrinciples.forEach(actPrinciple -> {
            Object[] row = {
                    actPrinciple.getIdap(),
                    actPrinciple.getNameap() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "ActPrinciples List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllActPrinciples() {
        List<ActPrinciple> actPrinciples = findAllActPrincipleUseCase.execute();
        showAllActPrinciples(actPrinciples);
    }
}
