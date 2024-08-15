package com.tallerjavamysql.modeadmin.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.modeadmin.application.CreateModeAdminUseCase;
import com.tallerjavamysql.modeadmin.application.DeleteModeAdminUseCase;
import com.tallerjavamysql.modeadmin.application.FindAllModeAdminUseCase;
import com.tallerjavamysql.modeadmin.application.FindByIdModeAdminUseCase;
import com.tallerjavamysql.modeadmin.application.UpdateModeAdminUseCase;
import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class ModeAdminUi {
    private ModeAdminService modeAdminService;

    private CreateModeAdminUseCase createModeAdminUseCase;
    private UpdateModeAdminUseCase updateModeAdminUseCase;
    private DeleteModeAdminUseCase deleteModeAdminUseCase;
    private FindAllModeAdminUseCase findAllModeAdminUseCase;
    private FindByIdModeAdminUseCase findByIdModeAdminUseCase;

    public ModeAdminUi() {
        this.modeAdminService = new ModeAdminRepository();
        this.createModeAdminUseCase = new CreateModeAdminUseCase(modeAdminService);
        this.updateModeAdminUseCase = new UpdateModeAdminUseCase(modeAdminService);
        this.deleteModeAdminUseCase = new DeleteModeAdminUseCase(modeAdminService);
        this.findAllModeAdminUseCase = new FindAllModeAdminUseCase(modeAdminService);
        this.findByIdModeAdminUseCase = new FindByIdModeAdminUseCase(modeAdminService);
    }

    public void menuModeAdmin() {
        String opts = "1. Add ModeAdmin\n2. Update ModeAdmin\n3. Delete ModeAdmin\n4. Search ModeAdmin\n5. Search ModesAdmin\n6. Return";
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
                    createModeAdmin();
                    break;
                case 2:
                    updateModeAdmin();
                    break;
                case 3:
                    deleteModeAdmin();
                    break;
                case 4:
                    findByIdModeAdmin();
                    break;
                case 5:
                    findAllModesAdmin();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createModeAdmin() {
        ModeAdmin modeAdmin = new ModeAdmin();
        modeAdmin.setDescriptionmode(
                JOptionPane.showInputDialog(null, "Ingrese la descripcion del modo de administracion"));
        createModeAdminUseCase.execute(modeAdmin);
    }

    public void showByIdModeAdmin(ModeAdmin modeAdmin) {
        String[] columns = { "ID", "Descripcion" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                modeAdmin.getId(),
                modeAdmin.getDescriptionmode() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "ModeAdmin By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public ModeAdmin findByIdModeAdmin() {
        int id = 0;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID del modo de administracion"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
            return null;
        }
        ModeAdmin modeAdmin = findByIdModeAdminUseCase.execute(id);
        showByIdModeAdmin(modeAdmin);
        return modeAdmin;
    }

    public void updateModeAdmin() {
        ModeAdmin modeAdmin = findByIdModeAdmin();
        modeAdmin.setDescriptionmode(
                JOptionPane.showInputDialog(null, "Ingrese la descripcion del modo de administracion"));
        updateModeAdminUseCase.execute(modeAdmin);
    }

    public void deleteModeAdmin() {
        ModeAdmin modeAdmin = findByIdModeAdmin();
        deleteModeAdminUseCase.execute(modeAdmin.getId());
    }

    public void showAllModesAdmin(List<ModeAdmin> modesAdmin) {
        String[] columns = { "ID", "Descripcion" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        modesAdmin.forEach(modeAdmin -> {
            Object[] row = {
                    modeAdmin.getId(),
                    modeAdmin.getDescriptionmode() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "ModesAdmin List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllModesAdmin() {
        List<ModeAdmin> modesAdmin = findAllModeAdminUseCase.execute();
        showAllModesAdmin(modesAdmin);
    }
}
