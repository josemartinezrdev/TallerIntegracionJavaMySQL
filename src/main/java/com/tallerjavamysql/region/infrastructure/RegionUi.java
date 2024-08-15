package com.tallerjavamysql.region.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tallerjavamysql.region.application.CreateRegionUseCase;
import com.tallerjavamysql.region.application.DeleteRegionUseCase;
import com.tallerjavamysql.region.application.FindAllRegionUseCase;
import com.tallerjavamysql.region.application.FindByIdRegionUseCase;
import com.tallerjavamysql.region.application.UpdateRegionUseCase;
import com.tallerjavamysql.region.domain.entity.Region;
import com.tallerjavamysql.region.domain.service.RegionService;

public class RegionUi {
    private RegionService regionService;

    private CreateRegionUseCase createRegionUseCase;
    private UpdateRegionUseCase updateRegionUseCase;
    private DeleteRegionUseCase deleteRegionUseCase;
    private FindAllRegionUseCase findAllRegionUseCase;
    private FindByIdRegionUseCase findByIdRegionUseCase;

    public RegionUi() {
        this.regionService = new RegionRepository();
        this.createRegionUseCase = new CreateRegionUseCase(regionService);
        this.updateRegionUseCase = new UpdateRegionUseCase(regionService);
        this.deleteRegionUseCase = new DeleteRegionUseCase(regionService);
        this.findAllRegionUseCase = new FindAllRegionUseCase(regionService);
        this.findByIdRegionUseCase = new FindByIdRegionUseCase(regionService);
    }

    public void menuRegion() {
        String opts = "1. Add Region\n2. Update Region\n3. Delete Region\n4. Search Region\n5. Search Regiones\n6. Return";
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
                    createRegion();
                    break;
                case 2:
                    updateRegion();
                    break;
                case 3:
                    deleteRegion();
                    break;
                case 4:
                    findByIdRegion();
                    break;
                case 5:
                    findAllRegiones();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion elegida");
                    break;
            }
        } while (opt != 6);
    }

    public void createRegion() {
        Region region = new Region();
        region.setCodereg(JOptionPane.showInputDialog(null, "Ingrese el código de la region"));
        region.setNamereg(JOptionPane.showInputDialog(null, "Ingrese el nombre de la region"));
        region.setCodecountry(JOptionPane.showInputDialog(null, "Ingrese el código del país de la region"));
        createRegionUseCase.execute(region);
    }

    public void showByIdRegion(Region region) {
        String[] columns = { "Código", "Nombre", "Cod País" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                region.getCodereg(),
                region.getNamereg(),
                region.getCodecountry() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Region By Id", JOptionPane.PLAIN_MESSAGE);
    }

    public Object[] findByIdRegion() {
        String coderegion = JOptionPane.showInputDialog(null, "Ingresa el código de la region");
        Region region = findByIdRegionUseCase.execute(coderegion);
        showByIdRegion(region);
        return new Object[] { region, coderegion };
    }

    public void updateRegion() {
        Object[] result = findByIdRegion();
        Region region = (Region) result[0];
        String coderegion = (String) result[1];

        region.setCodereg(JOptionPane.showInputDialog(null, "Ingrese el código de la region"));
        region.setNamereg(JOptionPane.showInputDialog(null, "Ingrese el nombre de la region"));
        region.setCodecountry(JOptionPane.showInputDialog(null, "Ingrese el código del país de la region"));
        updateRegionUseCase.execute(region, coderegion);
    }

    public void deleteRegion() {
        Object[] result = findByIdRegion();
        Region region = (Region) result[0];
        deleteRegionUseCase.execute(region.getCodereg());
    }

    public void showAllRegiones(List<Region> regiones) {
        String[] columns = { "Código", "Nombre", "Cod País" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        regiones.forEach(region -> {
            Object[] row = {
                    region.getCodereg(),
                    region.getNamereg(),
                    region.getCodecountry() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Regiones List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllRegiones() {
        List<Region> regiones = findAllRegionUseCase.execute();
        showAllRegiones(regiones);
    }
}
