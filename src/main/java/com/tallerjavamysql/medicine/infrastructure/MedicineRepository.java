package com.tallerjavamysql.medicine.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.medicine.domain.entity.Medicine;
import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class MedicineRepository implements MedicineService {

    private Connection connection;

    public MedicineRepository() {

        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createMedicine(Medicine medicine) {
        try {
            String query = """
                    INSERT INTO medicine (
                    proceedings, namemedicine, healthregister, description, descriptionshort,
                    namerol, codemodeadmin, codeap, idum, codelab
                    ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, medicine.getProceedings());
            ps.setString(2, medicine.getNamemedicine());
            ps.setString(3, medicine.getHealthregister());
            ps.setString(4, medicine.getDescription());
            ps.setString(5, medicine.getDescriptionshort());
            ps.setString(6, medicine.getNamerol());
            ps.setInt(7, medicine.getCodemodeadmin());
            ps.setInt(8, medicine.getCodeap());
            ps.setInt(9, medicine.getIdum());
            ps.setInt(10, medicine.getCodelab());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        try {
            String query = """
                    UPDATE medicine SET proceedings = ?, namemedicine = ?, healthregister = ?,
                    description = ?, descriptionshort = ?, namerol = ?, codemodeadmin = ?,
                    codeap = ?, idum = ?, codelab = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, medicine.getId());
            ps.setString(2, medicine.getProceedings());
            ps.setString(3, medicine.getNamemedicine());
            ps.setString(4, medicine.getHealthregister());
            ps.setString(5, medicine.getDescription());
            ps.setString(6, medicine.getDescriptionshort());
            ps.setString(7, medicine.getNamerol());
            ps.setInt(8, medicine.getCodemodeadmin());
            ps.setInt(9, medicine.getCodeap());
            ps.setInt(10, medicine.getIdum());
            ps.setInt(11, medicine.getCodelab());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        try {
            String query = "DELETE FROM medicine WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicine> findAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        try {
            String query = """
                    SELECT id, proceedings, namemedicine, healthregister, description, descriptionshort,
                    namerol, codemodeadmin, codeap, idum, codelab FROM medicine
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Medicine medicine = new Medicine(
                        rs.getInt("id"),
                        rs.getString("proceedings"),
                        rs.getString("namemedicine"),
                        rs.getString("healthregister"),
                        rs.getString("description"),
                        rs.getString("descriptionshort"),
                        rs.getString("namerol"),
                        rs.getInt("codemodeadmin"),
                        rs.getInt("codeap"),
                        rs.getInt("idum"),
                        rs.getInt("codelab"));
                medicines.add(medicine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public Medicine findByIdMedicine(int id) {
        Medicine medicine = new Medicine();
        try {
            String query = """
                    SELECT id, proceedings, namemedicine, healthregister, description, descriptionshort,
                    namerol, codemodeadmin, codeap, idum, codelab FROM medicine WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                medicine.setId(rs.getInt("id"));
                medicine.setProceedings(rs.getString("proceedings"));
                medicine.setNamemedicine(rs.getString("namemedicine"));
                medicine.setHealthregister(rs.getString("healthregister"));
                medicine.setDescription(rs.getString("description"));
                medicine.setDescriptionshort(rs.getString("descriptionshort"));
                medicine.setNamerol(rs.getString("namerol"));
                medicine.setCodemodeadmin(rs.getInt("codemodeadmin"));
                medicine.setCodeap(rs.getInt("codeap"));
                medicine.setIdum(rs.getInt("idum"));
                medicine.setCodelab(rs.getInt("codelab"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicine;
    }
}
