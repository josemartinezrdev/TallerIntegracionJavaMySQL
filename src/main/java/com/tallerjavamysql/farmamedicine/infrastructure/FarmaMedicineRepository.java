package com.tallerjavamysql.farmamedicine.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;
import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class FarmaMedicineRepository implements FarmaMedicineService {

    private Connection connection;

    public FarmaMedicineRepository() {
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
    public void createFarmaMedicine(FarmaMedicine farmaMedicine) {
        try {
            String query = "INSERT INTO farmacymedicine (idfarmacy, idmedicine, price) " +
                    "VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmaMedicine.getIdfarmacy());
            ps.setInt(2, farmaMedicine.getIdmedicine());
            ps.setFloat(3, farmaMedicine.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFarmaMedicine(int idfarmacy, int idmedicine) {
        try {
            String query = """
                    DELETE FROM farmacymedicine WHERE idfarmacy = ? AND idmedicine = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idfarmacy);
            ps.setInt(2, idmedicine);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FarmaMedicine> findAllFarmaMedicines() {
        List<FarmaMedicine> farmaMedicines = new ArrayList<>();
        try {
            // String query = """
            // SELECT f.namefarmacy, m.namemedicine, fm.price
            // FROM farmacymedicine fm
            // INNER JOIN farmacy f ON fm.idfarmacy = f.idfarmacy
            // INNER JOIN medicine m ON fm.idmedicine = m.id
            // """;
            String query = "SELECT idfarmacy, idmedicine, price FROM farmacymedicine ORDER BY idfarmacy ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                FarmaMedicine farmacymedicine = new FarmaMedicine(
                        rs.getInt("idfarmacy"),
                        rs.getInt("idmedicine"),
                        rs.getFloat("price"));
                farmaMedicines.add(farmacymedicine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farmaMedicines;
    }

    @Override
    public void updateFarmaMedicine(FarmaMedicine farmaMedicine, int idfarmacy, int idmedicine) {
        try {
            String query = """
                    UPDATE farmacymedicine SET idfarmacy = ?, idmedicine = ?, price = ? WHERE
                    idfarmacy = ? AND idmedicine = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, farmaMedicine.getIdfarmacy());
            ps.setInt(2, farmaMedicine.getIdmedicine());
            ps.setFloat(3, farmaMedicine.getPrice());

            ps.setInt(4, idfarmacy);
            ps.setInt(5, idmedicine);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FarmaMedicine findByIdFarmaMedicine(int idfarmacy, int idmedicine) {
        FarmaMedicine farmamedicine = new FarmaMedicine();
        try {
            String query = """
                    SELECT idfarmacy, idmedicine, price FROM farmacymedicine WHERE idfarmacy = ? AND idmedicine = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idfarmacy);
            ps.setInt(2, idmedicine);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                farmamedicine.setIdfarmacy(rs.getInt("idfarmacy"));
                farmamedicine.setIdmedicine(rs.getInt("idmedicine"));
                farmamedicine.setPrice(rs.getFloat("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farmamedicine;
    }
}
